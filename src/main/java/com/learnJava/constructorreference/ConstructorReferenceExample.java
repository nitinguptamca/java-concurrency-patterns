package com.learnJava.constructorreference;

import com.learnJava.data.Student;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorReferenceExample {

    static Supplier<Student> studentSupplier = Student::new;
    static Consumer<Student> studentConsumer = a -> System.out.println(a);
    static Function<String, Student> studentFunction = Student::new;

    //Student student = Student::new;

    public static void main(String[] args) {

        System.out.println(studentSupplier.get());
        studentConsumer.accept(studentSupplier.get());
        System.out.println(studentFunction.apply("Client123"));
    }
}
