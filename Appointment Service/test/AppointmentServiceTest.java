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
import appointment.AppointmentService;

public class AppointmentServiceTest {

    // Create future date
    private Date getFutureDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        return calendar.getTime();
    }

    @Test
    void testAddAppointment() {
        AppointmentService service = new AppointmentService();
        Appointment appointment = new Appointment("A12345", getFutureDate(), "Doctor appointment");

        service.addAppointment(appointment);

        assertEquals(appointment, service.getAppointment("A12345"));
    }

    @Test
    void testAddDuplicateAppointmentId() {
        AppointmentService service = new AppointmentService();
        Appointment appointment1 = new Appointment("A12345", getFutureDate(), "Doctor appointment");
        Appointment appointment2 = new Appointment("A12345", getFutureDate(), "Dentist appointment");

        service.addAppointment(appointment1);

        assertThrows(IllegalArgumentException.class, () -> {
            service.addAppointment(appointment2);
        });
    }

    @Test
    void testAddNullAppointment() {
        AppointmentService service = new AppointmentService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.addAppointment(null);
        });
    }

    @Test
    void testDeleteAppointment() {
        AppointmentService service = new AppointmentService();
        Appointment appointment = new Appointment("A12345", getFutureDate(), "Doctor appointment");

        service.addAppointment(appointment);
        service.deleteAppointment("A12345");

        assertNull(service.getAppointment("A12345"));
    }

    @Test
    void testDeleteAppointmentThatDoesNotExist() {
        AppointmentService service = new AppointmentService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteAppointment("A12345");
        });
    }

    @Test
    void testDeleteAppointmentIdNull() {
        AppointmentService service = new AppointmentService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteAppointment(null);
        });
    }
}