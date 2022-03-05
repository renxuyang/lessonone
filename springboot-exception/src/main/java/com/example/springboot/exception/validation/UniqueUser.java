package com.example.springboot.exception.validation;



import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Constraint(validatedBy = UpsertValidatorClass.class) // 绑定对应校验器
public @interface UniqueUser {
    String id() default "id";;

    String field();

    String message() default "用户重名";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
