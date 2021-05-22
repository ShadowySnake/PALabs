package com;

import java.util.Locale;
import java.util.Scanner;

public class SetLocale {
    public Locale set(Locale locale) {
        Locale changedLocale;
        Scanner localeChanger = new Scanner(System.in);
        if (locale == Locale.getDefault()) {
            System.out.println("Please specify which locale would you like");
        } else System.out.println("Va rugam sa specificati ce locatie ati dori");

        String newLocale = localeChanger.nextLine();

        if (newLocale.equals("ro")) {
            changedLocale = Locale.forLanguageTag("ro");
        } else {
            changedLocale = Locale.getDefault();
        }
       return changedLocale;
    }
}
