package com;

import java.text.DateFormatSymbols;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Info {
    public void info(ResourceBundle resourceBundle) {
        String information = resourceBundle.getString("info");
        Object[] arguments = new Object[1];
        if (resourceBundle.getLocale().equals(new Locale("ro"))) arguments[0] = "ro";
        else arguments[0] = "eng";
        String locationInfo = new MessageFormat(information).format(arguments);
        System.out.println(locationInfo);

        DateFormatSymbols dos = new DateFormatSymbols(resourceBundle.getLocale());
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy", resourceBundle.getLocale());
        Date date = new Date(System.currentTimeMillis());
        Currency currency;

        if (resourceBundle.getLocale().equals(new Locale("ro"))) currency = Currency.getInstance("RON");
        else currency = Currency.getInstance("USD");

        System.out.println("Country: " + resourceBundle.getLocale().getCountry());
        System.out.println("Language: " + resourceBundle.getLocale().getLanguage());
        System.out.println("Currency: " + currency.getSymbol());
        System.out.println("Week Days: " + Arrays.toString(dos.getWeekdays()));
        System.out.println("Months: " + Arrays.toString(dos.getMonths()));
        System.out.println("Today: " + formatter.format(date));
    }
}
