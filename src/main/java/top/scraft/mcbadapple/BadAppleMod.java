package top.scraft.mcbadapple;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = BadAppleMod.MODID, version = BadAppleMod.VERSION)
public class BadAppleMod {
    public static final String MODID = "badapple";
    public static final String VERSION = "1.0";

    @SidedProxy(serverSide = "top.scraft.mcbadapple.CommonProxy",
            clientSide = "top.scraft.mcbadapple.ClientProxy")
    public static CommonProxy proxy;
    public static int badAppleRenderID = 0;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        badAppleRenderID = RenderingRegistry.getNextAvailableRenderId();
        GameRegistry.registerBlock(new BadAppleBlock(), "badApple");
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.registerRenderer();
    }
}
