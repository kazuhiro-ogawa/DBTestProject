package com.dbtest.db.model.service;

import java.sql.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dbtest.db.model.entity.EmployeeInfo;
import com.dbtest.db.model.repository.EmployeeInfoCrudRepository;

@Service
@Transactional
public class EmployeeInfoServiceImpl implements EmployeeInfoService {
	/** Repository：注入 */
	@Autowired
	EmployeeInfoCrudRepository repository;

	@Override
	public void insertEmployeeInfo(EmployeeInfo empinfo) {
		repository.save(empinfo);
	}

	@Override
	public Iterable<EmployeeInfo> selectAll() {
		return repository.findAll();
	}

	@Override
	public Optional<EmployeeInfo> findById(Integer code){
		return repository.findById(code);

	}

	@Override
	public void deleteById(Integer code) {
		repository.deleteById(code);
	}

	@Override
	public boolean existsById(Integer code) {
		boolean result = repository.existsById(code);
		return result;
	}

	@Override
	public Iterable<EmployeeInfo> findByJoinDateAndDepartment(Date joinDate, String department){
		return repository.findByJoinDateAndDepartment(joinDate, department);
	}

	@Override
	public Iterable<EmployeeInfo> findByParams(String name, String department, Integer working_days){
		return repository.findByParams(name, department, working_days);
	}



}
