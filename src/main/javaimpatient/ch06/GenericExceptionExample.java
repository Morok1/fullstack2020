package ch06;

import java.io.IOException;

public class GenericException<T extends IOException> {
    public  String getValue () throws T {
        return "";
    }

//    public static class ExpectedExceptionUtility {
//        public static <T extends Exception> void checkForExpectedException(String message, ExpectedExceptionBlock<T> block) {
//            try {
//
//            } catch (T ex) {
//            }
//        }
//    }
}
