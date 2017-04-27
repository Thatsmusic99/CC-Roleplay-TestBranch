package play.brainsynder;

import org.bukkit.plugin.Plugin;
import simple.brainsynder.files.FileMaker;

import java.io.File;

public class Configuration extends FileMaker {


    Configuration(File directory, String fileName) {
        super(directory, fileName);
    }


    static void setupConfig(Plugin p) {
        if (!p.getDataFolder().exists()) {
            p.getDataFolder().mkdirs();
        }

    }

}
