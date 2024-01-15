package util;

import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.regex.Pattern;

public class Validate {




    public static Boolean isValidPassword(String password) {
        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8}$");
        return password.matches(pattern.pattern());
    }

    public static Boolean isValidName(String name) {
        Pattern pattern = Pattern.compile("^[A-Z](?=.{1,29}$)[A-Za-z]*(?:\\h+[A-Z][A-Za-z]*)*$");
        return name.matches(pattern.pattern());
    }

    public static Boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        return email.matches(pattern.pattern());
    }

    public static Boolean passwordValidation(String password) {

        if (!Validate.isValidPassword(password)) {
            System.out.println("enter valid password");
            return false;
        }
        return true;
    }

    public static Boolean nameValidation(String name) {
        if (!Validate.isValidName(name)) {
            System.out.println("enter valid name");
            return false;
        }
        return true;
    }

    public static Boolean emailValidation(String email) {

        if (!Validate.isValidEmail(email)) {
            System.out.println("enter valid email");
            return false;
        }
        return true;
    }

}
