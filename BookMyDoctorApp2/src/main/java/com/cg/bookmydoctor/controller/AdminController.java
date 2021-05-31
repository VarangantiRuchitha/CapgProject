package com.cg.bookmydoctor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.bookmydoctor.dto.Admin;
import com.cg.bookmydoctor.exception.AdminException;
import com.cg.bookmydoctor.exception.ValidateAdminException;
import com.cg.bookmydoctor.serviceimpl.AdminServiceImpl;


/**
 * @author Harshitha 
 *         REST Controller with different HTTP methods 
 *         as GET,POST,DELETE and their respective URL mappings class level
 *         request mapping as "admin"
 *         
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminServiceImpl adminservice ;
	
	//working
   	@GetMapping("/viewadmin/{adminId}")
	public Admin viewAdmin(@PathVariable("adminId") final Admin admin) throws AdminException {
		return adminservice.viewAdmin(admin);
	}

    //working
	@PostMapping("/addadmin")
	public Admin addAdmin(@RequestBody final Admin admin) throws AdminException,ValidateAdminException {
		return adminservice.addAdmin(admin);
	}

	//working
	@PutMapping("/updateadmin")
	public Admin updateAdmin(@RequestBody final Admin admin) throws AdminException {
		return adminservice.updateAdmin(admin);
	}

	//working
	@DeleteMapping("/removeadmin")
	public Admin removeAdmin(@RequestBody final Admin admin) throws AdminException {
		return adminservice.removeAdmin(admin);
	}
}