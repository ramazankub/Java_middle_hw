package org.example.homeWorks.hw5.classes;

public class Main {
    public static void main(String[] args) {
        ValidationService emailVal = new ValidationService(new EmailValidator());
        System.out.println(emailVal.validate("fef"));

        ValidationService phoneVal =  new ValidationService(new PhoneInputValidator());
        System.out.println(phoneVal.validate("+7928928345"));
    }
}
