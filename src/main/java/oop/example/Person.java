package oop.example;
/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Kate Ingraham
 */
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Person {
    private double genderFactor;

    public double getWeight() {
        Scanner input = new Scanner(System.in);
        double weight;
        do {
            System.out.println("Enter your weight in pounds: ");
            while (!input.hasNextDouble()) {
                String str1 = input.next();
                System.out.println(str1 + " is not a valid weight.");
                System.out.println("Enter your weight in pounds: ");
            }
            weight = input.nextDouble();
            if (weight < 0) {
                System.out.println("Weight cannot be a negative value.");
            }
        } while (weight < 0);
        return weight;
    }

    public double getGenderFactor() {
        Scanner input = new Scanner(System.in);

        String gender;
        do {
            System.out.println("Enter your gender. Please type \"male\" or \"female\".");
            gender = input.next();
            if (gender.equals("male") || gender.equals("female") || gender.equals("Male") || gender.equals("Female")) {
                if (gender.equals("male") || gender.equals("Male")) {
                    genderFactor = .73;
                } else {
                    genderFactor = .66;
                }
            } else {
                System.out.println("Please type \"male\" or \"female\".");
                gender = "";
            }

        } while (gender.length() < 1);

        return genderFactor;
    }

    public double getNumDrinks() {
        Scanner input = new Scanner(System.in);
        double numDrinks;
        do {
            System.out.println("A standard beer is 12oz, a standard glass of wine is 5oz, and a standard shot of liquor is 1.5oz. ");
            System.out.println("Enter the total ounces of drinks you have consumed. ");
            while (!input.hasNextDouble()) {
                String str1 = input.next();
                System.out.println(str1 + " is not a valid number of drinks.");
                System.out.println("Enter the total ounces of drinks you have consumed: ");
            }
            numDrinks = input.nextDouble();
            if (numDrinks < 0) {
                System.out.println("Ounces of drinks cannot be a negative value.");
            }
        } while (numDrinks < 0);
        return numDrinks;
    }

    public double getPercAlc() {
        Scanner input = new Scanner(System.in);
        double percAlc;
        do {
            System.out.println("Enter the percentage of alcohol by volume of the drinks consumed: ");
            while (!input.hasNextDouble()) {
                String str1 = input.next();
                System.out.println(str1 + " is not a valid alcohol content.");
                System.out.println("Enter the percentage of alcohol by volume of the drinks consumed: ");
            }
            percAlc = input.nextDouble();
            if (percAlc < 0) {
                System.out.println("Alcohol content cannot be a negative value.");
            }
        } while (percAlc < 0);
        return percAlc /100;
    }

    public double getHours() {
        Scanner input = new Scanner(System.in);
        double hours;
        do {
            System.out.println("Enter the number of hours since your last drink: ");
            while (!input.hasNextDouble()) {
                String str1 = input.next();
                System.out.println(str1 + " is not a valid number of hours.");
                System.out.println("Enter the number of hours since your last drink: ");
            }
            hours = input.nextDouble();
            if (hours < 0) {
                System.out.println("Number of hours cannot be a negative value.");
            }
        } while (hours < 0);
        return hours;
    }

    public void calcBAC(){
        double a = getNumDrinks() * getPercAlc();
        double w = getWeight();
        double r = getGenderFactor();
        double h = getHours();


       double step1 = a * 5.14;
       double step2 = w * r;
       double step3 = step1/step2;
       double step4 = .015*h;
       double bac = step3 - step4;

        BigDecimal perbac = BigDecimal.valueOf(bac);
        perbac = perbac.setScale(2, RoundingMode.HALF_UP);

        if(bac >= .08){
            System.out.printf("Your BAC is %.2f.%nIt is not legal for you to drive.%n", perbac);
        }else{
            System.out.printf("Your BAC is %.2f.%nIt is legal for you to drive.%n", perbac);
        }

    }
}
