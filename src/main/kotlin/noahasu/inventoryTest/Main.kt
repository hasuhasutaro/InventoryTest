package noahasu.inventoryTest

import cn.nukkit.event.EventHandler
import cn.nukkit.event.Listener
import cn.nukkit.event.player.PlayerToggleSneakEvent
import cn.nukkit.inventory.fake.FakeInventory
import cn.nukkit.inventory.fake.FakeInventoryType
import cn.nukkit.item.ItemApple
import cn.nukkit.item.ItemEmerald
import cn.nukkit.plugin.PluginBase

class Main : PluginBase(), Listener {
    override fun onEnable() {
        super.onEnable()
        this.server.pluginManager.registerEvents(this, this)
    }

    @EventHandler
    fun onShift(ev: PlayerToggleSneakEvent) {
        val player = ev.player
        val inv = FakeInventory(FakeInventoryType.CHEST)
        val apple = ItemApple()
        apple.setCount(10)
        inv.setItem(9, apple)
        inv.setDefaultItemHandler { inventory, slot, targetItem, sourceItem, event ->
            if (slot == 9) {
                println(inventory.getItem(9))
                inventory.setItem(9, ItemEmerald())
            }
        }
        player.addWindow(inv)
    }
}