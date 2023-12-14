package vendingmachine;

import utils.MapUtils;
import utils.Parser;
import view.OutputView;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class Mediator {
    private LinkedHashMap<Integer, Integer> coinNumber;
    private User user;
    private List<Product> products;

    public Mediator(LinkedHashMap<Integer, Integer> coinNumber, User user, List<Product> products) {
        this.coinNumber = coinNumber;
        this.user = user;
        this.products = products;
    }

    public void run() {
        int currentMoney = user.getUserMoney();
        LinkedHashMap<String, Integer> namePrice = Parser.makeNamePrice(products);
        LinkedHashMap<String, Integer> nameNumber = Parser.makeNamePrice(products);
        int minPrice = MapUtils.getMinValue(namePrice);

        while (isStop(minPrice, currentMoney, nameNumber)) {
            OutputView.printUserMoney(currentMoney);
            String productName = user.buyProduct();
            OutputView.printProductName(productName);

            currentMoney -= namePrice.get(productName);
            nameNumber.put(productName, nameNumber.get(productName) - 1);
        }
    }

    private boolean isStop(int minPrice, int currentMoney, LinkedHashMap<String, Integer> nameNumber) {
        if (minPrice > currentMoney || MapUtils.getTotalNumber(nameNumber) == 0) {
            OutputView.printUserMoney(currentMoney);
            OutputView.printFinalMoneyMessage();
            OutputView.printCoins(coinNumber, true);
            return false;
        }
        return true;
    }
}
