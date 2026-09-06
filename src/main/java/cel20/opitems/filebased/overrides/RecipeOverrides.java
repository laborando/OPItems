package cel20.opitems.filebased.overrides;

import java.util.ArrayList;
import java.util.List;

public class RecipeOverrides {

    /**
     * Contains the Overrides for recipes
     */
    static public List<RecipeOverride> overrides = new ArrayList<>();

    /**
     * Register override <br>
     * Must be completed prior to TotalItems.addAllRecipes() is executed!
     */
    public static void add(RecipeOverride toOverride){
        overrides.add(toOverride);
    }

}
