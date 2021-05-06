package casper.statisticsproject.utils;

import casper.statisticsproject.Main;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.util.Map;
import java.util.Random;

public class Utils {

    private final Main main;
    static String[]  names = new String[]{
            "Jack",
            "Clarence",
            "Kacy",
            "John",
            "Stewart"
    };

    public Utils(Main main) {
        this.main = main;
    }
    public Card flipCard(Card card){
        if (card != Card.ACE_ELEVEN && card != Card.ACE_ONE) return null;
        return card == Card.ACE_ONE ? Card.ACE_ELEVEN : Card.ACE_ONE;
    }

    public double bustChance(BlackjackPlayer player){
        int value = 0;
        for (Map.Entry<Card, CardType> entry : player.getStorage().entries()) {
            value += entry.getKey().getValue();
        }
        if (value >= 21){
            return 1.0;
        }
        return value / 21.0;
    }

    public static Multimap<Card, CardType> getRandomCard(){
        int card = new Random().nextInt(Card.values().length);
        int type = new Random().nextInt(CardType.values().length);
        Multimap<Card, CardType> hashMap = ArrayListMultimap.create();
        hashMap.put(Card.values()[card], CardType.values()[type]);
        return hashMap;
    }
    public static String addPlayer(){
        int name = new Random().nextInt(names.length);
        Bukkit.broadcastMessage(ChatColor.GREEN+""+ ChatColor.BOLD+"GAME "+ChatColor.WHITE+names[name]+" has joined the game.");
        return names[name];
    }
}