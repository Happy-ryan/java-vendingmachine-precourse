package vendingmachine;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class VendingMachine {
    private final int vendingMachineMoney;

    public VendingMachine(int vendingMachineMoney) {
        this.vendingMachineMoney = vendingMachineMoney;
    }

    public LinkedHashMap<Integer, Integer> makeRandCoins(int finalMoney) {
        List<Integer> coins = new ArrayList<>();
        coins.add(Coin.COIN_10.getAmount());
        coins.add(Coin.COIN_50.getAmount());
        coins.add(Coin.COIN_100.getAmount());
        coins.add(Coin.COIN_500.getAmount());

        List<Integer> randCoins = new ArrayList<>();
        while (finalMoney > 0) {
            int randomCoin = Randoms.pickNumberInList(coins);
            if (finalMoney >= randomCoin) {
                randCoins.add(randomCoin);
                finalMoney -= randomCoin;
            }
        }
        return makeCoinNumber(randCoins);
    }

    private LinkedHashMap<Integer, Integer> makeCoinNumber(List<Integer> randCoins) {
        LinkedHashMap<Integer, Integer> coinCounts = new LinkedHashMap<>();
        coinCounts.put(500, 0);
        coinCounts.put(100, 0);
        coinCounts.put(50, 0);
        coinCounts.put(10, 0);

        for (int coin : randCoins) {
            coinCounts.put(coin, coinCounts.get(coin) + 1);
        }

        for (int coin : coinCounts.keySet()) {
            int count = coinCounts.get(coin);
        }
        return coinCounts;
    }
}
