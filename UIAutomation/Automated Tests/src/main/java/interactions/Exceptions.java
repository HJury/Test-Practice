package interactions;

import org.openqa.selenium.NoSuchElementException;

public class Exceptions {

    public static void exceptionMessage(Exception e) {
        System.out.println("No se encontro el elemento \n");
    }

    public static void exceptionMessage(AssertionError e) {
        System.out.println("No se pudo realizar la assertion en el siguiente elemento: \n" + e.getMessage());
    }
}
