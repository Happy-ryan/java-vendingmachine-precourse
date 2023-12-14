package vendingmachine;

import utils.Parser;
import view.InputView;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int vendingMachineMoney = InputView.readMoney(true);
        System.out.println(vendingMachineMoney);
        System.out.println();

        VendingMachine vendingMachine = new VendingMachine(vendingMachineMoney);
        System.out.println(vendingMachine.makeRandCoins(vendingMachineMoney));

        List<String> productDetails = InputView.readProductDetail();
        System.out.println(Parser.joinWithoutBlank(productDetails));
        List<Product> products = new ArrayList<>();
        for(String productDetail : productDetails){
            String[] detail = Parser.extractValues(productDetail);
            String name = detail[0];
            int price = Integer.parseInt(detail[1]);
            int number = Integer.parseInt(detail[2]);
            products.add(new Product(name, price, number));
        }



//        int userMoney = InputView.readMoney(false);
//        System.out.println(userMoney);
//
//        String purchasedProduct = InputView.readProduct(productDetails);
//        System.out.println(purchasedProduct);
    }
}
