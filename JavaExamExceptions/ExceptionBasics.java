package JavaExamExceptions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ExceptionBasics {

    /**
     * Note that RuntimeException need not be handled beforehand (Unchecked)
     */
    public static void methodThatThrowsRuntimeException() {
        throw new RuntimeException();
    }

    /**
     * Checked exception
     */
    public static void methodThatThrowsException() throws Exception {
        throw new Exception();
    }

    public static void methodThatThrowsError() {
        throw new Error();
    }

    public static void main(String[] args) throws Exception {

        try {
            methodThatThrowsError();
        } catch (Error e) {
            e.printStackTrace();
        }

        try {
            methodThatThrowsRuntimeException();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            methodThatThrowsException();
        } catch (Exception e) {
            e.printStackTrace();
        // } catch (OtherException e) { // DOESNT COMPILE AS UNREACHABLE
        } finally {
            System.out.println("The final block always get executed, regardless of whether exception occurs");
        }

        try {
            throw new RuntimeException();
        } catch (RuntimeException e) {
            // throw new RuntimeException("First");
        } finally {
            // throw new Exception("Second");
        }
        System.out.println(exceptions());
    }

    public static String exceptions() {
        String result = "";
        String v = null;
        try {
            try {
                result += "before";
                v.length();
                result += "after";
            } catch (NullPointerException e) {
                result += "catch";
                throw new RuntimeException();
            } finally {
                result += "finally";
                throw new Exception();
            }
        } catch (Exception e) {
            result += "done";
        }
        return result;
    }
}

class OtherException extends Exception {

    private static final long serialVersionUID = 1L;

    private static void throwsOtherException() throws OtherException {
        // throw new Exception(); // DOESNT COMPILE AS BROAD HENCE
        // throw new RuntimeException();
    }

    public void checkException(){
        try {
            throwsOtherException();
        } catch (OtherException e) {
            System.out.println("Exception is thorown");
        }
    }

    public static void main(String[] args) {
        OtherException example = new OtherException();
        example.checkException();

        List<String> hex = Arrays.asList("30", "8", "3A", "33B2", "FF");
        Collections.sort(hex);
        System.out.println(hex);

    }
}