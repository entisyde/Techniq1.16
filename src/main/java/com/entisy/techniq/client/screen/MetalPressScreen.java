package com.entisy.techniq.client.screen;

import java.util.concurrent.atomic.AtomicInteger;

import com.entisy.techniq.Techniq;
import com.entisy.techniq.common.container.MetalPressContainer;
import com.entisy.techniq.common.tileentity.MetalPressTileEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MetalPressScreen extends ContainerScreen<MetalPressContainer> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(Techniq.MOD_ID,
			"textures/gui/metal_press.png");

	public MetalPressScreen(MetalPressContainer container, PlayerInventory inv, ITextComponent title) {
		super(container, inv, title);
		leftPos = 0;
		topPos = 0;
		width = 176;
		height = 165;
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void renderBg(MatrixStack stack, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
		minecraft.getTextureManager().bind(TEXTURE);

		int x = (this.width - this.getXSize()) / 2;
		int y = (this.height - this.getYSize()) / 2;
		this.blit(stack, x, y, 0, 0, getXSize(), getYSize());

		// draw progress bar/arrow
		blit(stack, leftPos + 80, topPos + 35, 0, 166, getMenu().getSmeltProgressionScaled(), 16);
	}

	@Override
	protected void renderLabels(MatrixStack stack, int mouseX, int mouseY) {
		font.draw(stack, title.getContents(), 8.0f, 8.0f, 4210752); // hover text
		font.draw(stack, inventory.getDisplayName().getContents(), 8.0f, 69.0f, 4210752);
	}

	@Override
	public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(matrixStack);
		super.render(matrixStack, mouseX, mouseY, partialTicks);
		this.renderTooltip(matrixStack, mouseX, mouseY);
	}

	@Override
	protected void renderTooltip(MatrixStack matrixStack, int mouseX, int mouseY) {
		super.renderTooltip(matrixStack, mouseX, mouseY);

		if (mouseX >= getGuiLeft() + 154 && mouseX < getGuiLeft() + 154 + 12) {
			if (mouseY >= getGuiTop() + 18 && mouseY < getGuiTop() + 18 + 50) {

				AtomicInteger current = new AtomicInteger();

				this.renderTooltip(matrixStack,
						new StringTextComponent(current.get() + "/" + MetalPressTileEntity.maxEnergy), mouseX, mouseY);
			}
		}
	}
}
