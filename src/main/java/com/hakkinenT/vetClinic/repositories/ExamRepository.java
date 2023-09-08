package com.hakkinenT.vetClinic.repositories;

import com.hakkinenT.vetClinic.entities.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam, Long> {
}
