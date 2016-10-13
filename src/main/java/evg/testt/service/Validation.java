package evg.testt.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    public static boolean validForDepartments(String validNameString){
        Pattern p = Pattern.compile("([a-z 0-9A-Z]){3,10}");
        Matcher m = p.matcher(validNameString);
        return m.matches();
    }



    public static boolean validForDepphone(String validPhoneString){
        Pattern p = Pattern.compile(".+([0-9]{8,15})");
        Matcher m = p.matcher(validPhoneString);

        return m.matches();
    }


    public static boolean validForEmplName(String validNameEmpl){
        Pattern p = Pattern.compile("([a-zA-Z]){1,12}");
        Matcher m = p.matcher(validNameEmpl);
        return m.matches();
    }


}
