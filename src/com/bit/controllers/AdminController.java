package com.bit.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.bit.dao.AdminDao;
import com.bit.entity.Admin;
import com.bit.entity.Student;

@Controller
@SessionAttributes("command")
public class AdminController {
	@Autowired
	@Qualifier("dao")
	private AdminDao dao;
	@Autowired
	private ModelAndView mdl;
	@Autowired
	private Student student;
	@Autowired
	private Admin admin;
	@RequestMapping(value="/adminpage",method=RequestMethod.POST)
	public ModelAndView returnForm(@Valid @ModelAttribute("admin") Admin admin,BindingResult result){
		if(!result.hasErrors()){
			if(dao.find(admin.getUserName())!=null){
				mdl.setViewName("ShowForm");
				mdl.addObject("command",student);
				return mdl;
			}
			return mdl;
		}
		else{
			mdl.setViewName("index");
			mdl.addObject("command",admin);
			return mdl;
		}
	}
	@RequestMapping(value="/adminpage")
	public String addAgain(Model mdl){
		mdl.addAttribute("command",student);
		return "ShowForm";
	}
	@ModelAttribute("departments")
	public List<String> getDepartmnets(){
		List<String> departments=new ArrayList<String>();
		departments.add("Computer Science");
		departments.add("Mechanical");
		departments.add("Electronics");
		departments.add("Civil");
		return departments;
	}
	@RequestMapping("/logout")
	public String logOut(SessionStatus status,Model mdl){
		status.setComplete();
		mdl.addAttribute("command",admin);
		return "index";
	}
}
