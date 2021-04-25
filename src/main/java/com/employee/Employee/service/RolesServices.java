package com.employee.Employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employee.Employee.Dao.RolesRepository;
import com.employee.Employee.entity.Roles;

@Service
public class RolesServices {

	@Autowired
	private RolesRepository rolesRepository;
	
	
	public Roles addRole(Roles newRole) {
		return rolesRepository.save(newRole);		
	}
	

	public List<Roles> getRoles() {
		return rolesRepository.findAll();
	}
	

	public Roles getRoleById(long id) {
		Optional<Roles> roleOpt = rolesRepository.findById(id);
		if(roleOpt.isPresent()) {
			return roleOpt.get();
		}
		return null;
		
	}
	

	public Roles updateRole(long id, Roles role) {
		Optional<Roles> roleOpt = rolesRepository.findById(id);
		Roles roleInDb = null;
		if(roleOpt.isPresent()) {
			roleInDb = roleOpt.get();
			roleInDb.setName(role.getName());
			roleInDb.setTitle(role.getTitle());
			roleInDb.setPermission(role.getPermission());
			roleInDb.setDescription(role.getDescription());
			return rolesRepository.save(roleInDb);
		}
		return roleInDb;	
	}
	
	public void deleteById(long id)	{
		rolesRepository.deleteById(id);
	}
	

}
