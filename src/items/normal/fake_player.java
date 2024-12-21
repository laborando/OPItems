
package items.normal;

import net.minecraft.server.v1_16_R3.*;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import com.mojang.authlib.GameProfile;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class fake_player extends EntityPlayer {

    private final Location loc;






    public fake_player(WorldServer ws, GameProfile gp, Location loc) {
        super(MinecraftServer.getServer(), ws, gp, new PlayerInteractManager(ws));
        this.loc = loc;
        setLocation(loc.getX(), loc.getY(), loc.getZ(), loc.getYaw(), loc.getPitch()); // set location
    }

    public void spawn() {
        for (Player pl : Bukkit.getOnlinePlayers()) {
            spawnFor(pl); // send all spawn packets
        }
    }

    public void spawnFor(Player p) {
        PlayerConnection connection = ((CraftPlayer) p).getHandle().playerConnection;

        // add player in player list for player
        connection.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER, this));

        // make player spawn in world
        connection.sendPacket(new PacketPlayOutNamedEntitySpawn(this));

        // change head rotation
        connection.sendPacket(new PacketPlayOutEntityHeadRotation(this, (byte) ((loc.getYaw() * 256f) / 360f)));

        //byebye
        connection.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.REMOVE_PLAYER, this));
    }

    public void remove() {
        this.die();
    }

    public boolean isEntity(Entity et) {
        return this.getId() == et.getId(); // check if it's this entity
    }
}
