package org.eymen179.sensitiveblocks.ChainBreak;

import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.eymen179.sensitiveblocks.SensitiveBlocks;

public class ChainBreakListener implements Listener {

    private SensitiveBlocks plugin;

    public ChainBreakListener(SensitiveBlocks plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onArrowHit(ProjectileHitEvent e){

        //Enable- disable check
        if(plugin.getConfig().getBoolean("sensitive-blocks.chain")){

            if(e.getEntity().getType() == EntityType.ARROW){

                Material hitBlock = e.getHitBlock().getType();
                //Material Type Check
                if(hitBlock == Material.CHAIN){
                    e.getHitBlock().breakNaturally();
                    e.getEntity().getWorld().playSound(e.getEntity().getLocation(), Sound.BLOCK_CHAIN_BREAK, 1.0f, 1.0f);
                    e.getEntity().getWorld().spawnParticle(Particle.BLOCK_CRACK, e.getHitBlock().getLocation(), 40, 0.5, 0.5, 0.5, 1, Material.CHAIN.createBlockData());
                }
            }

        }

    }

}
