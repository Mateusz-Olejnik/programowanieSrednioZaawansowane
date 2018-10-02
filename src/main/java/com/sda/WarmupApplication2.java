package com.sda;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class WarmupApplication2 {
    public static void main(String[] args) {
        List<Student> studentList = createStudentsList();

        //wypisać tylko kobiety z age powyzej 20
        studentList.stream()
                .filter(e -> e.getGender() == Gender.FEMALE)
                .filter(e -> e.getAge() > 20)
                .forEach(e -> System.out.println(e));

        // wypisać tylko studentów o nazwisku Nowak
        System.out.println("==================================================================");
        studentList.stream()
                .filter(e -> "Nowak".equals(e.getLastName()))
                .forEach(e -> System.out.println(e));

        // wypisac ilosc studentow majacych powyzej 20 lat
        System.out.println("==================================================================");
        System.out.println(studentList.stream()
                .filter(e -> e.getAge() > 20)
                .count());

        // wypisac srednia wieku (mapToInt)
        System.out.println("==================================================================");
        System.out.println(studentList.stream()
                .mapToInt(e -> e.getAge())
                .average()
                .getAsDouble());

        // wypisac dla kazdego studenta srednia ocen
        System.out.println("==================================================================");
        studentList.stream()
        .forEach(student -> {
            Map<Subject, Double> grades = student.getGrades();
            System.out.println("Student " + student.getFirstName() + " " + student.getLastName());
            System.out.println(grades.entrySet().stream()
                    .mapToDouble(entry -> entry.getValue())
                    .average()
                    .getAsDouble());
        });


        // wypisac tylko studentow ktorzy maja zaliczone wszystkie przedmioty
        System.out.println("==================================================================");
        studentList.stream()
                .filter(student -> student.getGrades().entrySet().stream()
                .map(grade -> grade.getValue())
                .allMatch(grade -> grade >= 3.0))
                .forEach(student -> System.out.println(student));



    }

    public static List<Student> createStudentsList() {

        Student student = Student.builder()
                .firstName("Szymon")
                .lastName("Nowak")
                .gender(Gender.MALE)
                .age(24)
                .build()
                .addGrade(Subject.MATH, 3.5)
                .addGrade(Subject.PROGRAMMING, 4.5);

        Student student2 = Student.builder()
                .firstName("Jan")
                .lastName("Kowalski")
                .gender(Gender.MALE)
                .age(22)
                .build()
                .addGrade(Subject.MATH, 2.0)
                .addGrade(Subject.PROGRAMMING, 3.5);

        Student student3 = Student.builder()
                .firstName("Anna")
                .lastName("Wisniewska")
                .gender(Gender.FEMALE)
                .age(21)
                .build()
                .addGrade(Subject.MATH, 5.0)
                .addGrade(Subject.PROGRAMMING, 4.5);

        Student student4 = Student.builder()
                .firstName("Karolina")
                .lastName("Nowak")
                .gender(Gender.FEMALE)
                .age(19)
                .build()
                .addGrade(Subject.MATH, 4.0)
                .addGrade(Subject.PROGRAMMING, 2.0);

        return Arrays.asList(student, student2, student3, student4);

    }

}
