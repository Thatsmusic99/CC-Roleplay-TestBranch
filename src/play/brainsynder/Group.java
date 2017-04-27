package play.brainsynder;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import play.brainsynder.SubCommands.InviteAccept;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Group {

    private static Configuration file = Core.getInstance().file;
    private static boolean found;
    public static HashMap<String, List<String>> invites = new HashMap<>();
    private static boolean response = InviteAccept.response;
    private static boolean found2;
    public static boolean response2;

    public static String getGroupName(Player p) {
        for (String key : file.getKeys(false)) {
            for (String admins : file.getStringList(key + ".admins")) {
                if (p.getUniqueId().toString().equals(admins)) {
                    found = true;
                    return key;
                }
            }
            if (!found) {
                for (String members : file.getStringList(key + ".members")) {
                    if (p.getUniqueId().toString().equals(members)) {
                        found = true;
                        return key;
                    }
                }
            }
        }
        return null;
    }

    public static boolean isAvailable(String gn) {
        for (String key : file.getKeys(false)) {
            if (key.equalsIgnoreCase(gn)) {
                return false;
            }
        }
        return true;
    }
    public static boolean isAdmin(String puuid) {
        for (String key : file.getKeys(false)) {
            if (file.getStringList(key + ".admins").contains(puuid)) {
                return true;
            }
        }
        return false;
    }
    public static boolean isMember(String puuid) {
        for (String key : file.getKeys(false)) {
            if (file.getStringList(key + ".members").contains(puuid)) {
                return true;
            }
        }
        return false;
    }

    public static void createGroup(String gn, CommandSender cs) {
        List<String> admins = new ArrayList<>(Collections.singletonList(((Player) cs).getUniqueId().toString()));
        file.set(gn + ".admins", admins);
        List<String> members = new ArrayList<>();
        file.set(gn + ".members", members);
    }
    public static void deleteGroup(String gn) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (invites.containsKey(p.getName())) {
                if (invites.get(p.getName()).contains(gn)) {
                    invites.get(p.getName()).remove(gn);
                    p.sendMessage(Messages.groupDisband.replaceAll("%s", gn));
                }
            }
        }
        file.set(gn, null);
    }
    public static void invitePlayer(String pn, String gn, Player ipn, CommandSender cs) {
        invites.get(ipn.getName()).add(gn);
        ipn.sendMessage(Messages.invite.replaceAll("%s", gn).replaceAll("%p", pn));
        while (!response) {
            try {
                Thread.sleep(120000);
                invites.get(ipn.getName()).remove(gn);
                ipn.sendMessage(Messages.inviteExpired);
                cs.sendMessage(Messages.inviteExpired);
                return;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (response2) {
            cs.sendMessage(Messages.memberAccepted);
        } else {
            cs.sendMessage(Messages.memberDenied);
        }
    }
    public static void addPlayer(String gn, Player p, String puuid) {

        for (String key : file.getKeys(false)) {
            if (gn.equalsIgnoreCase(key)) {
                found2 = true;
                file.getStringList(gn + ".members").add(puuid);
                return;
            }
        }
        if (!found2) {
            p.sendMessage(Messages.invalidGroup);
        }
    }
    public static void removePlayer(String gn, Player p, String puuid) {
        file.getStringList(gn + ".members").remove(puuid);
        for (Player pl : Bukkit.getOnlinePlayers()) {
            if (Group.isMember(pl.getUniqueId().toString())) {
                pl.sendMessage(Messages.memberLeft.replaceAll("%p", p.getName()));
            } else if (Group.isAdmin(pl.getUniqueId().toString())) {
                pl.sendMessage(Messages.memberLeft.replaceAll("%p", p.getName()));
            }
        }
    }
}
