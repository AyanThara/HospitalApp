package com.hospital;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        HospitalSystem hs = new HospitalSystem();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("----- Hospital Appointment System -----");
            System.out.println("1. Add Doctor");
            System.out.println("2. View Doctors");
            System.out.println("3. Book Appointment");
            System.out.println("4. View Appointments");
            System.out.println("5. Cancel Appointment");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            String choiceStr = sc.nextLine();
            int choice;

            try {
                choice = Integer.parseInt(choiceStr);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.\n");
                continue;
            }

            switch (choice) {
                case 1: hs.addDoctor(); break;
                case 2: hs.viewDoctors(); break;
                case 3: hs.bookAppointment(); break;
                case 4: hs.viewAppointments(); break;
                case 5: hs.cancelAppointment(); break;
                case 6:
                    System.out.println("Exiting system...");
                    System.exit(0);
                default:
                    System.out.println("Invalid option!\n");
            }
        }
    }
}
