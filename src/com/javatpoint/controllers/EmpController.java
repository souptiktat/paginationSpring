package com.javatpoint.controllers;

//import java.util.ArrayList;  
import java.util.List;  
  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;  
//import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
//import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.servlet.ModelAndView;  
import com.javatpoint.beans.Emp;  
import com.javatpoint.dao.EmpDao;  

@Controller
public class EmpController {

	@Autowired  
    EmpDao dao;
	
	@RequestMapping(value="/viewemp/{pageid}")  
    public ModelAndView edit(@PathVariable int pageid){  
        int total=5;  
        if(pageid==1){}  
        else{  
            pageid=(pageid-1)*total+1;  
        }  
        List<Emp> list=dao.getEmployeesByPage(pageid,total);  
          
        return new ModelAndView("viewemp","list",list);  
    }  
	
}
