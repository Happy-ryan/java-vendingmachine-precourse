package utils;

import vendingmachine.Product;

import java.text.DecimalFormat;
import java.util.*;

public class Parser {
    // 김성한,김성한,김성한 -> OutputView에 도움
    public static String joinWithoutBlank(List<String> stringList) {
        return String.join(";", stringList);
    }

    // 김성한, 김성한, 김성한 -> OutputView에 도움
    public static String joinWithBlank(List<String> stringList) {
        return String.join(", ", stringList);
    }

    // List<String> -> List<Integer> 로 변경 -> inputView에 도움
    public static List<Integer> parseInteger(List<String> stringList) {
        List<Integer> IntegerList = new ArrayList<>();
        for (String string : stringList) {
            IntegerList.add(Integer.parseInt(string));
        }
        return IntegerList;
    }

    public static String[] extractValues(String input) {
        // 문자열을 적절히 처리하여 필요한 정보 추출
        input = input.replaceAll("[\\[\\]]", ""); // 대괄호 제거
        String[] values = input.split(",");

        // 배열의 각 요소를 정리 (공백 제거)
        for (int i = 0; i < values.length; i++) {
            values[i] = values[i].trim();
        }

        return values;
    }

    public static String formatNumberWithThousandsSeparator(int number) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(number) + "원";
    }

    public static LinkedHashMap<String, Integer> makeNamePrice(List<Product> products) {
        LinkedHashMap<String, Integer> namePrice = new LinkedHashMap<>();
        for (Product product : products) {
            namePrice.put(product.getName(), product.getPrice());
        }
        return namePrice;
    }

    public static LinkedHashMap<String, Integer> makeNameNumber(List<Product> products) {
        LinkedHashMap<String, Integer> nameNumber = new LinkedHashMap<>();
        for (Product product : products) {
            nameNumber.put(product.getName(), product.getPrice());
        }
        return nameNumber;
    }

}
