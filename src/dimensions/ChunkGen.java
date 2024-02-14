
package dimensions;

import cel20.op.Main;
import org.bukkit.*;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.util.noise.SimplexOctaveGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.bukkit.generator.ChunkGenerator;
import sun.reflect.generics.tree.Tree;

public class ChunkGen extends ChunkGenerator
{
    int currentHeight;
    
    public ChunkGen() {
        this.currentHeight = 50;
    }

    @Override
    public List<BlockPopulator> getDefaultPopulators(World world) {
        return Arrays.asList(new TreePop());
    }

    public ChunkGenerator.ChunkData generateChunkData(final World world, final Random random, final int chunkX, final int chunkZ, final ChunkGenerator.BiomeGrid biome) {
        final SimplexOctaveGenerator generator = new SimplexOctaveGenerator(new Random(world.getSeed()), 8);
        final ChunkGenerator.ChunkData chunk = this.createChunkData(world);
        generator.setScale(0.015);
        for (int X = 0; X < 16; ++X) {
            for (int Z = 0; Z < 16; ++Z) {
                chunk.setBlock(X, this.currentHeight = (int)(generator.noise((double)(chunkX * 16 + X), (double)(chunkZ * 16 + Z), 0.5, 0.5) * 15.0 + 50.0), Z, Material.GRASS_BLOCK);

                //Oberster Layer
                chunk.setBlock(X, this.currentHeight - 1, Z, Material.DIRT);


                //STONE & ORES
                for (int i = this.currentHeight - 2; i > 0; --i) {

                    chunk.setBlock(X, i, Z, Material.STONE);
                    final int rnd = randomrange(0, Main.ore_gen_chance_private_dim);
                    if (rnd == 0) {
                        chunk.setBlock(X, i, Z, Material.DIAMOND_ORE);
                    }
                    else if (rnd == 1) {
                        chunk.setBlock(X, i, Z, Material.REDSTONE_ORE);
                    }
                    else if (rnd == 2) {
                        chunk.setBlock(X, i, Z, Material.IRON_ORE);
                    }
                    else if (rnd == 4) {
                        chunk.setBlock(X, i, Z, Material.COAL_ORE);
                    }
                    else if (rnd != 5) {
                        if (rnd == 6) {
                            chunk.setBlock(X, i, Z, Material.GOLD_ORE);
                        }
                        else if (rnd == 7) {
                            chunk.setBlock(X, i, Z, Material.ANCIENT_DEBRIS);
                        }
                    }
                }


                    for (int i = 40; i > 0; i--) {
                        //WATER
                        if ((chunk.getBlockData(X, i, Z).getMaterial() == Material.AIR) && i <= 40) {
                            chunk.setBlock(X, i, Z, Material.WATER);
                            if ((chunk.getBlockData(X, i-1, Z).getMaterial() == Material.GRASS_BLOCK)) {
                                chunk.setBlock(X, i-1, Z, Material.DIRT);
                            }
                        }
                    }



                    chunk.setBlock(X, 0, Z, Material.BEDROCK);

                    if(randomrange(0, 100) == 100){

                        //world.generateTree(new Location(world, X, currentHeight, Z), TreeType.BIG_TREE);
                    }

            }
        }
        return chunk;
    }
    
    private static int randomrange(final int min, final int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min!");
        }
        final Random r = new Random();
        return r.nextInt(max - min + 1) + min;
    }
}
