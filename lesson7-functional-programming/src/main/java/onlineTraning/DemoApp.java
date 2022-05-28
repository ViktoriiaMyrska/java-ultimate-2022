package onlineTraning;

import java.util.function.BooleanSupplier;

public class DemoApp {

    BooleanSupplier booleanSupplierLambda = () -> true;
    BooleanSupplier booleanSupplierReference = DemoApp::getAsBoolean;

    private static boolean getAsBoolean() {
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Hello");
    }
}