package com.codegnan.university.management;

import java.util.ArrayList;
import java.util.List;

public class Professor {
	private String Name;
	private List<Course>assignedCourses;
	
	public Professor(String name) {
		super();
		this.Name = name;
		this.assignedCourses = new ArrayList<>();
		
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}
	public void assignCourse(Course course) {
		if(!assignedCourses.contains(course)) {
			assignedCourses.add(course);
		}
	}
	

	public List<Course> getAssignedCourses() {
		return assignedCourses;
	}

	public void setAssignedCourses(List<Course> assignedCourses) {
		this.assignedCourses = assignedCourses;
	}

	@Override
	public String toString() {
		return  Name ;
	}

	
	

}
