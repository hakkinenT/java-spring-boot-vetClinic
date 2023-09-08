package com.hakkinenT.vetClinic.dto;

import com.hakkinenT.vetClinic.entities.Appointment;
import com.hakkinenT.vetClinic.entities.Exam;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDTO {
    private Long id;
    private String report;
    private LocalDate date;
    private AnimalDTO animal;
    private VetMinDTO vet;

    private TreatmentMinDTO treatment;

    private List<ExamDTO> exams = new ArrayList<>();

    public AppointmentDTO(Long id, String report, LocalDate date, AnimalDTO animal, VetMinDTO vet, TreatmentMinDTO treatment) {
        this.id = id;
        this.report = report;
        this.date = date;
        this.animal = animal;
        this.vet = vet;
        this.treatment = treatment;
    }

    public AppointmentDTO(Appointment appointment) {
        id = appointment.getId();
        report = appointment.getReport();
        date = appointment.getDate();
        animal = new AnimalDTO(appointment.getTreatment().getAnimal());
        vet = new VetMinDTO(appointment.getVet());
        treatment = new TreatmentMinDTO(appointment.getTreatment());
        for (Exam exam : appointment.getExams()){
            exams.add(new ExamDTO(exam));
        }
    }

    public Long getId() {
        return id;
    }

    public String getReport() {
        return report;
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

    public TreatmentMinDTO getTreatment() {
        return treatment;
    }

    public List<ExamDTO> getExams() {
        return exams;
    }
}
