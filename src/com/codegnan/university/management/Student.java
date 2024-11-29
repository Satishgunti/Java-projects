package com.codegnan.university.management;

import java.util.ArrayList;
import java.util.List;

public class Student {
	private String Name;
	private List<Course>enrolledCourses;
	
	public Student(String name) {
		super();
		this.Name = name;
		this.enrolledCourses = new ArrayList<>();
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}
	
	

	public List<Course> getEnrolledCourses() {
		return enrolledCourses;
	}
	public  void enrollInCourse(Course course) {
		if(!enrolledCourses.contains(course)) {
			enrolledCourses.add(course);
		}
		
	}

	public void setEnrolledCourses(List<Course> enrolledCourses) {
		this.enrolledCourses = enrolledCourses;
	}

	@Override
	public String toString() { 
		return Name ;
	}

	

	


}
