package play.brainsynder.SubCommands;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import play.brainsynder.Group;
import play.brainsynder.Messages;

import static play.brainsynder.Group.invites;

public class InviteDeny {

    private static boolean response = InviteAccept.response;
    private static boolean response2 = Group.response2;

    public static void onDeny(Player p) {
        if (p.hasPermission("rollplay.invite.deny")) {
            if (invites.get(p.getName()) != null || invites.get(p.getName()).size() > 0) {
                String gn = invites.get(p.getName()).get(0);
                response = true;
                response2 = false;
                invites.get(p.getName()).remove(gn);
                p.sendMessage(Messages.denied);
            } else {
                p.sendMessage(Messages.noInvites);
            }
        }
    }
    public static void onDenyArgs(String gn, Player p) {
        if (p.hasPermission("rollplay.invite.deny")) {
            if (invites.get(p.getName()) != null || invites.get(p.getName()).size() > 0) {
                if (invites.get(p.getName()).contains(gn)) {
                    invites.get(p.getName()).remove(gn);
                    response = true;
                    response2 = false;
                    p.sendMessage(Messages.denied);
                } else {
                    p.sendMessage(Messages.invalidInvite2.replaceAll("%s", gn));
                }
            } else {
                p.sendMessage(Messages.noInvites);
            }
        }
    }


}
