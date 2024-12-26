package net.rubberduck.redgundust.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.rubberduck.redgundust.RedGunDust;
import net.rubberduck.redgundust.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RedGunDust.MOD_ID);

    public static final RegistryObject<CreativeModeTab> REDGUNDUST_ITEMS_TAB = CREATIVE_MODE_TAB.register("redgundust_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.REDGUNDUST.get()))
                    .title(Component.translatable("creativetab.redgundust.redgundust_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.REDGUNDUST.get());
                        output.accept(ModBlocks.REDGUNDUST_BLOCK.get());
                        output.accept(ModBlocks.REDGUNDUST_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_REDGUNDUST_ORE.get());
                        output.accept(ModItems.REDGUNGUN.get());

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
