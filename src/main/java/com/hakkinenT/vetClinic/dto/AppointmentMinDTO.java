package com.hakkinenT.vetClinic.dto;

import com.hakkinenT.vetClinic.entities.Appointment;
import com.hakkinenT.vetClinic.entities.Exam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AppointmentMinDTO {
    private Long id;
    private LocalDate date;
    private AnimalDTO animal;
    private VetMinDTO vet;

    private TreatmentMinDTO treatmentInit;

    public AppointmentMinDTO(Long id, LocalDate date, AnimalDTO animal, VetMinDTO vet, TreatmentMinDTO treatmentInit) {
        this.id = id;
        this.date = date;
        this.animal = animal;
        this.vet = vet;
        this.treatmentInit = treatmentInit;
    }

    public AppointmentMinDTO(Appointment appointment) {
        id = appointment.getId();
        date = appointment.getDate();
        animal = new AnimalDTO(appointment.getTreatment().getAnimal());
        vet = new VetMinDTO(appointment.getVet());
        treatmentInit = new TreatmentMinDTO(appointment.getTreatment());
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public AnimalDTO getAnimal() {
        return animal;
    }

    public VetMinDTO getVet() {
        return vet;
    }

    public TreatmentMinDTO getTreatmentInit() {
        return treatmentInit;
    }
}
