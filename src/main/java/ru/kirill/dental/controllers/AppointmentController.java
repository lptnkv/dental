package ru.kirill.dental.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kirill.dental.entities.Appointment;
import ru.kirill.dental.entities.Doctor;
import ru.kirill.dental.repositories.AppointmentRepository;
import ru.kirill.dental.repositories.DoctorRepository;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/create")
public class AppointmentController {
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;

    @Autowired
    public AppointmentController(AppointmentRepository appointmentRepository, DoctorRepository doctorRepository) {
        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
    }

    @GetMapping
    public String register(Model model) {
        List<Doctor> doctors = doctorRepository.findAll();
        model.addAttribute("doctors", doctors);
        model.addAttribute("UserForm", new Appointment());
        return "create";
    }

    @PostMapping
    public String addAppointment(@ModelAttribute("UserForm") Appointment appForm, BindingResult bindingResult, Model model) {
        String phoneNumber = appForm.getPhoneNumber();
        if (phoneNumber.isBlank()) {
            model.addAttribute("error", "Введите номер телефона");
            model.addAttribute("UserForm", new Appointment());
            model.addAttribute("doctors", doctorRepository.findAll());
            return "create";
        }
        Pattern pattern = Pattern.compile("^(\\+7|7|8)?[\\s\\-]?\\(?[489][0-9]{2}\\)?[\\s\\-]?[0-9]{3}[\\s\\-]?[0-9]{2}[\\s\\-]?[0-9]{2}$");
        Matcher match = pattern.matcher(phoneNumber);
        if (!match.matches()) {
            model.addAttribute("error", "Неправильный номер телефона");
            model.addAttribute("UserForm", new Appointment());
            model.addAttribute("doctors", doctorRepository.findAll());
            return "create";
        }

        String name = appForm.getCustomer();
        if (name.isBlank()) {
            model.addAttribute("error", "Введите имя");
            model.addAttribute("UserForm", new Appointment());
            model.addAttribute("doctors", doctorRepository.findAll());
            return "create";
        }

        Date date = appForm.getDate();
        if (date.before(new Date(System.currentTimeMillis()))) {
            model.addAttribute("error", "Указанная дата уже прошла");
            model.addAttribute("UserForm", new Appointment());
            model.addAttribute("doctors", doctorRepository.findAll());
            return "create";
        }
        appointmentRepository.saveAndFlush(appForm);
        return "redirect:/";
    }
}
