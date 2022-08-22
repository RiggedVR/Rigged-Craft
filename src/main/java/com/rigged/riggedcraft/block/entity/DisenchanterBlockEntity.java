package com.rigged.riggedcraft.block.entity;

import com.rigged.riggedcraft.items.inventory.ImplementedInventory;
import com.rigged.riggedcraft.screen.DisenchanterScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class DisenchanterBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {

    private final DefaultedList<ItemStack> inventory =
            DefaultedList.ofSize(3, ItemStack.EMPTY);

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 72;

    public DisenchanterBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.DISENCHANTER, pos, state);

        this.propertyDelegate = new PropertyDelegate() {
            public int get(int index) {
                switch (index){
                    case 0: return DisenchanterBlockEntity.this.progress;
                    case 1: return DisenchanterBlockEntity.this.maxProgress;
                    default: return 0;
                }
            }

            public void set(int index, int value) {
                switch (index){
                    case 0: DisenchanterBlockEntity.this.progress = value; break;
                    case 1: DisenchanterBlockEntity.this.maxProgress = value; break;
                }
            }

            public int size() {
                return 2;
            }
        };
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("Disenchanter");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new DisenchanterScreenHandler(syncId, inv, this, this.propertyDelegate);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("disenchanter.progress", progress);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
        progress = nbt.getInt("disenchanter.progress");
    }

    public static void tick(World world, BlockPos blockPos, BlockState state, DisenchanterBlockEntity entity) {
        if(world.isClient()){
            return;
        }

        if(hasRecipe(entity)){
            entity.progress++;
            markDirty(world, blockPos, state);
            if(entity.progress >= entity.maxProgress){
                craftItem(entity);
            }
        }else{
            entity.resetProgress();
            markDirty(world, blockPos, state);
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private static void craftItem(DisenchanterBlockEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for (int i = 0; i < entity.size(); i++){
            inventory.setStack(i, entity.getStack(i));
        }

        if(hasRecipe(entity)){
            ItemStack stack = new ItemStack(Items.ENCHANTED_BOOK, entity.getStack(2).getCount() + 1);
            Map<Enchantment, Integer> enchants = EnchantmentHelper.get(entity.getStack(0));
            EnchantmentHelper.set(enchants, stack);


            entity.getStack(0).removeSubNbt("Enchantments");
            entity.getStack(0).removeSubNbt("StoredEnchantments");

            entity.removeStack(1, 1);
            entity.setStack(2, stack);

            entity.resetProgress();
        }
    }

    private static boolean hasRecipe(DisenchanterBlockEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for (int i = 0; i < entity.size(); i++){
            inventory.setStack(i, entity.getStack(i));
        }

        boolean hasEnchantedItemInFirstSlot = !EnchantmentHelper.get(entity.getStack(0)).isEmpty();
        boolean hasBookInSecondSlot = entity.getStack(1).getItem() == Items.BOOK;

        return hasEnchantedItemInFirstSlot && hasBookInSecondSlot && canInsertAmountIntoOutputSlot(inventory, 1)
                && canInsertItemIntoOutputSlot(inventory, entity.getStack(0).getItem());

    }

    private static boolean canInsertItemIntoOutputSlot(SimpleInventory inventory, Item item) {
        return inventory.getStack(2).getItem() == item || inventory.getStack(2).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleInventory inventory, int count) {
        return inventory.getStack(2).getMaxCount() > inventory.getStack(2).getCount() + count;
    }
}
