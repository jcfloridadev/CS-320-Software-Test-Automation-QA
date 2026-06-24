/*
 * CS 320 Module Five Milestone
 * Appointment Service Project
 * Developer: Justin Carlo Florida
 * Date: June 01, 2026
 */

package appointment;

import java.util.Date;

public class Appointment {

    // Unique appointment ID
    private final String appointmentId;

    // Appointment date
    private Date appointmentDate;

    // Appointment description
    private String description;

    // Constructor
    public Appointment(String appointmentId, Date appointmentDate, String description) {

        // Validate appointment ID
        if (appointmentId == null || appointmentId.length() > 10) {
            throw new IllegalArgumentException("Invalid appointment ID");
        }

        // Validate appointment date
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Invalid appointment date");
        }

        // Validate description
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description");
        }

        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

    // Return appointment ID
    public String getAppointmentId() {
        return appointmentId;
    }

    // Return appointment date
    public Date getAppointmentDate() {
        return appointmentDate;
    }

    // Return description
    public String getDescription() {
        return description;
    }

    // Update appointment date
    public void setAppointmentDate(Date appointmentDate) {

        // Validate appointment date
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Invalid appointment date");
        }

        this.appointmentDate = appointmentDate;
    }

    // Update description
    public void setDescription(String description) {

        // Validate description
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description");
        }

        this.description = description;
    }
}
