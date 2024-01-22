package ua.AllahClient.ModuleSystem.Modules.Combat;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import ua.AllahClient.ModuleSystem.Category;
import ua.AllahClient.ModuleSystem.Module;

import org.lwjgl.input.Keyboard;

import java.util.Comparator;
import java.util.Random;

public class KillAura extends Module {

    public static float range = 4.3F;
    public static boolean clientrot, hitbox;
    
	public KillAura() {
		super("KillAura", Keyboard.KEY_Z, Category.Combat);
	}
	
	public void onUpdate() {
        EntityPlayer target  = mc.world.playerEntities.stream().filter(entityPlayer -> entityPlayer != mc.player).min(Comparator.comparing(entityPlayer ->
                entityPlayer.getDistanceToEntity(mc.player))).filter(entityPlayer -> entityPlayer.getDistanceToEntity(mc.player) <= range).orElse(null);

        if (target != null && !target.isCreative() && !target.isSpectator()) {
            if (mc.player.getCooledAttackStrength(0) == 1 && mc.player.getTeam() != target.getTeam()) {
            	RayTraceResult objectMouseOver = Minecraft.getMinecraft().objectMouseOver;
            	
            	if(clientrot) {
                    mc.player.rotationYaw = rotations(target)[0];
                    mc.player.rotationPitch = rotations(target)[1];
            	} else {
            		mc.player.connection.sendPacket(new CPacketPlayer.Rotation(rotations(target)[0], rotations(target)[1], mc.player.onGround));
            	}
                
                if (clientrot) {
                    if (objectMouseOver.typeOfHit == RayTraceResult.Type.ENTITY && objectMouseOver != null && hitbox) {
                    	if(Criticals.mod.enabled) {
    						Criticals.mod.doCrit();
    					}
                        mc.clickMouse();
                    } else if (!hitbox) {
                    	if(Criticals.mod.enabled) {
    						Criticals.mod.doCrit();
    					}
                    	mc.playerController.attackEntity(mc.player, target);
                        mc.player.swingArm(EnumHand.MAIN_HAND);
                        mc.player.resetCooldown();
                    }
                }
                if(!clientrot) {
                	if(Criticals.mod.enabled) {
						Criticals.mod.doCrit();
					}
                	mc.playerController.attackEntity(mc.player, target);
                    mc.player.swingArm(EnumHand.MAIN_HAND);
                    mc.player.resetCooldown();
                }
            }
        }
    }
	
	public float[] rotations(EntityPlayer entity) {
		Random random = new Random();
		
        double x = entity.posX - mc.player.posX + (double)(random.nextInt(41) - 20) / 175;
        double y = entity.posY - (mc.player.posY + mc.player.getEyeHeight()) + 1 + (double)(random.nextInt(41) - 20) / 150;
        double z = entity.posZ - mc.player.posZ + (double)(random.nextInt(41) - 20) / 175;

        double u = MathHelper.sqrt(x * x + z * z);

        float u2 = (float) (MathHelper.atan2(z, x) * (180D / Math.PI) - 90.0F);
        float u3 = (float) (-MathHelper.atan2(y, u) * (180D / Math.PI));

        return new float[]{u2, u3};
    }
}