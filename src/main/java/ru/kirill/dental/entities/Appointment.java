package ru.kirill.dental.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "appointments")
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "date")
    private Date date;
    @Column(name = "customer")
    private String customer;
    @Column(name = "doctor_id")
    private int doctor_id;
    @Column(name = "notes")
    private String notes;
    @Column(name = "phone_number")
    private String phoneNumber;
}