package play.brainsynder;

import org.bukkit.ChatColor;

public class Messages {

    static String tma = ChatColor.RED + "Too many arguments!";
    static String nea = ChatColor.RED + "Not enough arguments!";
    static String consoleAccess = ChatColor.RED + "You have to be a player to use this command!";
    static String inviteExpired = ChatColor.RED + "The invite you sent has expired!";
    public static String cannotKick = ChatColor.RED + "You can not kick this player from the group!";

    public static String gnTaken = ChatColor.RED + "The name %s has already been taken!"; // %s is the group name
    public static String createSuccess = ChatColor.GREEN + "Group %s has been created!"; // %s is the group name
    public static String deleteSuccess = ChatColor.GREEN + "Group %s has been deleted!"; // %s is the group name
    public static String noGroup = ChatColor.RED + "%s is not a group!"; // %s is the group name
    static String invite = ChatColor.GREEN + "You have been invited to %s by %p, do /rp accept to accept or /rp deny to deny!"; // %s is the group name, %p is the player name
    public static String pnTaken = ChatColor.RED + "%p is already in a group!"; // %p is the player name
    public static String pnNotFound = ChatColor.RED + "%p was not found!"; // %p is the player name
    public static String inviteSuccess = ChatColor.GREEN + "Successfully invited %p to your group!"; // You get the idea now.
    public static String IpnAlreadyInGroup = ChatColor.RED + "%p is already in your group!";
    public static String invalidInvite2 = ChatColor.RED + "You have no pending invites for %s!";
    static String groupDisband = ChatColor.RED + "Group %s has been disbanded!";
    public static String memberJoined = ChatColor.GREEN + "%p has joined the group!";
    static String memberLeft = ChatColor.GREEN + "%p has left the group!";
    static String memberAccepted = ChatColor.GREEN + "%p has accepted your invite!";
    static String memberDenied = ChatColor.RED + "%p has denied your invite!";

    public static String joined = ChatColor.GREEN + "You have successfully joined the group.";
    public static String left = ChatColor.GREEN + "You have successfully left the group.";
    public static String denied = ChatColor.GREEN + "Invite denied!";
    public static String pnAlreadyInGroup = ChatColor.RED + "You are already in a group!";
    public static String noPerms = ChatColor.RED + "You do not have permission to use this command!";
    public static String alphaNames = ChatColor.RED + "Please only use alphanumeric names!";
    public static String noPerms2 = ChatColor.RED + "You can not use this command!";
    public static String invalidInvite = ChatColor.RED + "You can not invite yourself!";
    public static String noInvites = ChatColor.RED + "You do not have any pending invites!";
    static String invalidGroup = ChatColor.RED + "The group is no longer valid!";
    public static String pnNotInGroup = ChatColor.RED + "You are not in a group!";
    public static String kicked = ChatColor.RED + "You were kicked from the group!";
    public static String kickys = ChatColor.RED + "You cannot kick yourself!";
}
