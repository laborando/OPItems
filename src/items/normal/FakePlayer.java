package items.normal;

import cel20.op.Main;
import com.mojang.authlib.GameProfile;
import net.minecraft.server.v1_16_R3.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R3.CraftServer;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.UUID;

public class FakePlayer extends EntityPlayer {

    private final Location loc;

    public FakePlayer(Location loc, String name) {
        super(
                ((CraftServer) Bukkit.getServer()).getServer(),
                ((CraftWorld) loc.getWorld()).getHandle(),
                new GameProfile(UUID.randomUUID(), name),
                new PlayerInteractManager(((CraftWorld) loc.getWorld()).getHandle())
        );
        this.loc = loc;
        setLocation(loc.getX(), loc.getY(), loc.getZ(), loc.getYaw(), loc.getPitch());
    }

    public void spawn() {
        for (Player pl : Bukkit.getOnlinePlayers()) {
            spawnFor(pl);
        }
    }

    public void spawnFor(Player p) {
        PlayerConnection connection = ((CraftPlayer) p).getHandle().playerConnection;

        // Add fake player to tab list
        connection.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER, this));

        // Spawn fake player in the world
        connection.sendPacket(new PacketPlayOutNamedEntitySpawn(this));

        // Head rotation packet
        connection.sendPacket(new PacketPlayOutEntityHeadRotation(this, (byte) ((loc.getYaw() * 256f) / 360f)));

        // Optionally remove from tab list again
        Bukkit.getScheduler().runTaskLater(
                Main.getInstance(),
                () -> connection.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.REMOVE_PLAYER, this)),
                60L
        );
    }

    public void removeFor(Player p) {
        PlayerConnection connection = ((CraftPlayer) p).getHandle().playerConnection;
        connection.sendPacket(new PacketPlayOutEntityDestroy(this.getId()));
    }

    public void remove() {
        for (Player pl : Bukkit.getOnlinePlayers()) {
            removeFor(pl);
        }
        this.die();
    }

    public boolean isEntity(Entity et) {
        return this.getId() == et.getId();
    }
}
