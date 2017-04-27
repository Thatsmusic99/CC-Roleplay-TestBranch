package play.brainsynder.SubCommands;

import org.bukkit.entity.Player;
import play.brainsynder.Group;
import play.brainsynder.Messages;

public class KickPlayer {

    public static void onKick(Player p, Player pl) {
        if (p.hasPermission("rollplay.kick")) {
            if (p != pl) {
                if (Group.isAdmin(p.getUniqueId().toString())) {
                    if (Group.isMember(pl.getUniqueId().toString())) {
                        if (Group.getGroupName(p).equalsIgnoreCase(Group.getGroupName(pl))) {
                            Group.removePlayer(Group.getGroupName(pl), p, pl.getUniqueId().toString());
                            pl.sendMessage(Messages.kicked);
                        }
                    } else if (Group.isAdmin(p.getUniqueId().toString())) {
                        p.sendMessage(Messages.cannotKick);
                    }
                } else {
                    p.sendMessage(Messages.noPerms2);
                }
            } else {
                p.sendMessage(Messages.kickys);
            }
        } else {
            p.sendMessage(Messages.noPerms);
        }
    }

}
