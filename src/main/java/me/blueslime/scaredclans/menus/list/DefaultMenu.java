package me.blueslime.scaredclans.menus.list;

import me.blueslime.menuhandlerapi.item.list.WrapperMenuItem;
import me.blueslime.scaredclans.ScaredClans;
import me.blueslime.scaredclans.menus.AbstractMenu;
import me.blueslime.slimelib.file.configuration.ConfigurationHandler;
import me.blueslime.slimelib.file.configuration.TextDecoration;
import me.blueslime.menuhandlerapi.inventory.MenuInventory;
import me.blueslime.menuhandlerapi.inventory.MenuInventoryBuilder;
import me.blueslime.menuhandlerapi.item.MenuItem;
import me.blueslime.menuhandlerapi.item.action.MenuItemAction;
import me.blueslime.messagehandler.MessageHandlerAPI;
import me.blueslime.messagehandler.hooks.PlaceholderParser;
import me.blueslime.messagehandler.types.bossbar.legacy.LegacyBossBar;
import me.blueslime.utilitiesapi.item.ItemWrapper;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.util.List;

public class DefaultMenu extends AbstractMenu {

    private MenuInventory inventory;

    public DefaultMenu(ScaredClans plugin, ConfigurationHandler configuration, File file) {
        super(plugin, configuration, file);
    }

    @Override
    public void load() {
        ConfigurationHandler configuration = getConfiguration();

        MenuInventoryBuilder builder = MenuInventoryBuilder.builder(
                getUniqueId(),
                configuration.getString(
                        TextDecoration.LEGACY,
                        "title",
                        "&8Menu"
                ),
                configuration.getInt("rows", 1)
        );

        MenuInventory inventory = builder.setCanIntroduce(false).perPlayer(true).build();


        inventory.setItemBuilder(
                (player, item) -> {

                    MenuItem clone = item.copy();

                    ItemStack stack = clone.getItemStack();

                    ItemMeta meta = stack.getItemMeta();

                    if (meta != null) {
                        String name = configuration.getString("items." + item.getIdentifier() + ".name", "&6" + item);

                        if (getPlugin().hasPlaceholders()) {
                            name = ChatColor.translateAlternateColorCodes(
                                    '&',
                                    PlaceholderParser.parse(
                                            player,
                                            name
                                    )
                            );
                        } else {
                            name = ChatColor.translateAlternateColorCodes(
                                    '&',
                                    name
                            );
                        }

                        meta.setDisplayName(name);

                        if (meta.getLore() != null) {
                            if (getPlugin().hasPlaceholders()) {
                                List<String> lore = configuration.getStringList("items." + item.getIdentifier() + ".lore");

                                lore.replaceAll(
                                        line -> line = ChatColor.translateAlternateColorCodes(
                                                '&',
                                                PlaceholderParser.parse(
                                                        player,
                                                        line
                                                )
                                        )
                                );

                                meta.setLore(lore);
                            } else {
                                List<String> lore = configuration.getStringList("items." + item.getIdentifier() + ".lore");

                                lore.replaceAll(
                                        line -> line = ChatColor.translateAlternateColorCodes(
                                                '&',
                                                line
                                        )
                                );

                                meta.setLore(lore);
                            }
                        }
                        stack.setItemMeta(meta);
                    }

                    return clone;
                }
        );

        for (String item : configuration.getContent("items", false)) {

            String path = "items." + item;

            FileConfiguration settings = configuration.toSpecifiedConfiguration();

            inventory.addItem(
                    WrapperMenuItem.builder(
                            item,
                            configuration.getInt(path + ".slot")
                    ).item(
                            ItemWrapper.fromData(
                                    settings,
                                    path
                            )
                    ).action(
                            new MenuItemAction(
                                    event -> {
                                        List<String> list = configuration.getStringList(path + ".actions");
                                        Player player = (Player) event.getWhoClicked();

                                        if (list == null || list.isEmpty()) {
                                            return true;
                                        }

                                        for (String action : list) {
                                            boolean isBoss = MessageHandlerAPI.sendMessage(player, action);

                                            if (isBoss) {
                                                getPlugin().getServer().getScheduler().runTaskLater(
                                                        getPlugin(),
                                                        () -> LegacyBossBar.removeBossBar(player),
                                                        20
                                                );
                                            }
                                        }
                                        return true;
                                    }
                            )
                    ).build()
            );

            this.inventory = inventory;
        }
    }

    @Override
    public void openMenu (Player player){
        inventory.openInventory(
                player
        );
    }
}

