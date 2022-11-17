package ru.kirill.dental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kirill.dental.entities.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

}
