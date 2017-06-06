package com.appframe.annotation.view;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ViewInject {
	public int id();
	public String click() default "";
	public String longClick() default "";
	public String touch() default "";
	public String itemClick() default "";
	public String itemLongClick() default "";
}
