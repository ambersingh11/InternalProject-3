package com.bit.controllers;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bit.dao.StudentDao;
import com.bit.entity.Admin;
import com.bit.entity.Student;


@Controller
@SessionAttributes("command")
public class FirstController {
	@Autowired
	private Admin admin;
	@Autowired
	private StudentDao dao;
	@RequestMapping("/")
	public String returnIndex(Model mdl){
		mdl.addAttribute("command",admin);
		return "index";
	}
	@RequestMapping(value="/homescreen",method=RequestMethod.GET)
	public String returnDepartments(Model mdl){
		List<String> deptList=new ArrayList<String>();
		deptList.add("Computer Science");
		deptList.add("Mechanical");
		deptList.add("Electronics");
		deptList.add("Civil");
		mdl.addAttribute("deptList",deptList);
		return "Departments";
	}
	@RequestMapping(value="/addData")
	public String addStudentDetails(@ModelAttribute("command") Student student){
		student.setGrade(student.calcPerformance());
		dao.add(student);
		return "Success";
	}
	@RequestMapping(value="/findPerformers/{dept}",method=RequestMethod.GET)
	public String getPerformers(@PathVariable("dept") String department, Model mdl){
		List<Student> list=dao.findByCriteria(department);
		mdl.addAttribute("student",list);
		return "ShowList";
	}
	
}
