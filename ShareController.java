package com.gl.globalExchange.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gl.globalExchange.bean.CompanyShare;
import com.gl.globalExchange.service.CompanyShareService;

@RestController
public class ShareController {
		@Autowired
		private CompanyShareService service;
		
		@GetMapping("index")
		public ModelAndView showIndexPage()	
		{
			ModelAndView mv=new ModelAndView("index");
			List<CompanyShare> companyList=service.findAll();
			mv.addObject("companyList",companyList);
			return mv;
		}
		@GetMapping("company-entry")
		public ModelAndView showCompnayEntryPage()
		{
			CompanyShare company=new CompanyShare();
			ModelAndView mv= new ModelAndView("companyEntryPage");
			mv.addObject("companyRecord",company);
			return mv;
		}
		
		@PostMapping("/company")
		public ModelAndView saveNewCompany(@ModelAttribute("companyRecord") CompanyShare company)  {
			Long id=service.generateCompanyId();
			company.setCompanyId(id);
			service.save(company);
			return new ModelAndView("redirect:/index");
		}
		
		@GetMapping("/delete-company/{id}")
		public ModelAndView DeleteCompany(@PathVariable Long id)  {
			service.delete(id);
			return new ModelAndView("redirect:/index");
		}
		@GetMapping("/company-edit/{id}")
		public ModelAndView showCompanyEditPage(@PathVariable Long id)  {
			CompanyShare company=service.findById(id);
			ModelAndView mv= new ModelAndView("companyEditPage");
			mv.addObject("companyRecord",company);
			return mv;
		}
		@PostMapping("/company-edit/company-edit")
		public ModelAndView editCompany(@ModelAttribute("companyRecord") CompanyShare company)  {
			service.save(company);
			return new ModelAndView("redirect:/index");
		}
}
