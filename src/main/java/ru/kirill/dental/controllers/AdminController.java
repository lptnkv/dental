package ru.kirill.dental.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kirill.dental.entities.Appointment;
import ru.kirill.dental.entities.Doctor;
import ru.kirill.dental.repositories.AppointmentRepository;
import ru.kirill.dental.repositories.DoctorRepository;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    DoctorRepository doctorRepository;

    @GetMapping("/admin")
    public String admin(Model model) {
        List<Appointment> appointments = appointmentRepository.findAll();
        List<Doctor> doctors = doctorRepository.findAll();
        model.addAttribute("appointments", appointments);
        model.addAttribute("doctors", doctors);
        return "admin";
    }
}
