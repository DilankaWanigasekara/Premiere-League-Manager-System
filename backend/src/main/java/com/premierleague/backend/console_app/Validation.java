package com.premierleague.backend.console_app;

public class Validation {

    //method to check all are integers in a string
    public static boolean onlyInt (String str)
    {
        String regex = "[0-9]+";
        if(str.matches(regex)){
            return true;
        }else{
            return false;
        }
    }

    //method to check all are characters in a string
    public static boolean onlyString (String str){
        for (int i = 0; i < str.length(); i++) {

            if (Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    // validate date
    public static boolean checkDate (String[] dateArr){
        if (dateArr.length!=3){
            System.out.println("The entered date is not valid!! Please re-enter in correct format (dd-mm-yyyy)");
            return false;
        }else  if (onlyInt(dateArr[0]) && onlyInt(dateArr[1]) && onlyInt(dateArr[2])){
            int day = Integer.parseInt(dateArr[0]);
            int month = Integer.parseInt(dateArr[1]);
            int year = Integer.parseInt(dateArr[2]);
            if((day>=1 && day<=31) && (month>=1 && month<=12) && (year>=2000 && year<=3000)){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }

    }
}
