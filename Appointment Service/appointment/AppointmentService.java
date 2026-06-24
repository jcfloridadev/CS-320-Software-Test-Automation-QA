/*
 * CS 320 Module Five Milestone
 * Appointment Service Project
 * Developer: Justin Carlo Florida
 * Date: June 01, 2026
 */

package appointment;

import java.util.HashMap;

public class AppointmentService {

    // Store appointments using appointment ID
    private final HashMap<String, Appointment> appointments = new HashMap<>();

    // Add appointment
    public void addAppointment(Appointment appointment) {

        // Validate appointment object
        if (appointment == null) {
            throw new IllegalArgumentException("Appointment cannot be null");
        }

        // Check for duplicate appointment ID
        if (appointments.containsKey(appointment.getAppointmentId())) {
            throw new IllegalArgumentException("Appointment ID already exists");
        }

        appointments.put(appointment.getAppointmentId(), appointment);
    }

    // Delete appointment using appointment ID
    public void deleteAppointment(String appointmentId) {

        // Validate appointment ID
        if (appointmentId == null || !appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment ID does not exist");
        }

        appointments.remove(appointmentId);
    }

    // Return appointment using appointment ID
    public Appointment getAppointment(String appointmentId) {
        return appointments.get(appointmentId);
    }
}
