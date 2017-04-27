package play.brainsynder.SubCommands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import play.brainsynder.Configuration;
import play.brainsynder.Core;
import play.brainsynder.Group;
import play.brainsynder.Messages;

public class CreateGroup {
    private static Configuration file = Core.getInstance().file;
    private static boolean taken;
    private static String group;

    public static void groupCreate(String gn, CommandSender cs, Player p) {
        try {
            if (cs.hasPermission("rollplay.create")) {
                if (gn.matches("^[A-Za-z0-9_]+$")) {
                    if (file.getKeys(false) == null) {
                        Group.createGroup(gn, cs);
                        cs.sendMessage(Messages.createSuccess.replaceAll("%s", gn));
                        return;
                    } else {
                        group = Group.getGroupName(p);
                        taken = Group.isAvailable(gn);
                    }
                    if (!taken) {
                        cs.sendMessage(Messages.gnTaken.replaceAll("%s", gn));
                        taken = false;
                        return;
                    }
                    if (group != null) {
                        cs.sendMessage(Messages.pnAlreadyInGroup);
                    } else {
                        Group.createGroup(gn, cs);
                        cs.sendMessage(Messages.createSuccess.replaceAll("%s", gn));
                    }

                } else {
                    cs.sendMessage(Messages.alphaNames);
                }
            } else {
                cs.sendMessage(Messages.noPerms);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
