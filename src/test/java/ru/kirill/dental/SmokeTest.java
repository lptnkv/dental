package ru.kirill.dental;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.kirill.dental.controllers.AdminController;
import ru.kirill.dental.controllers.AppointmentController;
import ru.kirill.dental.controllers.DoctorsController;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SmokeTest {
    @Autowired
    DoctorsController doctorsController;
    @Autowired
    AppointmentController appointmentController;
    @Autowired
    AdminController adminController;

    @Test
    void contextLoads() {
        assertThat(doctorsController).isNotNull();
        assertThat(appointmentController).isNotNull();
        assertThat(adminController).isNotNull();
    }
}
