package org.example.homeWorks.hw5.classes;

import org.example.homeWorks.hw5.interfaces.Validator;

public class PhoneInputValidator implements Validator {



    @Override
    public boolean isValid(String value) {
        return value.startsWith("+7") && value.length() == 11;
    }
}
