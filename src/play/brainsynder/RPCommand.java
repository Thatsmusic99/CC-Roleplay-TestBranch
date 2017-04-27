package play.brainsynder;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import play.brainsynder.SubCommands.*;

public class RPCommand implements CommandExecutor {

    private Player invitie;


    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String str, String[] args) {

        if (args[0].equalsIgnoreCase("create") && args.length == 1) {
            cs.sendMessage(Messages.nea);
            return true;
        }
        if (args[0].equalsIgnoreCase("create") && args.length == 2) {
            if (cs instanceof Player) {
                CreateGroup.groupCreate(args[1], cs, (Player) cs);
                return true;
            } else {
                cs.sendMessage(Messages.consoleAccess);
                return true;
            }

        }
        if (args[0].equalsIgnoreCase("create") && args.length > 2) {
            cs.sendMessage(Messages.tma);
            return true;
        }
        if (args[0].equalsIgnoreCase("delete") && args.length == 1) {
            if (cs instanceof Player) {
                DeleteGroup.groupDelete(cs, (Player) cs);
                return true;
            } else {
                cs.sendMessage(Messages.nea);
                return true;
            }
        }
        if (args[0].equalsIgnoreCase("delete") && args.length == 2) {
            if (cs instanceof Player) {
                DeleteGroup.groupDelete2(cs, args[1]);
                return true;
            } else {
                DeleteGroup.groupDeleteConsole(args[1], cs);
                return true;
            }
        }
        if (args[0].equalsIgnoreCase("invite") && args.length == 1) {
            cs.sendMessage(Messages.nea);
            return true;
        }
        if (args[0].equalsIgnoreCase("invite") && args.length == 2) {
            if (cs instanceof Player) {
                InvitePlayer.onInvite(cs, args[1]);
                invitie = (Player) cs;
                return true;
            } else {
                cs.sendMessage(Messages.consoleAccess);
                return true;
            }
        }
        if (args[0].equalsIgnoreCase("invite") && args.length > 2) {
            cs.sendMessage(Messages.tma);
            return true;
        }
        if (args[0].equalsIgnoreCase("accept") && args.length == 1) {
            if (cs instanceof Player) {
                InviteAccept.onAccept(invitie);
            } else {
                cs.sendMessage(Messages.consoleAccess);
            }
        }
        if (args[0].equalsIgnoreCase("accept") && args.length == 2) {
            if (cs instanceof Player) {
                InviteAccept.onAcceptArgs(args[1], (Player) cs);
            } else {
                cs.sendMessage(Messages.consoleAccess);
            }
        }
        if (args[0].equalsIgnoreCase("accept") && args.length > 2) {
            cs.sendMessage(Messages.tma);
        }
        if (args[0].equalsIgnoreCase("deny") && args.length == 1) {
            if (cs instanceof Player) {
                InviteDeny.onDeny((Player) cs);
            } else {
                cs.sendMessage(Messages.consoleAccess);
            }
        }
        if (args[0].equalsIgnoreCase("deny") && args.length == 2) {
            if (cs instanceof Player) {
                InviteDeny.onDenyArgs(args[1], (Player) cs);
            } else {
                cs.sendMessage(Messages.consoleAccess);
            }
        }
        if (args[0].equalsIgnoreCase("deny") && args.length > 2) {
            cs.sendMessage(Messages.tma);
        }
        if (args[0].equalsIgnoreCase("leave") && args.length == 1) {
            if (cs instanceof Player) {
                LeaveGroup.onLeaveGroup((Player) cs);
            } else {
                cs.sendMessage(Messages.consoleAccess);
            }
        }
        if (args[0].equalsIgnoreCase("leave") && args.length > 2) {
            cs.sendMessage(Messages.tma);
        }
        if (args[0].equalsIgnoreCase("kick") && args.length ==  1) {
            cs.sendMessage(Messages.nea);
        }
        if (args[0].equalsIgnoreCase("kick") && args.length == 2) {
            if (cs instanceof Player) {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    if (p.getName().equalsIgnoreCase(args[1])) {
                        KickPlayer.onKick((Player) cs, p);
                    }
                }
            } else {
                cs.sendMessage(Messages.consoleAccess);
            }
        }
        if (args[0].equalsIgnoreCase("kick") && args.length > 2) {
            cs.sendMessage(Messages.tma);
        }
        if (args.length == 0) {
            cs.sendMessage(Messages.nea);
            cs.sendMessage(ChatColor.RED + "Help menu is not complete yet."); // Only if planned to continue.
        }
        return false;
    }
}
