package net.darkhax.wawla.client;

import net.darkhax.wawla.Wawla;
import net.darkhax.wawla.plugins.InfoProvider;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class TooltipHandler {
    
    @SubscribeEvent
    public void onItemTooltip (ItemTooltipEvent event) {
        
        if (event.getEntityPlayer() != null && event.getEntityPlayer().worldObj != null && event.getItemStack() != null)
            for (final InfoProvider provider : Wawla.itemProviders)
                provider.addItemInfo(event.getToolTip(), event.getItemStack(), event.isShowAdvancedItemTooltips(), event.getEntityPlayer());
    }
}