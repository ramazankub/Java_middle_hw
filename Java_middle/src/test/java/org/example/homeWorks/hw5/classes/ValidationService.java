package org.example.homeWorks.hw5.classes;

import org.example.homeWorks.hw5.interfaces.Validator;

public class ValidationService {
    private final Validator validator;

    public  ValidationService(Validator validator) {
        this.validator = validator;
    }

    public boolean validate(String input) {
        return validator.isValid(input);
    }
}
