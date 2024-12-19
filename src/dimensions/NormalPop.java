package dimensions;
import utis.celutis;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.generator.BlockPopulator;

import java.util.Random;

public class NormalPop extends BlockPopulator {

    @Override
    public void populate(World world, Random random, Chunk chunk) {


        //TREES
        int amount = random.nextInt(5)+1; //GRASS-AMOUNT
        for (int i = 1; i < amount; i++) {
            int X = random.nextInt(15);
            int Z = random.nextInt(15);
            int Y = 1;
            for(Y = world.getMaxHeight()-1; Y>0 ; Y--){
                if(chunk.getBlock(X, Y, Z).getType() == Material.GRASS_BLOCK){
                    chunk.getBlock(X, Y+1, Z).setType(Material.GRASS);

                    break;
                }
            }
        }
        if (random.nextBoolean()) {
            amount = random.nextInt(4)+1; //TREE-AMOUNT
            for (int i = 1; i < amount; i++) {
                int X = random.nextInt(15);
                int Z = random.nextInt(15);
                int Y = 1;
                for(Y = world.getMaxHeight()-1; Y>0 ; Y--){
                    if(chunk.getBlock(X, Y, Z).getType() == Material.GRASS_BLOCK){
                        world.generateTree(chunk.getBlock(X, Y+1, Z).getLocation(), TreeType.TREE);

                        break;
                    }
                }



            }
        }
    //WATER-SWAMP
        amount = random.nextInt(10)+1; //WATER-AMOUNT
        for (int i = 1; i < amount; i++) {
            int X = random.nextInt(15);
            int Z = random.nextInt(15);
            int Y = 1;

            if(chunk.getBlock(X, 20, Z).getBiome().equals(Biome.SWAMP)){
                for(Y = world.getMaxHeight()-1; Y>0 ; Y--){
                    if(chunk.getBlock(X, Y, Z).getType() == Material.GRASS_BLOCK){

                        if (!celutis.hasAtLeastOneFaceWithoutBlock(chunk.getBlock(X, Y, Z))) {
                            chunk.getBlock(X, Y, Z).setType(Material.WATER);
                        }

                        break;
                    }
                }
            }
        }
        //--------------------------------



    }
}