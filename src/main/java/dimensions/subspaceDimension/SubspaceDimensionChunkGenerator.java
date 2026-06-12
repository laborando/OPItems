package dimensions.subspaceDimension;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.util.noise.SimplexOctaveGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SubspaceDimensionChunkGenerator extends ChunkGenerator {
    int currentHeight;

    public SubspaceDimensionChunkGenerator() {
        this.currentHeight = 50;
    }

    @Override
    public List<BlockPopulator> getDefaultPopulators(World world) {

        return new ArrayList<>();

    }

    public ChunkData generateChunkData(final World world, final Random random, final int chunkX, final int chunkZ, final BiomeGrid biome) {

        final SimplexOctaveGenerator generator = new SimplexOctaveGenerator(new Random(world.getSeed()), 8);

        final ChunkData chunk = createChunkData(world);

        generator.setScale(0.015);
        for (int X = 0; X < 16; ++X) {
            for (int Z = 0; Z < 16; ++Z) {

                chunk.setBlock(X, currentHeight = (int) (generator.noise(chunkX * 16 + X, chunkZ * 16 + Z, 0.5, 0.5) * 3 + 50.0), Z, Material.STONE);
                chunk.setBlock(X, currentHeight - 1, Z, Material.STONE);


                //STONE & ORES
                for (int i = currentHeight - 2; i > 0; --i) {

                    chunk.setBlock(X, i, Z, Material.STONE);
                    final int rnd = randomrange(0, 100);
                    if (rnd == 0) {
                        chunk.setBlock(X, i, Z, Material.LAVA);
                    }

                }
                chunk.setBlock(X, 0, Z, Material.BEDROCK);

            }
        }
        return chunk;
    }

    private static int randomrange(final int min, final int max) {
        if (min >= max) {
            return 1;
        }
        final Random r = new Random();
        return r.nextInt(max - min + 1) + min;
    }
}
