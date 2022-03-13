package com.credentials.main;

import com.credentials.model.Employee;
import com.credentials.service.CredentialService;

import java.util.Scanner;

public class DriverClass {

    static String [] departments = {"tech", "admin", "hr", "legal"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your first name: ");
        String firstName = sc.nextLine();

        System.out.print("Enter your last name: ");
        String lastName = sc.nextLine();

        Employee employee = new Employee(firstName, lastName);

        System.out.println(
                "Please enter department from the following: \n" +
                "1. Technical \n" +
                "2. Admin \n" +
                "3. Human Resources \n" +
                "4. Legal");

        int departmentChoice = sc.nextInt();
        if (departmentChoice < 1 || departmentChoice > 4) {
            System.out.println("Invalid Department");
            sc.close();
            return;
        }

        String department = departments[departmentChoice - 1];
        new CredentialService().showCredentials(employee, department);

        sc.close();
    }
}
