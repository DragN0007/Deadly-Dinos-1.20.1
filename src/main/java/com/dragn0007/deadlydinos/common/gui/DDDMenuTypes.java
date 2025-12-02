package com.dragn0007.deadlydinos.common.gui;

import com.dragn0007.deadlydinos.DeadlyDinos;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DDDMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.MENU_TYPES, DeadlyDinos.MODID);

    public static final RegistryObject<MenuType<MountMenu>> MOUNT_MENU = registerMenuType("mount_menu", MountMenu::new);
    public static final RegistryObject<MenuType<SmallInvMenu>> SMALL_INV_MENU = registerMenuType("small_inv_menu", SmallInvMenu::new);
    public static final RegistryObject<MenuType<TinyInvMenu>> TINY_INV_MENU = registerMenuType("tiny_inv_menu", TinyInvMenu::new);

    public static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>> registerMenuType(String name, IContainerFactory<T> factory) {
        return MENU_TYPES.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENU_TYPES.register(eventBus);
    }
}
