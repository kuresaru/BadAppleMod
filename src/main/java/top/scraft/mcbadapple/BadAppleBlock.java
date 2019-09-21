package top.scraft.mcbadapple;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BadAppleBlock extends Block implements ITileEntityProvider {
    protected BadAppleBlock() {
        super(Material.wood);
        setCreativeTab(CreativeTabs.tabMisc);
        setBlockName("badApple");
        setBlockTextureName("badapple:badapple");
        GameRegistry.registerTileEntity(BadAppleTileEntity.class, "BadApple");
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new BadAppleTileEntity();
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public int getRenderType() {
        return BadAppleMod.badAppleRenderID;
    }
}
