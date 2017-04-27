package play.brainsynder.SubCommands;

import org.bukkit.entity.Player;
import play.brainsynder.Configuration;
import play.brainsynder.Core;
import play.brainsynder.Group;
import play.brainsynder.Messages;

public class LeaveGroup {

    private static Configuration file = Core.getInstance().file;

    public static void onLeaveGroup(Player p) {
        if (p.hasPermission("rollplay.leave")) {
            if (Group.getGroupName(p) != null) {
                String gn = Group.getGroupName(p);
                if ((file.getStringList(Group.getGroupName(p) + ".members").size() + file.getStringList(Group.getGroupName(p) + ".admins").size()) == 1) {
                    Group.removePlayer(gn, p, p.getUniqueId().toString());
                    Group.deleteGroup(gn);
                    p.sendMessage(Messages.left);
                } else {
                    Group.removePlayer(gn, p, p.getUniqueId().toString());
                    p.sendMessage(Messages.left);
                }
            } else {
                p.sendMessage(Messages.pnNotInGroup);
            }
        } else {
            p.sendMessage(Messages.noPerms);
        }
    }

}
