package util;

import java.util.regex.Pattern;

public class Validate {

    public static Boolean isValidPassword(String password){
        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8}$");
        return password.matches(pattern.pattern());
    }
    public static Boolean isValidName(String password){
        Pattern pattern = Pattern.compile("^[A-Z](?=.{1,29}$)[A-Za-z]*(?:\\h+[A-Z][A-Za-z]*)*$");
        return password.matches(pattern.pattern());
    }

}
