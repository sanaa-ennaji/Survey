package com.sanaa.brif7.SurveyLens.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    @ManyToOne
    private Subject parentSubject;

    @OneToMany(mappedBy = "parentSubject")
    private List<Subject> subSubjects;

    @ManyToOne
    private SurveyEdition surveyEdition;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Question> questions;


}
