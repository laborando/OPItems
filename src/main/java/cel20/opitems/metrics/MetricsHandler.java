package cel20.opitems.metrics;

import cel20.opitems.op.GlobalVars;
import cel20.opitems.op.Main;

public class MetricsHandler {



    public static Metrics metrics;
    public static boolean apiOn = false; //api_used
    public static boolean recipeOverridesUsed = false; //api_used
    public static boolean statsEnabled = false;

    /**
     * Update var: apiOn
     * @param state isApiOn
     */
    public static void updateAPIState(boolean state){
        apiOn = state;
        updateMetrics();
    }

    /**
     * Update var: recipeOverridesUsed
     * @param recipeOverridesState recipeOverridesUsed?
     */
    public static void updateRecipeState(boolean recipeOverridesState){
        recipeOverridesUsed = recipeOverridesState;
    }

    /**
     * Restart with updated vars
     */
    private static void updateMetrics() {
        stop();
        start();
    }

    /**
     * Starts the Metrics <br>
     * Data will be published directly after this method is executed
     */
    public static void start() {

        if(metrics != null){
            stop();
        }

        statsEnabled = true;
        metrics = new Metrics(Main.getInstance(), 27611);

        metrics.addCustomChart(new Metrics.SimplePie("newer_version_enabled", () -> "true"));


        if (GlobalVars.craftingDisabled) {
            metrics.addCustomChart(new Metrics.SimplePie("crafting_disabled", () -> "true"));
        } else {
            metrics.addCustomChart(new Metrics.SimplePie("crafting_disabled", () -> "false"));
        }

        if (apiOn) {
            metrics.addCustomChart(new Metrics.SimplePie("api_used", () -> "true"));
        } else {
            metrics.addCustomChart(new Metrics.SimplePie("api_used", () -> "false"));
        }

        if (recipeOverridesUsed) {
            metrics.addCustomChart(new Metrics.SimplePie("recipes_overridden", () -> "true"));
        } else {
            metrics.addCustomChart(new Metrics.SimplePie("recipes_overridden", () -> "false"));
        }



    }

    /**
     * Shuts down the metrics service
     */
    public static void stop(){
        metrics.shutdown();
        metrics = null;
    }


}
