package vendingmachine;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class VendingMachine {
    private final int vendingMachineMoney;

    public VendingMachine(int vendingMachineMoney) {
        this.vendingMachineMoney = vendingMachineMoney;
    }

    public List<Integer> makeRandCoins(int finalMoney) {
        List<Integer> coins = new ArrayList<>();
        coins.add(Coin.COIN_10.getAmount());
        coins.add(Coin.COIN_50.getAmount());
        coins.add(Coin.COIN_100.getAmount());
        coins.add(Coin.COIN_500.getAmount());

        List<Integer> randomCoins = new ArrayList<>();
        while (finalMoney > 0) {
            int randomCoin = Randoms.pickNumberInList(coins);
            if (finalMoney >= randomCoin) {
                randomCoins.add(randomCoin);
                finalMoney -= randomCoin;
            }
        }

        return randomCoins;
    }
}
