package util;

import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Validate {
    private static Scanner input = new Scanner(System.in);
    public static ValidatorFactory validatorFactory = javax.validation.Validation.buildDefaultValidatorFactory();

    public static Validator validator = validatorFactory.getValidator();

    public static Boolean isValidPassword(String password){
        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8}$");
        return password.matches(pattern.pattern());
    }
    public static Boolean isValidName(String password){
        Pattern pattern = Pattern.compile("^[A-Z](?=.{1,29}$)[A-Za-z]*(?:\\h+[A-Z][A-Za-z]*)*$");
        return password.matches(pattern.pattern());
    }

    public static String passwordValidation() {
        String password="";
        boolean flag = true;
        while (flag){
            password = input.next();
            if (Validate.isValidPassword(password)){
                flag = false;
            }else System.out.println("enter valid password");
        }
        return password;
    }

    public static String nameValidation() {
        String name="";
        boolean flag = true;
        while (flag){
            name = input.next();
            if (Validate.isValidName(name)){
                flag = false;
            }else System.out.println("enter valid password");
        }
        return name;
    }
}
