package view;

import camp.nextstep.edu.missionutils.Console;
import utils.Parser;

import java.util.*;

public class OutputView {
    private static final String a = "";
    private static final String b = "";
    private static final String c = "";

    private static final int d = 0;

    public static void printInputMeony(boolean isVendingMachineMoney){
        if(isVendingMachineMoney){
            System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
            return;
        }
        System.out.println("투입 금액을 입력해 주세요.");
    }

    public static void print1() {
        System.out.println();
    }

    public static void print() {
        System.out.println();
    }
}
