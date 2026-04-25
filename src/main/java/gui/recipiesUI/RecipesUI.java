package gui.recipiesUI;

import org.bukkit.entity.Player;

public class RecipesUI {

    public static void ShowRecipes(Player player) {

        RecipeGuiCreator.generateInventory(player, 0);

    }

}
