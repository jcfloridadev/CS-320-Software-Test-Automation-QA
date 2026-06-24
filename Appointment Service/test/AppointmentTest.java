/*
 * CS 320 Module Five Milestone
 * Appointment Service Project
 * Developer: Justin Carlo Florida
 * Date: June 01, 2026
 */

package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import appointment.Appointment;

public class AppointmentTest {

    // Create future date
    private Date getFutureDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        return calendar.getTime();
    }

    // Create past date
    private Date getPastDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        return calendar.getTime();
    }

    @Test
    void testAppointmentCreatedSuccessfully() {
        Appointment appointment = new Appointment("A12345", getFutureDate(), "Doctor appointment");

        assertEquals("A12345", appointment.getAppointmentId());
        assertEquals("Doctor appointment", appointment.getDescription());
        assertNotNull(appointment.getAppointmentDate());
    }

    @Test
    void testAppointmentIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("A1234567890", getFutureDate(), "Doctor appointment");
        });
    }

    @Test
    void testAppointmentIdNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, getFutureDate(), "Doctor appointment");
        });
    }

    @Test
    void testAppointmentDateNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("A12345", null, "Doctor appointment");
        });
    }

    @Test
    void testAppointmentDateInPast() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("A12345", getPastDate(), "Doctor appointment");
        });
    }

    @Test
    void testDescriptionTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("A12345", getFutureDate(),
                    "This description is definitely longer than fifty characters total.");
        });
    }

    @Test
    void testDescriptionNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("A12345", getFutureDate(), null);
        });
    }

    @Test
    void testSetAppointmentDate() {
        Appointment appointment = new Appointment("A12345", getFutureDate(), "Doctor appointment");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 5);
        Date newDate = calendar.getTime();

        appointment.setAppointmentDate(newDate);

        assertEquals(newDate, appointment.getAppointmentDate());
    }

    @Test
    void testSetAppointmentDateNull() {
        Appointment appointment = new Appointment("A12345", getFutureDate(), "Doctor appointment");

        assertThrows(IllegalArgumentException.class, () -> {
            appointment.setAppointmentDate(null);
        });
    }

    @Test
    void testSetAppointmentDateInPast() {
        Appointment appointment = new Appointment("A12345", getFutureDate(), "Doctor appointment");

        assertThrows(IllegalArgumentException.class, () -> {
            appointment.setAppointmentDate(getPastDate());
        });
    }

    @Test
    void testSetDescription() {
        Appointment appointment = new Appointment("A12345", getFutureDate(), "Doctor appointment");

        appointment.setDescription("Updated appointment");

        assertEquals("Updated appointment", appointment.getDescription());
    }

    @Test
    void testSetDescriptionTooLong() {
        Appointment appointment = new Appointment("A12345", getFutureDate(), "Doctor appointment");

        assertThrows(IllegalArgumentException.class, () -> {
            appointment.setDescription("This description is longer than fifty characters total.");
        });
    }

    @Test
    void testSetDescriptionNull() {
        Appointment appointment = new Appointment("A12345", getFutureDate(), "Doctor appointment");

        assertThrows(IllegalArgumentException.class, () -> {
            appointment.setDescription(null);
        });
    }
}
