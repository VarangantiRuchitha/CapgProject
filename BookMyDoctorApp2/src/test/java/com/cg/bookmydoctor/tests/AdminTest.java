package com.cg.bookmydoctor.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cg.bookmydoctor.dto.Admin;
import com.cg.bookmydoctor.dao.IAdminDao;
import com.cg.bookmydoctor.exception.AdminException;
import com.cg.bookmydoctor.exception.ValidateAdminException;
import com.cg.bookmydoctor.serviceimpl.AdminServiceImpl;


public class AdminTest extends BookMyDoctorAppApplicationTests {
	@Autowired
	private AdminServiceImpl adminservice;
	
	@Autowired
	private IAdminDao adminDao;
	
	@Before
	public void setUp() {
		adminservice = new AdminServiceImpl();
		List<Admin> adminList  = new ArrayList<Admin>();
		Admin admin = new Admin(1,"A Shivani","9876576879","shivani@gmail.com","shivani20");

		Admin admin2 = new Admin(2,"K Sai priya","9843576879","saipriya@gmail.com","saipriya20");
		adminList.add(admin);
		adminList.add(admin2);
		
	}

	@Test
	void testAdminServiceImpl() {
		assertTrue(adminservice instanceof AdminServiceImpl);
	}


	@Test
	void testAddAdmin() throws AdminException, ValidateAdminException {
		Admin admin = new Admin(1,"A Shivani","9876576879","shivani@gmail.com","shivani20");
		admin = adminservice.addAdmin(admin);
		assertEquals(admin.getAdminName(), "A Shivani");
		
		Admin admin2 = new Admin(2,"K Sai priya","9843576879","saipriya@gmail.com","saipriya20");
		admin2 = adminservice.addAdmin(admin2);
		assertEquals(admin2.getAdminName(), "K Sai Priya");
	}
	@Test
	void testUpdateAdmin() throws AdminException  {
		Admin admin = new Admin(1,"A Shivani","9876543210","shivani@gmail.com","shivani20");
		admin = adminservice.updateAdmin(admin);
		assertEquals(admin.getContactNumber(), "9876543210");
	}
	
	@Test
	void testRemoveAdmin() throws AdminException {
		Admin admin = adminDao.findById(2).get();
		Admin deletedAdmin = adminservice.removeAdmin(admin);
		assertEquals(deletedAdmin, admin);
	}
	
	@Test
	void testViewAdmin() throws AdminException {
		Admin admin = new Admin(1,"A Shivani","9876543210","shivani@gmail.com","shivani20");
		
		Admin adminGet = adminservice.viewAdmin(admin);
		assertNotNull(adminGet);
	}
		
	@After
	public void setDown() {
		adminservice = null;
	}	
}
