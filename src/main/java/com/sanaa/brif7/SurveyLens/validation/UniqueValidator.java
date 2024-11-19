package com.sanaa.brif7.SurveyLens.validation;

import com.sanaa.brif7.SurveyLens.annotation.Unique;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueValidator implements ConstraintValidator<Unique, String> {

    @PersistenceContext
    private EntityManager entityManager;

    private Class<?> entity;
    private String field;

    @Override
    public void initialize(Unique constraintAnnotation) {
        this.entity = constraintAnnotation.entity();
        this.field = constraintAnnotation.field();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        try {
            String query = String.format("SELECT COUNT(e) FROM %s e WHERE e.%s = :value", entity.getSimpleName(), field);
            System.out.println("Query: " + query);
            Long count = (Long) entityManager.createQuery(query)
                    .setParameter("value", value)
                    .getSingleResult();

            System.out.println("Count result: " + count);

            return count == 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}
