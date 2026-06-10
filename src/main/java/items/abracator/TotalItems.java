package items.abracator;

import cel20.op.Main;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

/**
 * Classs for managing all OPItems and their respective recipes
 */
public class TotalItems {

    public static List<CItem> items = new ArrayList<>();

    public static List<StringIDAssociator> itemIds = new ArrayList<>();

    public static void addAllRecipes() {

        Main.getInstance().getLogger().info("Registered Recipes: " + items.size());

        for (CItem item : items) {

            itemIds.add(new StringIDAssociator(item.id, item.name));

            try{

                Bukkit.getServer().addRecipe(item.recipe);

            }catch(Exception e){

                try {
                    Bukkit.removeRecipe(item.key);

                    Bukkit.getServer().addRecipe(item.recipe);

                    System.out.println(item.name);

                } catch (Exception ex) {
                    Bukkit.getLogger().warning("Failed to add recipe " + item.key);
                }

            }

        }

    }

    public static void removeAllRecipes() {

        for (CItem item : items) {
            Bukkit.getServer().removeRecipe(item.key);
        }

    }

    /**
     * Gets cItem from ID
     * @param id
     * @return
     */
    public static CItem get(int id) {
        for (CItem item : items) {
            if(item.id == id)
                return item;
        }
        return null;
    }

    /**
     * Enables crafting for a certain id
     * @param id
     */
    public static void enable(int id){

        CItem target = get(id);

        target.enabled = true;

        try {
            Bukkit.getServer().addRecipe(target.recipe);
            Bukkit.getServer().updateRecipes();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Disables crafting for a certain id
     */
    public static void disable(int id){

        CItem target = get(id);

        target.enabled = false;

        try {
            Bukkit.getServer().removeRecipe(target.key);
            Bukkit.getServer().updateRecipes();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }



    }

    //------------- LOAD - SAVE --- DISABLED - ITEMS -----------------------

    static File disabledFile;
    static List<String> disabled = new ArrayList<>();


    /**
     * Inits - Must be called first
     * @param p
     */
    public static void innit(Plugin p) {

        disabledFile = new File(p.getDataFolder(), "disabledItems");

        boolean isNew = false;

        try {
            isNew = disabledFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(isNew)
            return;

        load();
    }

    public static void save(){
        try {

            disabledFile.delete();
            disabledFile.createNewFile();

            BufferedWriter writer = Files.newBufferedWriter(disabledFile.toPath(), StandardOpenOption.APPEND);



            StringBuilder toWrite = new StringBuilder();

            for (CItem item : items) {
                if (!item.enabled) {
                    toWrite.append(item.id).append(";");
                }
            }



            writer.write(toWrite.toString());

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void load(){
        try {

            if(!disabledFile.exists()){
                System.out.println(disabledFile.getAbsolutePath() + " doesn't exist?!");
            }

            String blocked = Files.readString(disabledFile.toPath());

            String[] itemsArray =  blocked.split(";");

            disabled.clear();
            disabled.addAll(List.of(itemsArray));

            for (String itemString : disabled) {


                try {
                    int itemID = Integer.parseInt(itemString);

                    for (CItem item : items) {
                        if(item.id == itemID){

                            disable(item.id);

                        }
                    }

                } catch (NumberFormatException ignored) {
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Disables all crafting recipes registered here
     */
    public static void disableCrafting() {

        Bukkit.getLogger().info("Crafting Disabled");

        for (CItem item : items) {

                disable(item.id);

        }
    }
}
