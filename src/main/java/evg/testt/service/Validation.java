package evg.testt.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    public static boolean validForDepartments(String validNameString){
        Pattern p = Pattern.compile("([a-z 0-9A-Z]){3,10}");
        Matcher m = p.matcher(validNameString);
        return m.matches();
    }


}
