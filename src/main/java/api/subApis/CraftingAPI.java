package api.subApis;

import cel20.op.GlobalVars;

public interface CraftingAPI {

    /**
     * Re-enables crafting as configured
     */
    public void enableCrafting();

    /**
     * Disables Crafting
     */
    public void disableCrafting();

    /**
     * Disables specific OPItem <br>
     * Does not override config
     * @param id
     */
    public void disableItem(int id);

    /**
     * Enables specific OPItems <br>
     * Does not override config
     * @param id
     */
    public void enableItem(int id);

}
