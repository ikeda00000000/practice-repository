package com.practice.CustomerManagementSystem.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.practice.CustomerManagementSystem.entity.Case;

@Mapper
public interface CaseMapper {
 
    // customerIdに一致するものを取得
	List<Case> findByCustomerId(Long customerId);
	
	// caseIdに一致するものを取得
	Case findByCaseId(Long caseId);
    
}
