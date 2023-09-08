package com.hakkinenT.vetClinic.dto;

import com.hakkinenT.vetClinic.entities.Exam;

public class ExamDTO {
    private Long id;
    private String description;

    public ExamDTO(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public ExamDTO(Exam exam) {
        id = exam.getId();
        description = exam.getDescription();
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
