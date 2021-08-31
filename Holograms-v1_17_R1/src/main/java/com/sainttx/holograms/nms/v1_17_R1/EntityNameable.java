package com.sainttx.holograms.nms.v1_17_R1;

import com.sainttx.holograms.api.entity.Nameable;
import com.sainttx.holograms.api.line.HologramLine;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.chat.IChatBaseComponent;
import net.minecraft.sounds.SoundEffect;
import net.minecraft.world.EnumHand;
import net.minecraft.world.EnumInteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.EnumItemSlot;
import net.minecraft.world.entity.decoration.EntityArmorStand;
import net.minecraft.world.entity.player.EntityHuman;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.World;
import net.minecraft.world.phys.Vec3D;
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_17_R1.util.CraftChatMessage;

import javax.annotation.Nullable;

public class EntityNameable extends EntityArmorStand implements Nameable {

    private boolean lockTick;
    private HologramLine parentPiece;
    private CraftEntity bukkitEntity;

    public EntityNameable(World world, HologramLine parentPiece) {
        super(EntityTypes.c, world);
        super.collides = false;
        setInvisible(true);
        setSmall(true);
        setArms(false);
        setNoGravity(true);
        setBasePlate(true);
        setMarker(true);
        this.parentPiece = parentPiece;
    }

    public void setLockTick(boolean lock) {
        lockTick = lock;
    }

    @Override
    public void setName(String text) {
        super.setCustomName(CraftChatMessage.fromStringOrNull(text));
        super.setCustomNameVisible(!text.isEmpty());
    }

    @Override
    public String getName() {
        return CraftChatMessage.fromComponent(super.getCustomName());
    }

    @Override
    public void setPosition(double x, double y, double z) {
        super.setPosition(x, y, z);
    }

    @Override
    public HologramLine getHologramLine() {
        return parentPiece;
    }

    @Override
    public void remove() {
        this.a(Entity.RemovalReason.b);
//        this.dead = true;
    }

    // Overriden NMS methods

    @Override
    public void loadData(NBTTagCompound nbttagcompound) {

    }

    @Override
    public void saveData(NBTTagCompound nbttagcompound) {

    }

    @Override
    public boolean d(NBTTagCompound nbt) {
        return false;
    }

    @Override
    public boolean e(NBTTagCompound nbttagcompound) {
        return false;
    }

    @Override
    public NBTTagCompound save(NBTTagCompound nbttagcompound) {
        return new NBTTagCompound();
    }

    @Override
    public void load(NBTTagCompound nbttagcompound) {

    }

    @Override
    public boolean isInvulnerable(DamageSource source) {
        return true;
    }

    @Override
    public boolean isCollidable() {
        return false;
    }

    @Override
    public void setCustomName(@Nullable IChatBaseComponent ichatbasecomponent) {

    }

    @Override
    public void setCustomNameVisible(boolean visible) {

    }

    @Override
    public EnumInteractionResult a(EntityHuman entityhuman, Vec3D vec3d, EnumHand enumhand) {
        return EnumInteractionResult.e;
    }

    @Override
    public void setSlot(EnumItemSlot enumitemslot, ItemStack itemstack, boolean silent) {
    }

    @Override
    public void setSlot(EnumItemSlot enumitemslot, ItemStack itemstack) {

    }

    @Override
    public void setInvisible(boolean flag) {
        super.setInvisible(true);
    }


    @Override
    public void killEntity() {

    }

    @Override
    public boolean damageEntity(DamageSource damagesource, float f) {
        return false;
    }

    // Now is final, fk
//    @Override
//    public void a(AxisAlignedBB boundingBox) {
//
//    }

    @Override
    public void tick() {
        if (!lockTick) {
            super.tick();
        }
    }

    @Override
    public void postTick() {
        if (!lockTick) {
            super.postTick();
        }
    }

    @Override
    public void entityBaseTick() {
        if (!lockTick) {
            super.entityBaseTick();
        }
    }

    @Override
    public void playSound(SoundEffect soundeffect, float f, float f1) {

    }

    @Override
    public void a(Entity.RemovalReason reason) {

    }

    @Override
    public CraftEntity getBukkitEntity() {
        if (this.bukkitEntity == null) {
            this.bukkitEntity = new CraftNameable(this.t.getCraftServer(), this);
        }
        return this.bukkitEntity;
    }
}
