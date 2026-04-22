package items.abracator;

import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.List;

public class TotalItems {

    public static List<CItem> items = new ArrayList<>();

    public static void addAllRecipes() {

        for (CItem item : items) {
            Bukkit.getServer().addRecipe(item.recipe);
        }

    }

}
