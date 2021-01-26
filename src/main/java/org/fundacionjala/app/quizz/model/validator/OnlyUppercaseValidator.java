package org.fundacionjala.app.quizz.model.validator;

import java.util.List;

public class OnlyUppercaseValidator implements Validator<String, String> {

    private static final String ERROR_MESSAGE = "Must be only uppercase characters";

    @Override
    public void validate(String value, String conditionValue, List<String> errors) {
        char ch;
        for (int i=0; i<value.length(); i++){
            ch = value.charAt(i);
            if (!Character.isUpperCase(ch)){
                errors.add(ERROR_MESSAGE);
                break;
            }
        }
    }
}
