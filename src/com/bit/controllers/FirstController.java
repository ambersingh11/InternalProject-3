package com.bit.controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import com.bit.dao.StudentDao;
import com.bit.entity.Admin;
import com.bit.entity.Student;


@Controller
//@SessionAttributes("command")
public class FirstController{
	@Autowired
	private Admin admin;
	@Autowired
	private StudentDao dao;
	@RequestMapping("/")
	public String returnIndex(HttpServletRequest request,HttpServletResponse response,Model mdl){
		//HttpSession session=request.getSession();
		//session.setAttribute();
		mdl.addAttribute("command",admin);
		return "index";
	}
	@RequestMapping(value="/departmentlist",method=RequestMethod.GET)
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
	public String addStudentDetails(@ModelAttribute("command") Student student,@RequestParam("image") MultipartFile image){
		File file=null;
		try{	
			file = new File("D:\\asi260\\InternalProject3\\WebContent\\resources\\images\\"+student.getName()+".jpg");
			FileUtils.writeByteArrayToFile(file, image.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		student.setImagePath(file.getPath());
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
