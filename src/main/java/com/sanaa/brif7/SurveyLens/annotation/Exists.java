package com.sanaa.brif7.SurveyLens.annotation;


import com.sanaa.brif7.SurveyLens.entity.Question;

public @interface Exists {

    Class<Question> entity();

    String message();
}
