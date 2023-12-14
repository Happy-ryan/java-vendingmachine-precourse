package vendingmachine;

import utils.Parser;
import view.InputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int vendingMachineMoney = InputView.readMoney(true);
        System.out.println(vendingMachineMoney);
        System.out.println();

        List<String> productDetail = InputView.readProductDetail();
        System.out.println(Parser.joinWithoutBlank(productDetail));

        int userMoney = InputView.readMoney(false);
        System.out.println(userMoney);

        String purchasedProduct = InputView.readProduct(productDetail);
        System.out.println(purchasedProduct);
    }
}
