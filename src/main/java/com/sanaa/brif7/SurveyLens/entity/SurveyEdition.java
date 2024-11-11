package com.sanaa.brif7.SurveyLens.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SurveyEdition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @PastOrPresent(message = "La date de création doit être dans le passé ou aujourd'hui.")
    private LocalDate creationDate;

    @NotNull
    @Future(message = "La date de début doit être dans le futur.")
    private LocalDate startDate;

    @NotNull
    private Integer year;

    @ManyToOne
    private Survey survey;

    @OneToMany(mappedBy = "surveyEdition", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Subject> subjects;
}
