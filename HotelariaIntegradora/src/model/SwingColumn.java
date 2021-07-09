package model;

/**
 * SwingColumn.java
 *
 * $Id$
 *
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @author Dyego Souza do Carmo
 * @since 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface SwingColumn {

    String description();
    String colorOfBackgound() default "";
}
