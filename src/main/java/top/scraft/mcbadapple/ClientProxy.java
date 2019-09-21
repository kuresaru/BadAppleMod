package top.scraft.mcbadapple;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.DimensionManager;

public class ClientProxy extends CommonProxy {
    @Override
    public void registerRenderer() {
        RenderingRegistry.registerBlockHandler(BadAppleMod.badAppleRenderID,
                new BadAppleSBRH());
        ClientRegistry.bindTileEntitySpecialRenderer(BadAppleTileEntity.class,
                new BadAppleTESR());
    }

    @Override
    public <T extends TileEntity> T getServerTE(T te) {
        // TODO 自动生成的方法存根
        if (te == null) return null;
        if (Minecraft.getMinecraft().isSingleplayer() && te.getWorldObj() != null && te.getWorldObj().isRemote) {
            WorldServer ws = DimensionManager.getWorld(te.getWorldObj().provider.dimensionId);
            if (ws != null && ws.getChunkProvider() != null) {
                Chunk c = ws.getChunkFromBlockCoords(te.xCoord, te.zCoord);
                if (c != null) {
                    TileEntity t = c.getTileEntityUnsafe(te.xCoord & 0xf, te.yCoord, te.zCoord & 0xf);
                    if (t != null && t.getClass().equals(te.getClass())) {
                        return (T) t;
                    }
                }
            }
        }
        return te;
    }
}
