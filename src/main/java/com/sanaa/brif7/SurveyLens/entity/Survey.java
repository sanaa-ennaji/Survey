package com.sanaa.brif7.SurveyLens.entity;

import com.sanaa.brif7.SurveyLens.annotation.Unique;
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
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Unique(entity = Survey.class, field = "title")
    private String title;

    @NotBlank
    private String description;

    @ManyToOne
    private Owner owner;

    @OneToMany(mappedBy = "survey", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<SurveyEdition> surveyEditions ;
}
