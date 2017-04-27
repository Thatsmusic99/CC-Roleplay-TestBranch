package play.brainsynder; // TM's edit

import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {

    private static Core instance;
    // private static PluginManager pm = Bukkit.getPluginManager(); - Used for registering events in the future
    public Configuration file;

    public static Core getInstance() {
        return instance;
    }

    @Override public void onEnable() {
        instance = this;
        Configuration.setupConfig(this);
        file = new Configuration(this.getDataFolder(), "groups.yml");
        this.getCommand("rp").setExecutor(new RPCommand());
    }
}
