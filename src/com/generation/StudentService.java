package com.generation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import com.generation.exception.CourseNotFoundException;
import com.generation.exception.StudentNotFoundException;



public class StudentService
{
    HashMap<String, Course> courseList = new HashMap<>();

    HashMap<String, Student> students = new HashMap<>();

    HashMap<String, List<Course>> coursesEnrolledByStudents = new HashMap<>();

    
    public StudentService()
    {
        courseList.put( "Math", new Course( "Math", 10, "Aurelio Baldor" ) );
        courseList.put( "Physics", new Course( "Physics", 10, "Albert Einstein" ) );
        courseList.put( "Art", new Course( "Art", 10, "Pablo Picasso" ) );
        courseList.put( "History", new Course( "History", 10, "Sima Qian" ) );
        courseList.put( "Biology", new Course( "Biology", 10, "Charles Darwin" ) );
    }

    public void enrollStudents( String courseName, String studentID ) throws CourseNotFoundException, StudentNotFoundException 
    {
        Course course = courseList.get( courseName );
        if(course == null) {
            throw new CourseNotFoundException(courseName + " No encontrado");
        }

        Student student = students.get(studentID);
        if (student == null) {
            throw new StudentNotFoundException(studentID + " No encontrado");
        }

        if ( !coursesEnrolledByStudents.containsKey( studentID ) )
        {
            coursesEnrolledByStudents.put( studentID, new ArrayList<>() );
        }
        coursesEnrolledByStudents.get( studentID ).add( course );
    }//enrollStudents

    public void unEnrollStudents( String courseName, String studentID )
    {
        Course course = courseList.get( courseName );

        if ( coursesEnrolledByStudents.containsKey( studentID ) )
        {
            coursesEnrolledByStudents.get( studentID ).remove( course );
        }//if
    }//unEnrollStudents

    public void showEnrolledStudents(String courseId){
    	for (Entry<String, List<Course>> entry : coursesEnrolledByStudents.entrySet()) {
            String studentID = entry.getKey();
            List<Course> enrolledCourses = entry.getValue();
            System.out.println("ID del estudiante " + studentID);
        }
    }//showEnrolledStudents

    public void showAllCourses(){
    	System.out.println("Cursos Disponibles:");

        for (Entry<String, Course> entry : courseList.entrySet()) {
            Course course = entry.getValue();
            System.out.println("Curso: " + course.getName() + ", Profesor/a: " + course.getProfessorName());
        }
    }//showAllStudent
    
public void addStudent(String id, Student student) {
	students.put(id, student);
	 
}//addStudent

public HashMap<String, Student> getStudents() {
        return students; // Consider returning an unmodifiable view for better encapsulation
    }
public HashMap<String, Course> getCourseList() {
    return courseList;
}

}