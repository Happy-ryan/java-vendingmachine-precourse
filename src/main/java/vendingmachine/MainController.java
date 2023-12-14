package vendingmachine;

import utils.Parser;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class MainController {
    public MainController() {

    }

    public void run() {
        int vendingMachineMoney = InputView.readMoney(true);
        OutputView.printeMoney(vendingMachineMoney);

        VendingMachine vendingMachine = new VendingMachine(vendingMachineMoney);
        OutputView.printCoinMessage();

        LinkedHashMap<Integer, Integer> coinNumber = vendingMachine.makeRandCoins(vendingMachineMoney);
        OutputView.printCoins(coinNumber, false);

        List<String> productDetails = InputView.readProductDetail();
        OutputView.printProductDetails(productDetails);

        List<Product> products = makeProducts(productDetails);
        List<String> possibleProduct = makePossibleProduct(products);

        int userMoney = InputView.readMoney(false);
        User user = new User(userMoney, possibleProduct);
        OutputView.printeMoney(user.getUserMoney());

        Mediator mediator = new Mediator(coinNumber, user, products);
        mediator.run();
    }

    private List<Product> makeProducts(List<String> productDetails) {
        List<Product> products = new ArrayList<>();
        for (String productDetail : productDetails) {
            String[] detail = Parser.extractValues(productDetail);
            String name = detail[0];
            int price = Integer.parseInt(detail[1]);
            int number = Integer.parseInt(detail[2]);
            products.add(new Product(name, price, number));
        }
        return products;
    }

    private List<String> makePossibleProduct(List<Product> products){
        List<String> possibleProduct = new ArrayList<>();
        for (Product product : products) {
            possibleProduct.add(product.getName());
        }
        return possibleProduct;
    }
}
