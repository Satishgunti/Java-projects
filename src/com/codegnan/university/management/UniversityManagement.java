package com.codegnan.university.management;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.codegnan.university.exception.CourseNotFoundException;
import com.codegnan.university.exception.ProfessorNotFoundException;
import com.codegnan.university.exception.StudentNotFoundException;

public class UniversityManagement {
	private List<Student> students;
	private List<Professor> professors;
	private List<Course> courses;
	
	public UniversityManagement() {
		students = new ArrayList<>();
		professors = new ArrayList<>();
		courses = new ArrayList<>();
		
	}
	public void addStudent(String name) {
		students.add(new Student(name));
		
	}
	public void  addProfessor(String name) {
		professors.add(new Professor(name));
	}
	public void  addCourse(String title) {
		courses.add(new Course(title));
	}
	public void enrollStudentInCourse(String studentName , String courseTitle)throws StudentNotFoundException , CourseNotFoundException {
		Student students = findStudentByName(studentName);
		Course course = findCourseByTitle(courseTitle);
		if(students == null) {
			throw new StudentNotFoundException("Student "+studentName+" not found");
		}
		if(course == null) {
			throw new CourseNotFoundException("Course "+courseTitle+" not found");
		}
		students.enrollInCourse( course);
		
	}
	public void assignCourseToProfessor(String professorName , String courseTitle)throws  CourseNotFoundException ,ProfessorNotFoundException{
		Professor professor = findProfessorByName(professorName);
		Course course = findCourseByTitle(courseTitle);
		if(professor == null) {
			throw new ProfessorNotFoundException("Professor "+professorName+" not found");
		}
		if(course == null) {
			throw new CourseNotFoundException("Course "+courseTitle+" not found");
		}
		professor.assignCourse(course);
		
	}
	
	public void listStudents() {
		if (students.isEmpty()) {
			System.out.println("No Students Are Available");
		}
		else {
			System.out.println("List Of Students");
			for(Student student : students) {
				System.out.println(student);
			}
		}
	}
	public void listProfessors() {
		if(professors.isEmpty()) {
			System.out.println(" Professors data not available ");
				
		}
		else {
			System.out.println("List of Professors ");
			for(Professor professor : professors) {
				System.out.println(professor);
			}
		}
	}
	public void listCourse() {
		if(courses.isEmpty()) {
			System.out.println(" Professors data not available ");
				
		}
		else {
			System.out.println("List of Courses ");
			for(Course course : courses) {
				System.out.println(course);
			}
		}
	}
	public void displayStudentCourses(String studentName)throws StudentNotFoundException{
		Student student = findStudentByName(studentName);
		if(student == null) {
			throw new StudentNotFoundException("Student "+studentName+"  Not Found");
		}
		System.out.println(" Course For Student : "+studentName);
		for(Course course : student.getEnrolledCourses()) {
			System.out.println(course);
		}
	}
	public void displayProfessorCourses(String professorName)throws ProfessorNotFoundException{
		Professor professor = findProfessorByName(professorName);
		if(professor == null) {
			throw new ProfessorNotFoundException("Professor "+professorName+" Not Found");
		}
		System.out.println("Course Assigned For Professor : "+professorName);
		for(Course course : professor.getAssignedCourses()) {
			System.out.println(course);
		}
		
	}
	public Student findStudentByName(String name) {
		for(Student student : students) {
			if(student.getName().equalsIgnoreCase(name)) {
				return student;
			}
		}
		return null;
	}
	public Professor findProfessorByName(String name) {
		for(Professor professor : professors) {
			if(professor.getName().equalsIgnoreCase(name)) {
			}
		}
		return null;
	}
	public Course findCourseByTitle(String title) {
		for(Course course : courses) {
			if(course.getTitle().equalsIgnoreCase(title)) {
				return course;
			}
		}
		return null;
	}
	public static void main(String[] args) {
		UniversityManagement manage = new UniversityManagement();
		Scanner scanner = new Scanner(System.in);
		boolean running = true;
		while(running) {
			System.out.println("||=======================================================||");
			System.out.println("          Welcome to University Management System          ");
			System.out.println("||=======================================================||");
			System.out.println("||            1. Add Student                             ||");
			System.out.println("||            2. Add Professor                           ||");
			System.out.println("||            3. Add Courses                             ||");
			System.out.println("||            4. Enroll Student In Course                ||");
			System.out.println("||            5. Assign Course to Professor              ||");
			System.out.println("||            6. List of Students                        ||");
			System.out.println("||            7. List of Professors                      ||");
			System.out.println("||            8. List Of Courses                         ||");
			System.out.println("||            9. Display Student Courses                 ||");
			System.out.println("||           10. Display Professor Courses               ||");
			System.out.println("||           11. Exit                                    ||");
			System.out.println("||_______________________________________________________||");
			int choice = scanner.nextInt();
			scanner.nextLine();
			
			try {
				switch(choice) {
				case 1:
					System.out.println("Enter Student Name : ");
					String studentName = scanner.nextLine();
					manage.addStudent(studentName);
					break;
				case 2 :
					System.out.println("Enter professor Name : ");
					String professorName = scanner.nextLine();
					manage.addProfessor(professorName);
					break;
				case 3:
					System.out.println("Enter course Ttitle : ");
					String courseTitle = scanner.nextLine();
					manage.addCourse(courseTitle);
					break;
				case 4:
					System.out.println("Enter the student name you want to enroll : ");
					String enrollStudent = scanner.nextLine();
					System.out.println("Enter course title :");
					String enrollCourse = scanner.nextLine();
					try {
						manage.enrollStudentInCourse(enrollStudent,enrollCourse);
					}catch(StudentNotFoundException | CourseNotFoundException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 5:
					System.out.println("Eneter the professor name : ");
					String assignProfessor = scanner.nextLine();
					System.out.println("Enter Course Title : ");
					String assignCourse = scanner.nextLine();
					try {
						manage.assignCourseToProfessor(assignProfessor , assignCourse);
					}catch(ProfessorNotFoundException | CourseNotFoundException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 6 :
					manage.listStudents();
					break;
				case 7:
					manage.listProfessors();
					break;
				case 8:
					manage.listCourse();
					break;
				case 9:
					System.out.println("Enter the Student name : ");
					String displayStudent = scanner.nextLine();
					try {
						manage.displayStudentCourses(displayStudent);
					}catch(StudentNotFoundException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 10:
					System.out.println("Enter professor name : ");
					String displayProfessor = scanner.nextLine();
					try {
						manage.displayProfessorCourses(displayProfessor);
					}catch(ProfessorNotFoundException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 11:
					running = false;
					System.out.println("Exiting ....!");
					break;
				default:
					System.out.println("Invalid choice . Please enter a number  between 1 to 11.");
					break;
					
				}
			}catch(Exception e) {
				System.out.println("An unexpected error occured : "+e.getMessage());
			}
		}
		
		scanner.close();
	}
	
}
