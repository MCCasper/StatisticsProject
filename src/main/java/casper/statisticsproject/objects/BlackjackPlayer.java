package casper.statisticsproject.objects;

import casper.statisticsproject.utils.Utils;

import java.util.HashMap;

public class BlackjackPlayer {
    PlayingCard[] storage;
    String name;
    long balance;

    public BlackjackPlayer(String name){
        this.name = name;
        this.balance = 1000;
        this.storage = new PlayingCard[4];
        storage[0] = Utils.getRandomCard();
        storage[1] = Utils.getRandomCard();
    }

    public long getBalance() {
        return balance;
    }
    public void addBalance(long balance){
        this.balance = getBalance() + balance;
    }

    public PlayingCard[] getStorage() {
        return storage;
    }

    public void setStorage(int place, PlayingCard storage) {
        this.storage[place] = storage;
    }

    public PlayingCard getFirstCard(){
        return storage[0];
    }

    public String getName() {
        return name;
    }
}
