package com.generation;

import java.util.Map.Entry;

import com.generation.exception.CourseNotFoundException;
import com.generation.exception.StudentNotFoundException;

public class Main {

    public static void main(String[] args) throws CourseNotFoundException, StudentNotFoundException {
	    StudentService studentService = new StudentService();
	    //TODO refactor this code to use encapsulation inside studentsService
        studentService.addStudent( "1030", new Student( "Carlos", "1030", 31 ) );
        studentService.addStudent( "1040", new Student( "Ian", "1040", 28 ) );
        studentService.addStudent( "1050", new Student( "Elise", "1050", 26 ) );
        studentService.addStudent( "1020", new Student( "Santiago", "1020", 33 ));
        
        try{
        studentService.enrollStudents( "Math", "1030" );
        studentService.enrollStudents( "Physics", "1050" );
        Student student = studentService.getStudents().get("1030"); 
        Course course = studentService.getCourseList().get("Math");
        System.out.println(student.toString());
        System.out.println(course.toString());
        System.out.println("============= Listado de todos los estudiantes ============");
        for (Entry<String, Student> entry : studentService.getStudents().entrySet()) {
            System.out.println(entry.getValue().toString());
        }
        System.out.println("============= Listado de todos los cursos ============");
        for (Entry<String, Course> entry : studentService.getCourseList().entrySet()) {
            System.out.println(entry.getValue().toString());
        }
        }catch (CourseNotFoundException | StudentNotFoundException e) {
            System.out.println(e.getMessage());
        }//trycatch
    }//main
}//classMain