package top.scraft.mcbadapple;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class BadAppleTESR extends TileEntitySpecialRenderer {

    private ResourceLocation frames[] = new ResourceLocation[4383];
    private ResourceLocation res = new ResourceLocation("badapple",
            "textures/blocks/badapple.png");

    public BadAppleTESR() {
        for (int i = 0; i < frames.length; i++) {
            String img = String.format("img/%05d.png", i + 1);
            //System.out.println(img);
            frames[i] = new ResourceLocation("badapple", img);
        }
    }

    @Override
    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float f) {
        GL11.glPushMatrix();
        GL11.glTranslated(x, y, z);
        //GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        render(BadAppleMod.proxy.getServerTE((BadAppleTileEntity) te));
        GL11.glPopMatrix();
    }

    public void render(BadAppleTileEntity tileEntity) {
        Tessellator tessellator = Tessellator.instance;
        if (tileEntity.frame > 0 && tileEntity.frame < 4384) {
            bindTexture(frames[tileEntity.frame - 1]);
        } else {
            bindTexture(res);
        }
        tessellator.startDrawingQuads();
        //Z+
        tessellator.addVertexWithUV(1, 0, 1, 1, 1);
        tessellator.addVertexWithUV(1, 1, 1, 1, 0);
        tessellator.addVertexWithUV(0, 1, 1, 0, 0);
        tessellator.addVertexWithUV(0, 0, 1, 0, 1);
        //Z-
        tessellator.addVertexWithUV(0, 0, 0, 1, 1);
        tessellator.addVertexWithUV(0, 1, 0, 1, 0);
        tessellator.addVertexWithUV(1, 1, 0, 0, 0);
        tessellator.addVertexWithUV(1, 0, 0, 0, 1);
        //X+
        tessellator.addVertexWithUV(1, 0, 0, 1, 1);
        tessellator.addVertexWithUV(1, 1, 0, 1, 0);
        tessellator.addVertexWithUV(1, 1, 1, 0, 0);
        tessellator.addVertexWithUV(1, 0, 1, 0, 1);
        //X-
        tessellator.addVertexWithUV(0, 0, 1, 1, 1);
        tessellator.addVertexWithUV(0, 1, 1, 1, 0);
        tessellator.addVertexWithUV(0, 1, 0, 0, 0);
        tessellator.addVertexWithUV(0, 0, 0, 0, 1);
        //Y+
        tessellator.addVertexWithUV(0, 1, 1, 1, 1);
        tessellator.addVertexWithUV(1, 1, 1, 1, 0);
        tessellator.addVertexWithUV(1, 1, 0, 0, 0);
        tessellator.addVertexWithUV(0, 1, 0, 0, 1);
        //Y-
        tessellator.addVertexWithUV(0, 0, 0, 1, 1);
        tessellator.addVertexWithUV(1, 0, 0, 1, 0);
        tessellator.addVertexWithUV(1, 0, 1, 0, 0);
        tessellator.addVertexWithUV(0, 0, 1, 0, 1);
        tessellator.draw();
    }
}
