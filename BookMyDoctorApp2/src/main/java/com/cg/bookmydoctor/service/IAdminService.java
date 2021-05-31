package com.cg.bookmydoctor.service;


import com.cg.bookmydoctor.dto.Admin;
import com.cg.bookmydoctor.exception.AdminException;
import com.cg.bookmydoctor.exception.ValidateAdminException;

public interface IAdminService {

	
	public Admin addAdmin(Admin admin) throws AdminException, ValidateAdminException;
	public Admin updateAdmin(Admin admin) throws AdminException;
	public Admin removeAdmin(Admin admin)throws AdminException;
	public Admin viewAdmin(Admin admin)throws AdminException;
	
}