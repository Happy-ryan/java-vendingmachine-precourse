package view;

import camp.nextstep.edu.missionutils.Console;
import utils.Parser;

import java.text.DecimalFormat;
import java.util.*;

public class OutputView {
    private static final String a = "";
    private static final String b = "";
    private static final String c = "";

    private static final int d = 0;

    public static void printInputMeony(boolean isVendingMachineMoney) {
        if (isVendingMachineMoney) {
            System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
            return;
        }
        System.out.println("투입 금액을 입력해 주세요.");
    }

    public static void printCoinMessage() {
        System.out.println("자판기가 보유한 동전");
    }

    public static void printCoins(LinkedHashMap<Integer,Integer> coinNumber) {
        // 동전의 종류와 개수를 저장할 맵 생성
        for (int coin : coinNumber.keySet()) {
            int count = coinNumber.get(coin);
            System.out.println(coin + "원 - " + count + "개");
        }
        System.out.println();
    }

    public static void printUserMoney(int userMoney) {
        System.out.println(String.format("투입 금액: %s", formatNumberWithThousandsSeparator(userMoney)));
    }

    private static String formatNumberWithThousandsSeparator(int number) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(number) + "원";
    }

    public static void print() {
        System.out.println();
    }
}
