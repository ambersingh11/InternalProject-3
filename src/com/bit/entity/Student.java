package com.bit.entity;

import org.springframework.stereotype.Component;

@Component
public class Student {
	private long rollNo;
	private String name;
	private String department;
	private double academics;
	private double events;
	private double sports;
	private double cultural;
	private double grade;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(long rollNo, String name, String department, double academics, double events, double sports,
			double cultural) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.department = department;
		this.academics = academics;
		this.events = events;
		this.sports = sports;
		this.cultural = cultural;
	}
	public long getRollNo() {
		return rollNo;
	}
	public void setRollNo(long rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public double getAcademics() {
		return academics;
	}
	public void setAcademics(double academics) {
		this.academics = academics;
	}
	public double getEvents() {
		return events;
	}
	public void setEvents(double events) {
		this.events = events;
	}
	public double getSports() {
		return sports;
	}
	public void setSports(double sports) {
		this.sports = sports;
	}
	public double getCultural() {
		return cultural;
	}
	public void setCultural(double cultural) {
		this.cultural = cultural;
	}
	
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	public double calcPerformance(){
		double score=0.0;
		score += 0.5*getAcademics();
		score += 0.1*getEvents();
		score += 0.2*getSports();
		score += 0.2*getCultural();
		return score;
	}
	
}
