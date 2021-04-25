package com.employee.Employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.Employee.Dao.PermissionRepository;
import com.employee.Employee.entity.Permission;

@Service
public class PermissionService {

	@Autowired
	private PermissionRepository premissionRepository;
	
	public Permission addPermission(Permission newPermission) {
		return premissionRepository.save(newPermission);
	}
	
	public List<Permission> getPermissions() {
		return premissionRepository.findAll();
	}
	
	public Permission getPermissionById(long id) {
		return premissionRepository.findById(id).get();
	}
	
	public Permission updatePermission(long id, Permission permission) {
		Optional<Permission> permissionOpt = premissionRepository.findById(id);
		Permission permissionInDb = null;
		if(permissionOpt.isPresent()) {
			permissionInDb = permissionOpt.get();
			permissionInDb.setAction(permission.getAction());
			permissionInDb.setActive(permission.isActive());
			return premissionRepository.save(permissionInDb);
		}
		return permissionInDb;

		
	}
	public void deleteById(long id)	{
		premissionRepository.deleteById(id);
	}
	

}
