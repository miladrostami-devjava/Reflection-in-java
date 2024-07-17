package org.example;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.FIELD})
@Documented
public @interface MyAnnotation {
    String value();
}
