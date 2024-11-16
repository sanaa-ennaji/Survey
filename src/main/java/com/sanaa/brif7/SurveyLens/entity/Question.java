package com.sanaa.brif7.SurveyLens.entity;

import com.sanaa.brif7.SurveyLens.entity.enums.QuestionType;
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
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String text;

    private Integer answerCount = 0;

    @Enumerated(EnumType.STRING)
    private QuestionType questionType;

    @ManyToOne
    private Subject subject;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Answer> answers;

    public void AnswerCount() {
        this.answerCount++;
    }

}
