package play.brainsynder.SubCommands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import play.brainsynder.Group;
import play.brainsynder.Messages;

public class InvitePlayer {

    public static void onInvite(CommandSender cs, String pn) {
        if (cs.hasPermission("rollplay.invite")) {
            try {
                if (Group.getGroupName((Player) cs) != null) {
                    if (!cs.getName().equalsIgnoreCase(pn)) {
                        boolean found = false;
                        for (Player player : Bukkit.getOnlinePlayers()) {
                            if (player.getName().equalsIgnoreCase(pn)) {
                                found = true;
                                if (Group.getGroupName(player) != null) {
                                    if (Group.getGroupName(player).equalsIgnoreCase(Group.getGroupName((Player) cs))) {
                                        cs.sendMessage(Messages.IpnAlreadyInGroup);
                                    } else if (Group.isAdmin(pn) || Group.isMember(pn)) {
                                        cs.sendMessage(Messages.pnTaken.replaceAll("%p", pn));
                                    } else {
                                        Group.invitePlayer(cs.getName(), Group.getGroupName((Player) cs), player, cs);
                                        cs.sendMessage(Messages.inviteSuccess.replaceAll("%p", pn));
                                    }
                                }
                            }
                        }
                        if (!found) {
                            cs.sendMessage(Messages.pnNotFound.replaceAll("%p", pn));
                        }
                    } else {
                        cs.sendMessage(Messages.invalidInvite);
                    }
                } else {
                    cs.sendMessage(Messages.pnNotInGroup);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
