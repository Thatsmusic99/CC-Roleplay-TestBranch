package play.brainsynder.SubCommands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import play.brainsynder.Group;
import play.brainsynder.Messages;

public class DeleteGroup {

    public static void groupDelete(CommandSender cs, Player p) {
        if (cs.hasPermission("rollplay.delete")) {
            try {
               if (Group.isAdmin(p.getUniqueId().toString()) && !Group.isAvailable(Group.getGroupName(p))) {
                   String gn = Group.getGroupName(p);
                   Group.deleteGroup(gn);
                   cs.sendMessage(Messages.deleteSuccess.replaceAll("%s", gn));
               } else if (Group.isMember(p.getUniqueId().toString())) {
                   cs.sendMessage(Messages.noPerms2);
               }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            cs.sendMessage(Messages.noPerms);
        }

    }
    public static void groupDeleteConsole(String gn, CommandSender cs) {
        try {
            if (!Group.isAvailable(gn)) {
                Group.deleteGroup(gn);
                cs.sendMessage(Messages.deleteSuccess.replaceAll("%s", gn));
            } else {
                cs.sendMessage(Messages.noGroup.replaceAll("%s", gn));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void groupDelete2(CommandSender cs, String gn) {
        if (cs.hasPermission("rollplay.delete.others")) {
            try {
                if (!Group.isAvailable(gn)) {
                    Group.deleteGroup(gn);
                    cs.sendMessage(Messages.deleteSuccess.replaceAll("%s", gn));
                } else {
                    cs.sendMessage(Messages.noGroup.replaceAll("%s", gn));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            cs.sendMessage(Messages.noPerms);
        }
    }
}
