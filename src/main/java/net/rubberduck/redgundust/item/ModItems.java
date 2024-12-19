package net.rubberduck.redgundust.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rubberduck.redgundust.RedGunDust;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, RedGunDust.MOD_ID);

    public static final RegistryObject<Item> REDGUNDUST = ITEMS.register("redgundusts",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> REDGUNGUN =ITEMS.register("redgungun",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
