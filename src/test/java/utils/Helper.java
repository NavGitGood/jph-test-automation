package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helper {

    private static final String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    public static boolean isValidEmail(String emailToValidate) {
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(emailToValidate);
        return matcher.matches();
    }
}
