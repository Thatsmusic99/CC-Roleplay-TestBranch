package play.brainsynder.SubCommands;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import play.brainsynder.Group;
import play.brainsynder.Messages;

import java.util.HashMap;
import java.util.List;

public class InviteAccept {

    private static HashMap<String, List<String>> invites = Group.invites;
    public static boolean response = false;
    private static boolean response2 = Group.response2;

    public static void onAccept(Player p) {
        if (p.hasPermission("rollplay.invite.accept")) {
            if (invites.get(p.getName()) != null || invites.get(p.getName()).size() > 0) {
                String gn = invites.get(p.getName()).get(0);
                Group.addPlayer(gn, p, p.getUniqueId().toString());
                response = true;
                response2 = true;
                p.sendMessage(Messages.joined);
                for (Player pl : Bukkit.getOnlinePlayers()) {
                    if (Group.isMember(pl.getUniqueId().toString())) {
                        pl.sendMessage(Messages.memberJoined.replaceAll("%s", p.getName()));
                    } else if (Group.isAdmin(pl.getUniqueId().toString())) {
                        pl.sendMessage(Messages.memberJoined.replaceAll("%s", p.getName()));
                    }
                }
            } else {
                p.sendMessage(Messages.noInvites);
            }
        } else {
            p.sendMessage(Messages.noPerms);
        }
    }
    public static void onAcceptArgs(String gn, Player p) {
        if (p.hasPermission("rollplay.invite.accept")) {
            if (invites.get(p.getName()) != null || invites.get(p.getName()).size() > 0) {
                if (invites.get(p.getName()).contains(gn)) {
                    Group.addPlayer(gn, p, p.getUniqueId().toString());
                    response = true;
                    response2 = true;
                    p.sendMessage(Messages.joined);
                    for (Player pl : Bukkit.getOnlinePlayers()) {
                        if (Group.isMember(pl.getUniqueId().toString())) {
                            pl.sendMessage(Messages.memberJoined.replaceAll("%s", p.getName()));
                        } else if (Group.isAdmin(pl.getUniqueId().toString())) {
                            pl.sendMessage(Messages.memberJoined.replaceAll("%s", p.getName()));
                        }
                    }
                } else {
                    p.sendMessage(Messages.invalidInvite2.replaceAll("%s", gn));
                }
            } else {
                p.sendMessage(Messages.noInvites);
            }
        } else {
            p.sendMessage(Messages.noPerms);
        }
    }
}
