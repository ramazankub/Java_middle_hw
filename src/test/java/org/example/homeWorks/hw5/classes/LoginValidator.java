package org.example.homeWorks.hw5.classes;

import org.example.homeWorks.hw5.interfaces.Validator;

public class LoginValidator implements Validator {


    @Override
    public boolean isValid(String value) {
        return value != null && !value.isEmpty();
    }
}
