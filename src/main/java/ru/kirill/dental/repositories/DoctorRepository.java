package ru.kirill.dental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kirill.dental.entities.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
}
