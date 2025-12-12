package com.hospital;

public class Appointment {
    private int appointmentId;
    private String patientName;
    private Doctor doctor;

    public Appointment(int appointmentId, String patientName, Doctor doctor) {
        this.appointmentId = appointmentId;
        this.patientName = patientName;
        this.doctor = doctor;
    }

    public int getAppointmentId() { return appointmentId; }
    public String getPatientName() { return patientName; }
    public Doctor getDoctor() { return doctor; }

    @Override
    public String toString() {
        return "Appointment ID: " + appointmentId + ", Patient: " + patientName +
                ", Doctor: " + doctor.getName() + " (" + doctor.getSpecialization() + ")";
    }
}

