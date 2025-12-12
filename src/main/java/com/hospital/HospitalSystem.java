package com.hospital;

import java.util.ArrayList;
import java.util.Scanner;

public class HospitalSystem {

    private ArrayList<Doctor> doctors = new ArrayList<>();
    private ArrayList<Appointment> appointments = new ArrayList<>();
    private int doctorCounter = 1;
    private int appointmentCounter = 1;

    Scanner sc = new Scanner(System.in);

    public void addDoctor() {
        System.out.print("Enter Doctor Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Specialization: ");
        String specialization = sc.nextLine();

        Doctor d = new Doctor(doctorCounter++, name, specialization);
        doctors.add(d);

        System.out.println("Doctor added successfully!\n");
    }

    public void viewDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors available.\n");
            return;
        }

        System.out.println("----- List of Doctors -----");
        for (Doctor d : doctors) {
            System.out.println(d);
        }
        System.out.println();
    }

    public void bookAppointment() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors available. Add a doctor first.\n");
            return;
        }

        System.out.print("Enter Patient Name: ");
        String patientName = sc.nextLine();

        viewDoctors();
        System.out.print("Enter Doctor ID to book appointment: ");
        int id = Integer.parseInt(sc.nextLine());

        Doctor selectedDoctor = null;
        for (Doctor d : doctors) {
            if (d.getId() == id) {
                selectedDoctor = d;
                break;
            }
        }

        if (selectedDoctor == null) {
            System.out.println("Invalid Doctor ID.\n");
            return;
        }

        Appointment ap = new Appointment(appointmentCounter++, patientName, selectedDoctor);
        appointments.add(ap);

        System.out.println("Appointment booked successfully!\n");
    }

    public void viewAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments available.\n");
            return;
        }

        System.out.println("----- Appointments -----");
        for (Appointment ap : appointments) {
            System.out.println(ap);
        }
        System.out.println();
    }

    public void cancelAppointment() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments to cancel.\n");
            return;
        }

        viewAppointments();
        System.out.print("Enter Appointment ID to cancel: ");
        int id = Integer.parseInt(sc.nextLine());

        Appointment found = null;
        for (Appointment ap : appointments) {
            if (ap.getAppointmentId() == id) {
                found = ap;
                break;
            }
        }

        if (found != null) {
            appointments.remove(found);
            System.out.println("Appointment cancelled successfully!\n");
        } else {
            System.out.println("Invalid Appointment ID.\n");
        }
    }
}

