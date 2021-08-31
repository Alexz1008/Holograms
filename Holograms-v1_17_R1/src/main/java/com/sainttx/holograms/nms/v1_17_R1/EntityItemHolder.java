package com.sainttx.holograms.nms.v1_17_R1;

import javax.annotation.Nullable;

import com.sainttx.holograms.api.entity.HologramEntity;
import com.sainttx.holograms.api.entity.ItemHolder;
import com.sainttx.holograms.api.line.HologramLine;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.level.WorldServer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.item.EntityItem;
import net.minecraft.world.entity.player.EntityHuman;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.World;
import net.minecraft.world.level.block.Blocks;
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_17_R1.inventory.CraftItemStack;

public class EntityItemHolder extends EntityItem implements ItemHolder {

    private boolean lockTick;
    private HologramLine line;
    private org.bukkit.inventory.ItemStack item;
    private CraftEntity bukkitEntity;

    public EntityItemHolder(World world, HologramLine line) {
        super(EntityTypes.Q, world);
        this.line = line;
        this.P = true;
    }

    public void setLockTick(boolean lockTick) {
        this.lockTick = lockTick;
    }

    @Override
    public HologramLine getHologramLine() {
        return line;
    }

    @Override
    public void setPosition(double x, double y, double z) {
        super.setPosition(x, y, z);
    }

    @Override
    public void remove() {
        this.a(Entity.RemovalReason.b);
        if (isPassenger()) {
            getVehicle().a(Entity.RemovalReason.b);
        }
    }

    @Override
    public void setItem(org.bukkit.inventory.ItemStack item) {
        ItemStack nms = CraftItemStack.asNMSCopy(item);
        if (nms == null || nms == ItemStack.b) {
            nms = new ItemStack(Blocks.gB);
        }
        this.item = item;
        super.setItemStack(nms);
    }

    @Override
    public org.bukkit.inventory.ItemStack getItem() {
        return item;
    }

    @Override
    public HologramEntity getMount() {
        return (HologramEntity) getVehicle();
    }

    @Override
    public void setMount(HologramEntity entity) {
        if (entity instanceof Entity) {
            this.startRiding((Entity) entity);
        }
    }

    // Overriden NMS methods

    @Override
    public void tick() {
        this.s();
        this.p();
        this.R = 0;
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
    public void loadData(NBTTagCompound nbttagcompound) {

    }

    @Override
    public void saveData(NBTTagCompound nbttagcompound) {
    	
    }

    @Override
    public boolean d(NBTTagCompound nbttagcompound) {
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
    public boolean isAlive() {
        return false;
    }

    @Override
    public boolean isCollidable() {
        return false;
    }

    @Override
    public boolean isInteractable() {
        return false;
    }

    @Override
    public boolean isInvulnerable(DamageSource source) {
        return true;
    }

    @Override
    public void a(Entity.RemovalReason reason) {

    }

    @Override
    public void killEntity() {

    }

    @Override
    public void setPickupDelay(int i) {
        super.setPickupDelay(Integer.MAX_VALUE);
    }

/*  @Override TODO Cannot find this method. Maybe it was removed
    protected void burn(float i) {

    }*/

    @Override
    public boolean damageEntity(DamageSource damagesource, float f) {
        return false;
    }

    @Override
    public void pickup(EntityHuman entityhuman) {

    }

    @Nullable
    @Override
    public Entity b(WorldServer dimensionmanager) {
        return null;
    }

    @Override
    public void setItemStack(ItemStack itemstack) {

    }

    @Override
    public CraftEntity getBukkitEntity() {
        if (this.bukkitEntity == null) {
            this.bukkitEntity = new CraftItemHolder(this.t.getCraftServer(), this);
        }
        return this.bukkitEntity;
    }
}