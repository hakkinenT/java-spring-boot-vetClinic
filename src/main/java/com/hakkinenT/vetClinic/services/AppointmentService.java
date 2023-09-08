package com.hakkinenT.vetClinic.services;

import com.hakkinenT.vetClinic.dto.AppointmentDTO;
import com.hakkinenT.vetClinic.dto.AppointmentMinDTO;
import com.hakkinenT.vetClinic.entities.Animal;
import com.hakkinenT.vetClinic.entities.Appointment;
import com.hakkinenT.vetClinic.entities.Treatment;
import com.hakkinenT.vetClinic.entities.Vet;
import com.hakkinenT.vetClinic.repositories.*;
import com.hakkinenT.vetClinic.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private TreatmentRepository treatmentRepository;

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private VetRepository vetRepository;

    @Transactional
    public AppointmentMinDTO register(AppointmentMinDTO dto){
        Appointment appointment = new Appointment();
        copyDtoToEntity(dto,appointment);

        appointment = appointmentRepository.save(appointment);

        return new AppointmentMinDTO(appointment);

    }

    private void copyDtoToEntity(AppointmentMinDTO dto, Appointment appointment){
        appointment.setDate(dto.getDate());

        Vet vet = getVet(dto.getVet().getId());
        appointment.setVet(vet);
        vet.getAppointments().add(appointment);


        Treatment treatment;

        if(dto.getTreatmentInit() == null){

            treatment = createTreatment(dto.getDate(), dto.getAnimal().getId(), appointment);
        }else{
            treatment = getTreatment(
                    dto.getAnimal().getId(),
                    dto.getTreatmentInit().getInitialDate(),
                    appointment);
        }

        appointment.setTreatment(treatment);
    }

    private Vet getVet(Long id){
        try {
            Vet vet = vetRepository.getReferenceById(id);

            return vet;
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Veterinário não encontrado.");
        }
    }

    private Treatment createTreatment(LocalDate appointmentDate, Long animal_id, Appointment appointment){
        Treatment treatment = new Treatment();
        treatment.setInitialDate(appointmentDate);

        Animal animal = getAnimal(animal_id);
        treatment.setAnimal(animal);
        treatment.getAppointments().add(appointment);
        animal.getTreatments().add(treatment);

        treatment = treatmentRepository.save(treatment);

        return treatment;
    }

    private Animal getAnimal(Long id){

        try {
            Animal animal = animalRepository.getReferenceById(id);
            return animal;
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Animal não encontrado.");
        }
    }

    private Treatment getTreatment(Long animal_id, LocalDate treatmentInitalDate, Appointment appointment){
        Treatment treatment = treatmentRepository.searchIfExists(animal_id,
                        treatmentInitalDate)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Tratamento não encontrado"));
        treatment.getAppointments().add(appointment);
        return treatment;
    }

}
