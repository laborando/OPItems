package cmd;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class TabComp implements TabCompleter {

	public List<String> onTabComplete(final CommandSender sender, final Command command, final String alias, final String[] args) {
        if (command.getName().equalsIgnoreCase("opitems")){
            if(args.length == 1){
                final List<String> completions = new ArrayList<String>();
                completions.add("help");
                completions.add("gui");
                completions.add("give");
                completions.add("update");
                completions.add("recipes");
                completions.add("skull");
                completions.add("version");
                completions.add("upgradeItems");
                return completions;
            }
            if(args.length == 2){
                if(args[0].trim().equalsIgnoreCase("give")){
                    final List<String> completions = new ArrayList<String>();

                    completions.add("KnockyTheStick");
                    completions.add("TheBlockySword");
                    completions.add("TheAntiDamage");
                    completions.add("Bower");
                    completions.add("Blazer");
                    completions.add("Boomer");
                    completions.add("PickyPick");
                    completions.add("PigCannon");
                    completions.add("PigSpawnEgg");
                    completions.add("EndSword");
                    completions.add("Blitzer");
                    completions.add("Crafter");
                    completions.add("FlyFeather");
                    completions.add("AntiFall");
                    completions.add("HookOfVelectory");
                    completions.add("NightVisor");
                    completions.add("WaterHelmet");
                    completions.add("FireShoes");
                    completions.add("Launcher");
                    completions.add("WandOfBoom");
                    completions.add("WandOfMassiveBoom");
                    completions.add("WandOfInvisibility");
                    completions.add("SpeedLeggings");
                    completions.add("SuperSponge");
                    completions.add("LavaSponge");
                    completions.add("EnderPearler");
                    completions.add("TNTDetonator");
                    completions.add("CursedSword");
                    completions.add("PocketDimensionWand");
                    completions.add("AntiExplosionHelmet");
                    completions.add("WandOfHome");
                    completions.add("TNTBow");
                    completions.add("WandOfBlocks");
                    completions.add("Portal2Go");
                    completions.add("SkullImitator");
                    completions.add("Landmine");
                    completions.add("Defuser");
                    completions.add("InfiniteWaterBucket");
                    completions.add("ProtectivElytra");
                    completions.add("WandOfWarden");
                    completions.add("JumpyBoots");
                    completions.add("Piercer");
                    if(args[1] == null || args[1].trim().isEmpty()){
                        return completions;
                    }


                    List<String> realCompletions = new ArrayList<>();

                    for (String completion : completions) {

                        if (completion.toLowerCase().startsWith(args[1].trim().toLowerCase()))
                            realCompletions.add(completion);

                    }

                    return realCompletions;
                }
            }
            if(args.length == 3){
                if(args[0].trim().equalsIgnoreCase("give")){
                    final List<String> completions = new ArrayList<String>();

                    Bukkit.getOnlinePlayers().forEach(e -> {
                        completions.add(e.getName());
                    });

                    return completions;
                }
            }
        }

        if (command.getName().equalsIgnoreCase("items") && args.length == 1) {
            final List<String> completions = new ArrayList<String>();
            completions.add("remove");
            completions.add("player_heap");
            return completions;
        }
        return null;
    }
	
}
