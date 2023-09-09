package org.eymen179.sensitiveblocks.PotBreak;

import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class PotBreakListener implements Listener {

    @EventHandler
    public void onArrowHit(ProjectileHitEvent e){

        if(e.getEntity().getType() == EntityType.ARROW){

            Material hitBlock = e.getHitBlock().getType();

            if(hitBlock == Material.DECORATED_POT || hitBlock == Material.FLOWER_POT){
                e.getHitBlock().breakNaturally();
                e.getEntity().getWorld().playSound(e.getEntity().getLocation(), Sound.BLOCK_GLASS_BREAK, 1.0f, 1.0f);
                e.getEntity().getWorld().spawnParticle(Particle.BLOCK_CRACK, e.getHitBlock().getLocation(), 40, 0.5, 0.5, 0.5, 1, Material.DECORATED_POT.createBlockData());
            }
        }

    }
}
