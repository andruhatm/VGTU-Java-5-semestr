package com.company;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    /*
    Написать метод выводящий площадь и имя неизвестного объекта (фигура, квартира, стол и т.д.).
    Данный метод получает в качестве параметра объект неизвестного типа (Object).

    Требуется узнать есть ли у этого объекта метод, возвращающий площадь и вызвать его если он есть.
    Данный объект должен быть помечен аннотацией @haveArea,
    а метод должен быть помечен аннотацией @returnArea.

    Имя объекта должно задаваться как параметр “name” аннотации @haveArea.
    */
    public static void main(String[] args) {
        SampleClass sampleClass = new SampleClass();
        show(sampleClass);
    }

    public static void show(Object object){
        Class<?> classObj = object.getClass();

        //checks object for needed annotation
        Annotation[] annotations = classObj.getAnnotations();
        for(Annotation annotation: annotations){
            if (annotation instanceof haveArea){
                System.out.println(((haveArea) annotation).name());
            }
        }

        //checks object for methods with needed annotation
        Method[] methods = classObj.getDeclaredMethods();
        for(Method m: methods){
            if(m.isAnnotationPresent(returnArea.class)){
                try {
                    m.invoke(object);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
