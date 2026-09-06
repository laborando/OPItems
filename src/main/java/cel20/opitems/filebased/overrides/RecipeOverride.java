package cel20.opitems.filebased.overrides;

import org.bukkit.Material;

public class RecipeOverride {

    /**
     * ID of the item to be overridden
     */
    public int id;

    //Air is needed instead of null!
    public Material[] materials = new Material[9];

    /**
     * Sets the material at slot to m <br> <br>
     * Slots: <br>
     * 0 1 2 <br>
     * 3 4 5 <br>
     * 6 7 8
     */
    public void setMaterial(int slot, Material m){
        materials[slot] = m;
    }

    //Per-line Buidler

    public void executeInstruction(String line) {

        String instruction = line.trim().replace(" ", "");

        if(instruction.startsWith("#"))
            return;

        String action = instruction.split("=")[0];
        String target = instruction.split("=")[1];

        if(action.equals("target")){
            id =  Integer.parseInt(target);
            return;
        }





        //No set instruction left - Can now parse
        int slot = Integer.parseInt(action);

        Material m = Material.valueOf(target);

        setMaterial(slot, m);
    }
}
