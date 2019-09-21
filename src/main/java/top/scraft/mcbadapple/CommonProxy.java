package top.scraft.mcbadapple;

import net.minecraft.tileentity.TileEntity;

public class CommonProxy {
    public void registerRenderer() {
    }

    public <T extends TileEntity> T getServerTE(T te) {
        return te;
    }
}
