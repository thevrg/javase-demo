package hu.dpc.edu.javase.demo.annot;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author IQJB
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(RolesAlloweds.class)
public @interface RolesAllowed {
    Role[] value();
    String displayName() default "";
}
