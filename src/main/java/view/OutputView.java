package view;

import camp.nextstep.edu.missionutils.Console;
import utils.Parser;

import java.text.DecimalFormat;
import java.util.*;

public class OutputView {
    private static final String INPUT_MONEY_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String INPUT_MONEY_QUREY_MESSAGE = "투입 금액을 입력해 주세요.";
    private static final String USER_MONEY_FORMAT = "투입 금액: %d ";

    private static final int d = 0;

    public static void printInputMeony(boolean isVendingMachineMoney) {
        if (isVendingMachineMoney) {
            System.out.println(INPUT_MONEY_MESSAGE);
            return;
        }
        System.out.println(INPUT_MONEY_QUREY_MESSAGE);
    }

    public static void printCoinMessage() {
        System.out.println("자판기가 보유한 동전");
    }

    public static void printCoins(LinkedHashMap<Integer, Integer> coinNumber, boolean isFinal) {
        // 동전의 종류와 개수를 저장할 맵 생성
        for (int coin : coinNumber.keySet()) {
            int count = coinNumber.get(coin);
            if(isFinal && count == 0){
                continue;
            }
            System.out.println(coin + "원 - " + count + "개");
        }
        System.out.println();
    }

    public static void printUserMoney(int userMoney) {
        System.out.println(String.format(USER_MONEY_FORMAT, userMoney));
    }

    public static void printProductName(String productName) {
        System.out.println(productName);
        System.out.println();
    }

    public static void printFinalMoneyMessage(){
        System.out.println("잔돈");
    }
    public static void print() {
        System.out.println();
    }
}
