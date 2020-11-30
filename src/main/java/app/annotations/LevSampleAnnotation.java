package app.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD}) // who can get this annotation (here: classes and methods)
@Retention(RetentionPolicy.RUNTIME) // the deepest layer this annotation is used (here: runtime)
public @interface LevSampleAnnotation {
}
