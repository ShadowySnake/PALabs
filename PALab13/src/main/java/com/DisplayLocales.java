package com;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class DisplayLocales {
    public void display(ResourceBundle bundle) {
        String currentInfo = bundle.getString("locale.set");
        Object[] arguments = new Object[1];
        if (bundle.getLocale().equals(new Locale("ro"))) arguments[0] = "ro";
        else arguments[0] = "eng";
        String currentLocale = new MessageFormat(currentInfo).format(arguments);
        System.out.println(currentLocale);
        System.out.println(bundle.getString("locales"));
        System.out.println("ro");
        System.out.println("en (DEFAULT)");
    }
}
