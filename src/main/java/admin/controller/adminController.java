package admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import admin.Dao.StudentDto;
import admin.Dao.TeacherDto;
import admin.service.StudentService;
import admin.service.TeacherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class adminController {
	
	public adminController() {
		System.out.println("생성자");
	}
	
	@Autowired
	StudentService studentService;
	@Autowired
	TeacherService teacherService;
	
	//첫 관리자 페이지
	@RequestMapping(value = "admin.do", method = RequestMethod.GET)
	public String administartor()
	{
		return "admin/adminform";
	}
	
	//회원 관리
	@RequestMapping(value = "userManager.do", method = RequestMethod.GET)
	public String UserManager()
	{
		return "admin/UserManagerform";
	}
	
	//학생 리스트
	@RequestMapping(value = "studentList.do", method = RequestMethod.GET)
	public String StudentList(Model sModel)
	{
		List<StudentDto> list = studentService.StudentList();
		sModel.addAttribute("list", list);
		return "admin/StudentList";
	}
	
	@RequestMapping(value = "teacherList.do", method = RequestMethod.GET)
	public String TeacherList(Model tModel)
	{
		List<TeacherDto> list = teacherService.TeacherList();
		tModel.addAttribute("list", list);
		return "admin/TeacherList";
	}
	
	@RequestMapping(value = "StudentExport.do", method = RequestMethod.GET)
	 public ModelAndView StudentExcelDownloader(){
		  
		  List<StudentDto> list = studentService.StudentList();
		  
		  return new ModelAndView("StudentExcel","pageRanks",list);
	  }
	
	@RequestMapping(value = "TeacherExport.do", method = RequestMethod.GET)
	 public ModelAndView TeacherExcelDownloader(){
		  
		  List<TeacherDto> list = teacherService.TeacherList();
		  
		  return new ModelAndView("TeacherExcel","pageRanks",list);
	  }
	@RequestMapping(value = "StudentDelete.do", method = RequestMethod.GET)
	public String StudentDelete(int s_num)
	{
		studentService.Delete(s_num);
		return "redirect:studentList.do";
	}
	
	@RequestMapping(value = "TeacherDelete.do", method = RequestMethod.GET)
	public String TeacherDelete(int t_num)
	{
		teacherService.Delete(t_num);
		return "redirect:teacherList.do";
	}
		
}
