package com.gonggongjohn.eok.items;

import com.gonggongjohn.eok.EOK;
import com.gonggongjohn.eok.handlers.ItemHandler;
import com.gonggongjohn.eok.utils.IHasModel;
import com.gonggongjohn.eok.utils.ToolMaterials;
import net.minecraft.item.ItemSpade;

public class ItemRedstoneSpade extends ItemSpade implements IHasModel {

    public ItemRedstoneSpade() {
        super(ToolMaterials.REDSTONE);
        String name = "redstone_shovel";
        this.setUnlocalizedName("eok." + name);
        this.setRegistryName(name);
        this.setCreativeTab(EOK.tabEOK);
        this.setMaxStackSize(1);
        ItemHandler.ITEM_REGISTRY.add(this);
    }

    @Override
    public void registerModel() {
        EOK.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
