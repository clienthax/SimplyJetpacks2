package tonius.simplyjetpacks.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.model.ModelResourceLocation;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import tonius.simplyjetpacks.client.handler.ClientTickHandler;
import tonius.simplyjetpacks.client.handler.HUDTickHandler;
import tonius.simplyjetpacks.client.handler.KeyTracker;
import tonius.simplyjetpacks.setup.IProxy;

public class ClientProxy implements IProxy {
	//private static final Minecraft mc = Minecraft.getMinecraft();


	public void registerHandlers() {
		MinecraftForge.EVENT_BUS.register(KeyTracker.instance);
		MinecraftForge.EVENT_BUS.register(new ClientTickHandler());
		MinecraftForge.EVENT_BUS.register(new HUDTickHandler());
	}

	public static void registerItemRenderer(ResourceLocation location) {
		ModelLoader.addSpecialModel(location);
	}

	/*
	@Override
	public void showJetpackParticles(World world, EntityLivingBase wearer, ParticleType particle) {
		if (mc.gameSettings.particleSetting == 0 || mc.gameSettings.particleSetting == 1 && mc.world.getTotalWorldTime() % 4L == 0) {

			Random rand = new Random();

			Pos3D playerPos = new Pos3D(wearer).translate(0, 1.5, 0);

			float random = (rand.nextFloat() - 0.5F) * 0.1F;

			//TODO: Maybe only two "fire streams"?
			Pos3D vLeft = new Pos3D(-0.28, -0.95, -0.35).rotatePitch(0).rotateYaw(wearer.renderYawOffset);
			Pos3D vRight = new Pos3D(0.28, -0.95, -0.35).rotatePitch(0).rotateYaw(wearer.renderYawOffset);
			Pos3D vCenter = new Pos3D((rand.nextFloat() - 0.5F) * 0.25F, -0.95, -0.38).rotatePitch(0).rotateYaw(wearer.renderYawOffset);

			Pos3D v = playerPos.translate(vLeft).translate(new Pos3D(wearer.motionX, wearer.motionY, wearer.motionZ));
			ParticleUtils.spawnParticle(particle, world, v.x, v.y, v.z, random, -0.2D, random);

			v = playerPos.translate(vRight).translate(new Pos3D(wearer.motionX, wearer.motionY, wearer.motionZ));
			ParticleUtils.spawnParticle(particle, world, v.x, v.y, v.z, random, -0.2D, random);

			v = playerPos.translate(vCenter).translate(new Pos3D(wearer.motionX, wearer.motionY, wearer.motionZ));
			ParticleUtils.spawnParticle(particle, world, v.x, v.y, v.z, random, -0.2D, random);
		}
	}*/

	public void updateCustomKeybinds(String flyKeyName, String descendKeyName) {
		KeyTracker.updateCustomKeybinds(flyKeyName, descendKeyName);
	}

	public void initKeys() {
		KeyTracker.addKeys();
	}

	@Override
	public void init() {

	}

	@Override
	public World getClientWorld() {
		return Minecraft.getInstance().world;
	}

	@Override
	public PlayerEntity getClientPlayer() {
		return Minecraft.getInstance().player;
	}
}