package items.allRecipes;

import items.abracator.CItem;
import org.bukkit.Material;

public class RecipeAdder {

    public static void addOPItemsRecipes(){

        CItem.getOPBuilder(1)
            .setMaterialAt(Material.SLIME_BLOCK, 1)
            .setMaterialAt(Material.BAMBOO, 4, 7)
            .build();

        CItem.getOPBuilder(2)
                .setMaterialAt(Material.BAMBOO, 4, 7)
                .setMaterialAt(Material.NETHERITE_BLOCK, 1)
                .build();

    }

}
