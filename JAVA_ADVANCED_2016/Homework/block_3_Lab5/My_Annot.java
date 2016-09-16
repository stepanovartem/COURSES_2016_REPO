/**
 * 
 */
package block_3_Lab5;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @author artem.stepanov
 *
 */
@Target ({ElementType.METHOD})
public @interface My_Annot {
	String info() default "My method";
}
