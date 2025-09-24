package utils;

import java.util.Map;

public class Constants {
    public static final Map<String, String> errorTexts = Map.of(
            "en", "Mandatory field is empty",
            "ka", "აუცილებელი ველი არ არის შევსებული",
            "ru", "Необходимое поле не заполнено"
    );

    public static final Map<String, String> skipBtnTexts = Map.of(
            "en", "Skip",
            "ka", "გამოტოვება",
            "ru", "Пробел"
    );
}
