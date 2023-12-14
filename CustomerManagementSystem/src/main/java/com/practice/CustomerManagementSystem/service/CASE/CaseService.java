package com.practice.CustomerManagementSystem.service.CASE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.CustomerManagementSystem.entity.Case;
import com.practice.CustomerManagementSystem.mapper.CaseMapper;

@Service
public class CaseService{
	@Autowired
	CaseMapper caseMapper;
	
	public List<Case> getCases(Long customerId){
		return caseMapper.findByCustomerId(customerId);
	}
	
	public Case getCase(Long caseId) {
		return caseMapper.findByCaseId(caseId);
	}
	
}