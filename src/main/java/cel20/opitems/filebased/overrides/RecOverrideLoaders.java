package cel20.opitems.filebased.overrides;

import cel20.opitems.op.Main;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class RecOverrideLoaders {

    /**
     * Loads recipe-overrides from 'Datafolder'/overrides/recipes/ and stores them to RecipeOverrides
     */
    public static void load(Plugin plugin) {

        File dir = new File(plugin.getDataFolder().getPath() + "/overrides/recipes");
        dir.mkdirs();

        createReadme(dir);

        List<File> files = Arrays.asList(dir.listFiles());

        if(files.isEmpty()){
            Bukkit.getLogger().info("[OPItems] No recipe-override found");
            return;
        }

        for(File file : files){

            if(file.getName().toLowerCase().contains("readme"))
                continue;

            try {

                RecipeOverride override = new RecipeOverride();

                BufferedReader reader = new BufferedReader(new FileReader(file));

                String line;
                while ((line = reader.readLine()) != null) {

                    if(!(line.isEmpty() || line.startsWith("#")))
                        override.executeInstruction(line);

                }

                RecipeOverrides.add(override);


            } catch (IOException e) {
                e.printStackTrace();
                Bukkit.getLogger().warning("[OPItems] IOException while handling recipe overrides: " + file.getAbsolutePath());
            }


        }

        Bukkit.getLogger().warning("[OPItems] Added  " + (files.size() - 1) + " recipe overrides");

    }

    /**
     * Creates a readme file at the location of dir
     * @param dir
     */
    private static void createReadme(File dir) {
        File file = new File(dir + "/readme.txt");

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            writer.write("#OPItems recipes can be overridden via files placed in this directory.");
            writer.newLine();
            writer.write("#OPItems tries to parse every file except if it has 'readme' in its name.");
            writer.newLine();
            writer.newLine();
            writer.write("#How to use recipe overrides:");
            writer.newLine();
            writer.write("#Comments must be marked with # at the START of a NEW line!");
            writer.newLine();
            writer.write("#Current instructions:");
            writer.newLine();
            writer.write("target=(integer) <- Declares the targeted OPItem by its ID. The id can be found by using /opitems getID or getting the metadata of an OPItem ");
            writer.newLine();
            writer.write("(integer)=(string) <- Sets the ingredient at the slot (integer) to the material (string)");
            writer.newLine();
            writer.write("Slots: ");
            writer.newLine();
            writer.write("0 1 2");
            writer.newLine();
            writer.write("3 4 5");
            writer.newLine();
            writer.write("6 7 8");
            writer.newLine();
            writer.write("Regarding material: The string must match exactly an identifier used to declare an enum constant in this type. For further information see: ");
            writer.newLine();
            writer.write("https://jd.papermc.io/paper/26.2/org/bukkit/Material.html or their reperspective newer version");
            writer.newLine();
            writer.write("Material is case sensitive! Do not set any slot to AIR!");
            writer.newLine();
            writer.newLine();
            writer.write("Example: ");
            writer.newLine();
            writer.write("target=35");
            writer.newLine();
            writer.write("0=DIAMOND");
            writer.newLine();
            writer.write("1=DIAMOND");
            writer.newLine();
            writer.write("6=EMERALD");
            writer.newLine();

            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
            Bukkit.getLogger().warning("[OPItems] Could not write recipe override readme!");
        }
    }
}
