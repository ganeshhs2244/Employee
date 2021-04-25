package com.employee.Employee.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.Employee.entity.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {

}
