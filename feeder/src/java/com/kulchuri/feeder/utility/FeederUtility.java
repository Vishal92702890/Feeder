package com.kulchuri.feeder.utility;

import java.text.NumberFormat;
import java.text.ParsePosition;

public class FeederUtility {

    public static boolean isNumeric(String str) {
        NumberFormat formatter = NumberFormat.getInstance();
        ParsePosition pos = new ParsePosition(0);
        formatter.parse(str, pos);
        return str.length() == pos.getIndex();
    }    

    public static void main(String[] args) {
        System.out.println(isNumeric("123A"));
    }
}
