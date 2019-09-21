package top.scraft.mcbadapple;

import net.minecraft.tileentity.TileEntity;

public class BadAppleTileEntity extends TileEntity {

    public int frame = 0;

    @Override
    public void updateEntity() {
        if (hasWorldObj() && !getWorldObj().isRemote) {
            if (getWorldObj().isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord)) {
                //System.out.println("RS ON");
                if (frame < 4383) {
                    frame++;
                }
            } else {
                //System.out.println("RS OFF");
                frame = 0;
            }
            //System.out.println(frame);
        }
    }
}
