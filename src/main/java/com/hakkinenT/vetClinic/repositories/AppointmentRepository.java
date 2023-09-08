package com.hakkinenT.vetClinic.repositories;

import com.hakkinenT.vetClinic.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
