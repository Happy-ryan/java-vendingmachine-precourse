package view;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class InputView {
    public static int readMoney(boolean isVendingMachineMoney) {
        OutputView.printInputMeony(isVendingMachineMoney);
        while (true) {
            try {
                int number = inputMoney();
                return number;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int inputMoney() {
        String string = Console.readLine();
        validateMoney(string);
        return Integer.parseInt(string);
    }

    private static void validateMoney(String string) {
        if (!string.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("[ERROR] 자연수만 허용됩니다.");
        }
        if (Integer.parseInt(string) % 10 != 0) {
            throw new IllegalArgumentException("[ERROR] 10원 단위로 입력해주세요.");
        }
    }

    // ============================ //
    // case2. 단일 문자열만 입력
    public static String readProduct(List<String> products) {
        System.out.println("구매할 상품명을 입력해 주세요.");
        while (true) {
            try {
                String string = inputProduct(products);
                return string;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String inputProduct(List<String> products) {
        String string = Console.readLine();
        validateProduct(string, products);
        return string;
    }

    private static void validateProduct(String string, List<String> products) {
//        // 한글만 허용하는 정규식
        if (!string.matches("^[가-힣]+$")) {
            throw new IllegalArgumentException("[ERROR] 한글만 허용됩니다.");
        }
        // 특정 문자만 허용하는 정규식(U와 D만 허용)
        if (!products.contains(string)) {
            throw new IllegalArgumentException("[ERROR] 없는 상품 입니다.");
        }
    }

    // ============================ //
    // case3. 구분자로 문자를 입력 받는 경우 - String
    public static List<String> readProductDetail() {
        System.out.println("상품명과 가격, 수량을 입력해 주세요.");
        while (true) {
            try {
                List<String> stringList = inputProductsDetail();
                return stringList;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 쉼표(,) + 공백 불허를 기준으로 구분 (ex) 김성한,포비,해피 / 김성한
    private static List<String> inputProductsDetail() {
        List<String> stringList = Arrays.asList(Console.readLine().split(";"));
        validateProductsDetail(stringList);
        return stringList;
    }

    private static void validateProductsDetail(List<String> stringList) {
        for (String string : stringList) {
            // 정해진 형식 확인
            if (!string.matches("\\[([가-힣]+),(\\d+),(\\d+)\\]")) {
                throw new IllegalArgumentException("[ERROR] [한글,숫자,숫자]의 형식을 지켜주세요.");
            }
            String product = string.split(",")[0];
            int money = Integer.parseInt(string.split(",")[1]);
            int productNumber = Integer.parseInt(string.split(",")[2]);
            if (money < 100 || money % 10 != 0) {
                throw new IllegalArgumentException("[ERROR] 상품의 가격은 최소 100원이며, 10원 단위입니다.");
            }
            if (productNumber < 1) {
                throw new IllegalArgumentException("[ERROR] 상품의 수량은 최소 1개입니다.");
            }
        }
    }
}
