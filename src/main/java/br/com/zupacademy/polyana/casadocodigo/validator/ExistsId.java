package br.com.zupacademy.polyana.casadocodigo.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Constraint(validatedBy = {ExistsIdValidator.class})
public @interface ExistsId {

    String message() default "{br.com.zupacademy.casadocodigo.validator.ExistsId}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String fieldName();

    Class<?> domainClass();
}

