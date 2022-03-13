package com.credentials.service;

import com.credentials.model.Employee;

import java.util.Random;

public class CredentialService {

    private String generatePassword(){
        Random random = new Random();

        String specialCharacters = "!@#$%^&*()_+";
        String password = "" +
                (char) ('A' + random.nextInt(26)) +
                (char) ('A' + random.nextInt(26)) +
                (char) ('a' + random.nextInt(26)) +
                (char) ('a' + random.nextInt(26)) +
                (char) ('0' + random.nextInt(10)) +
                (char) ('0' + random.nextInt(10)) +
                specialCharacters.charAt(random.nextInt(specialCharacters.length())) +
                specialCharacters.charAt(random.nextInt(specialCharacters.length()));

        return permute(password);
    }

    private String permute(String password) {
        char [] chars = password.toCharArray();
        Random random = new Random();

        int n = chars.length;
        while (n > 0) {
            int v = random.nextInt(n);
            char temp = chars[v];
            chars[v] = chars[n - 1];
            chars[n - 1] = temp;
            n--;
        }

        return new String(chars);
    }

    private String generateEmailAddress(Employee emp, String department) {
        return emp.firstName.toLowerCase() + emp.lastName.toLowerCase() +
                "@" + department + ".abc.com";
    }

    public void showCredentials(Employee emp, String department) {
        System.out.println("Dear " + emp.firstName + ", your generated credentials are as follows: ");
        System.out.println("Email    --> " + generateEmailAddress(emp, department));
        System.out.println("Password --> " + generatePassword());
    }
}
