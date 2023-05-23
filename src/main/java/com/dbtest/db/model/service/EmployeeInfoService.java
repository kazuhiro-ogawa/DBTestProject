package com.dbtest.db.model.service;

import java.sql.Date;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.query.Param;

import com.dbtest.db.model.entity.EmployeeInfo;


public interface EmployeeInfoService {
	void insertEmployeeInfo(EmployeeInfo empinfo);
	Iterable<EmployeeInfo> selectAll();
	Optional<EmployeeInfo> findById(Integer code);
	void deleteById(Integer code);
	boolean existsById(Integer code);
    @Query("SELECT e FROM EmployeeInfo e WHERE e.joinDate = :joinDate AND e.department = :department")
    Iterable<EmployeeInfo> findByJoinDateAndDepartment(@Param("joinDate") Date joinDate, @Param("department") String department);

    Iterable<EmployeeInfo> findByParams(String name, String department, Integer working_days);
}
