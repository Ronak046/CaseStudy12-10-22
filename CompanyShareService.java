package com.gl.globalExchange.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.globalExchange.CompanyShareRepository;
import com.gl.globalExchange.bean.CompanyShare;

@Service
public class CompanyShareService {

@Autowired
public CompanyShareRepository repository;
	public void save(CompanyShare company) {
		repository.save(company);
	}
	public List<CompanyShare> findAll(){
		return repository.findAll();
	}
	public CompanyShare findById(Long id){
		return repository.getById(id);
	}
	public void delete(Long id) {
		repository.deleteById(id);
	}
	public Long generateCompanyId() {
		Long val=repository.findMaxCompanyId();
		if(val==null)
			val=100001L;
		else
			val=val+1;
		
		return val;
}
}
