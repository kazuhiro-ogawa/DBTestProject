package com.dbtest.db.model.repository;

import java.sql.Date;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.dbtest.db.model.entity.EmployeeInfo;

public interface EmployeeInfoCrudRepository extends CrudRepository<EmployeeInfo, Integer>{

	Iterable<EmployeeInfo> findByJoinDateAndDepartment(Date joinDate, String department);
	@Query("SELECT * FROM Employee_Info WHERE (:name is null or name = :name) and (:department is null or department = :department) and (:working_days is null or working_days = :working_days)")
	Iterable<EmployeeInfo> findByParams(@Param("name") String name, @Param("department") String department, @Param("working_days") Integer working_days);


}
