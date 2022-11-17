package ru.kirill.dental.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kirill.dental.entities.Doctor;
import ru.kirill.dental.repositories.DoctorRepository;

import java.util.List;

@Controller
public class DoctorsController {
    @Autowired
    DoctorRepository doctorRepository;
    @GetMapping("/doctors")
    public String doctors(Model model){
        List<Doctor> doctorList = doctorRepository.findAll();
        model.addAttribute("doctorList", doctorList);
        return "doctors";
    }
}