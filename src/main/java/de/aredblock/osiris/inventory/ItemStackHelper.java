package de.aredblock.osiris.inventory;

import net.kyori.adventure.text.Component;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public final class ItemStackHelper {

    public static void withDisplayName(ItemStack itemStack, Component displayName) {
        var meta = itemStack.getItemMeta();
        meta.displayName(displayName);
        itemStack.setItemMeta(meta);
    }

    public static void withLore(ItemStack itemStack, Component... lore) {
        withLore(itemStack, List.of(lore));
    }

    public static void withLore(ItemStack itemStack, List<Component> lore) {
        var meta = itemStack.getItemMeta();
        meta.lore(lore);
        itemStack.setItemMeta(meta);
    }

}
