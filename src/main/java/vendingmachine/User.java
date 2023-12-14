package vendingmachine;

import view.InputView;

import java.util.List;

public class User {
    private int userMoney;
    private List<String> possibleProducts;

    public User(int userMoney) {
        this.userMoney = userMoney;
    }

    public String buyProduct() {
        String purchasedProduct = InputView.readProduct(possibleProducts);
        return purchasedProduct;
    }

    public int getUserMoney() {
        return userMoney;
    }
}
