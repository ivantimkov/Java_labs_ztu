package com.education.ztu;

import java.util.*;

public class LocalizationExample {
    public static void main(String[] args) {
        Locale locale = new Locale("en", "US");
        ResourceBundle bundle = ResourceBundle.getBundle("data", locale);

        System.out.println(bundle.getString("title"));
        System.out.println(bundle.getString("product") + " | " +
                bundle.getString("category") + " | " +
                bundle.getString("price"));
    }
}


