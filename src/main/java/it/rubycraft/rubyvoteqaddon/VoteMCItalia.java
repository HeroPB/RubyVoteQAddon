package it.rubycraft.rubyvoteqaddon;

import me.blackvein.quests.CustomObjective;
import me.blackvein.quests.Quest;
import me.blackvein.quests.Quests;
import me.kr1s_d.rubyvote.core.CoinProcessEventExecutor;
import me.kr1s_d.rubyvote.events.custom.CoinPostProcessEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public final class VoteMCItalia extends CustomObjective implements Listener {
    Quests qp = (Quests) Bukkit.getServer().getPluginManager().getPlugin("Quests");

    public VoteMCItalia() {
        this.setName("Vota");
        this.setAuthor("RubyCraft");
        this.setShowCount(true);
        this.setCountPrompt("Quante crates deve aprire:");
        this.setDisplay("voti: %count%");
    }
    @EventHandler
    public void onClick(CoinPostProcessEvent event) {
        for (Quest quest : qp.getQuester(event.getPlayer().getUniqueId()).getCurrentQuests().keySet()) {
            incrementObjective(event.getPlayer(), this, event.getAmount(), quest);
        }
    }
}