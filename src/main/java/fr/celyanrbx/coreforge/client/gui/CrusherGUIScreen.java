package fr.celyanrbx.coreforge.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import fr.celyanrbx.coreforge.procedures.*;
import fr.celyanrbx.coreforge.world.inventory.CrusherGUIMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.HashMap;

public class CrusherGUIScreen extends AbstractContainerScreen<CrusherGUIMenu> {
    private final static HashMap<String, Object> guistate = CrusherGUIMenu.guistate;
    private final Level world;
    private final int x, y, z;
    private final Player entity;

    public CrusherGUIScreen(CrusherGUIMenu container, Inventory inventory, Component text) {
        super(container, inventory, text);
        this.world = container.world;
        this.x = container.x;
        this.y = container.y;
        this.z = container.z;
        this.entity = container.entity;
        this.imageWidth = 176;
        this.imageHeight = 166;
    }

    private static final ResourceLocation texture = ResourceLocation.parse("coreforge:textures/screens/crusher_gui.png");

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
        RenderSystem.setShaderColor(1, 1, 1, 1);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
        if (ProgressBarDisplay0Procedure.execute(world, x, y, z)) {
            guiGraphics.blit(ResourceLocation.parse("coreforge:textures/screens/progress_bar_empty.png"), this.leftPos + 59, this.topPos + 37, 0, 0, 54, 10, 54, 10);
        }
        if (ProgressBarDisplay1Procedure.execute(world, x, y, z)) {
            guiGraphics.blit(ResourceLocation.parse("coreforge:textures/screens/progress_bar_filled_0.png"), this.leftPos + 59, this.topPos + 37, 0, 0, 54, 10, 54, 10);
        }
        if (ProgressBarDisplay11Procedure.execute(world, x, y, z)) {
            guiGraphics.blit(ResourceLocation.parse("coreforge:textures/screens/progress_bar_filled_1.png"), this.leftPos + 59, this.topPos + 37, 0, 0, 54, 10, 54, 10);
        }
        if (ProgressBarDisplay21Procedure.execute(world, x, y, z)) {
            guiGraphics.blit(ResourceLocation.parse("coreforge:textures/screens/progress_bar_filled_2.png"), this.leftPos + 59, this.topPos + 37, 0, 0, 54, 10, 54, 10);
        }
        if (ProgressBarDisplay31Procedure.execute(world, x, y, z)) {
            guiGraphics.blit(ResourceLocation.parse("coreforge:textures/screens/progress_bar_filled_3.png"), this.leftPos + 59, this.topPos + 37, 0, 0, 54, 10, 54, 10);
        }
        if (ProgressBarDisplay41Procedure.execute(world, x, y, z)) {
            guiGraphics.blit(ResourceLocation.parse("coreforge:textures/screens/progress_bar_filled_4.png"), this.leftPos + 59, this.topPos + 37, 0, 0, 54, 10, 54, 10);
        }
        if (ProgressBarDisplay51Procedure.execute(world, x, y, z)) {
            guiGraphics.blit(ResourceLocation.parse("coreforge:textures/screens/progress_bar_filled_5.png"), this.leftPos + 59, this.topPos + 37, 0, 0, 54, 10, 54, 10);
        }
        if (ProgressBarDisplay61Procedure.execute(world, x, y, z)) {
            guiGraphics.blit(ResourceLocation.parse("coreforge:textures/screens/progress_bar_filled_6.png"), this.leftPos + 59, this.topPos + 37, 0, 0, 54, 10, 54, 10);
        }
        if (ProgressBarDisplay71Procedure.execute(world, x, y, z)) {
            guiGraphics.blit(ResourceLocation.parse("coreforge:textures/screens/progress_bar_filled_7.png"), this.leftPos + 59, this.topPos + 37, 0, 0, 54, 10, 54, 10);
        }
        if (ProgressBarDisplay81Procedure.execute(world, x, y, z)) {
            guiGraphics.blit(ResourceLocation.parse("coreforge:textures/screens/progress_bar_filled_8.png"), this.leftPos + 59, this.topPos + 37, 0, 0, 54, 10, 54, 10);
        }
        if (ProgressBarDisplay91Procedure.execute(world, x, y, z)) {
            guiGraphics.blit(ResourceLocation.parse("coreforge:textures/screens/progress_bar_filled_9.png"), this.leftPos + 59, this.topPos + 37, 0, 0, 54, 10, 54, 10);
        }
        RenderSystem.disableBlend();
    }

    @Override
    public boolean keyPressed(int key, int b, int c) {
        if (key == 256) {
            this.minecraft.player.closeContainer();
            return true;
        }
        return super.keyPressed(key, b, c);
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
    }

    @Override
    public void init() {
        super.init();
    }
}
