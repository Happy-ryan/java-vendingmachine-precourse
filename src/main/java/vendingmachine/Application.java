package vendingmachine;

import utils.Parser;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int vendingMachineMoney = InputView.readMoney(true);
        System.out.println(vendingMachineMoney);
        System.out.println();

        VendingMachine vendingMachine = new VendingMachine(vendingMachineMoney);
        OutputView.printCoinMessage();
        LinkedHashMap<Integer, Integer> coinNumber = vendingMachine.makeRandCoins(vendingMachineMoney);
        OutputView.printCoins(coinNumber);

        List<String> productDetails = InputView.readProductDetail();
        System.out.println(Parser.joinWithoutBlank(productDetails));
        System.out.println();

        List<Product> products = new ArrayList<>();
        for (String productDetail : productDetails) {
            String[] detail = Parser.extractValues(productDetail);
            String name = detail[0];
            int price = Integer.parseInt(detail[1]);
            int number = Integer.parseInt(detail[2]);
            products.add(new Product(name, price, number));
        }
        List<String> possibleProduct = new ArrayList<>();
        for(Product product : products){
            possibleProduct.add(product.getName());
        }

        int userMoney = InputView.readMoney(false);
        User user = new User(userMoney);
        System.out.println(user.getUserMoney());

//        OutputView.printUserMoney(userMoney);
//
//        while (true) {
//            OutputView.printUserMoney(userMoney);
//            String purchasedProduct = InputView.readProduct(productDetails);
//            System.out.println(purchasedProduct);
//        }

    }
}
