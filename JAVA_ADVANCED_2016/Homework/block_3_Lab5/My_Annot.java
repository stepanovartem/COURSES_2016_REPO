/**
 * 
 */
package block_3_Lab5;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author artem.stepanov
 *
 */
@Target ({ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface My_Annot {
	String info() default "My method";
}
