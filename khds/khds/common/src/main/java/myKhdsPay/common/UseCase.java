package myKhdsPay.common;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface UseCase {
//특별한 기능을 하지는 않고 어댑터라는 것을 보여주는 용도
    @AliasFor(annotation = Component.class)
    String value() default "";
}
