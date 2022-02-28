package com.example.optum.javaexercise3.inner_class;

public class OuterClass {

    private String myPrivateField = "hello";

    public class InnerClass {

        public String myInnerMethod() {
            return myPrivateField;
        }
    }

    static class StaticNestedClass {

        public static String myStaticNestedMethod() {
            return "message from nested static class";
        }
    }


}
