package com.employee.Employee.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.Employee.entity.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long>{

}
