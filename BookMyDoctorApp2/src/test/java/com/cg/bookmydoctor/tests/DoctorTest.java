package com.cg.bookmydoctor.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;


import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cg.bookmydoctor.dao.IDoctorDao;
import com.cg.bookmydoctor.dto.Doctor;
import com.cg.bookmydoctor.exception.DoctorException;
import com.cg.bookmydoctor.exception.ValidateDoctorException;
import com.cg.bookmydoctor.serviceimpl.DoctorServiceImpl;

public class DoctorTest extends BookMyDoctorAppApplicationTests {
	
	@Autowired
	private DoctorServiceImpl docService;
	
	@Autowired
	private IDoctorDao docDao;
	
	@Before
	public void setUp() {
		docService = new DoctorServiceImpl();
		List<Doctor> docList  = new ArrayList<Doctor>();
		Doctor doctor = new Doctor(1,"K Priya", "Dental","Mumbai", "Mumbai Hospital","8787778866", "priyaeee@gmail.com","Joshi!123", 800);

		Doctor doctor2 = new Doctor(2,"M Harhsitha", "ENT", "Agra Delhi", "Sunshine Hospital", "9000878787","harshitha@gmail.com", "Crafty21!", 800);
		docList.add(doctor);
		docList.add(doctor2);
	}
	
	@Test
	void testdoctorServiceImpl() {
		assertTrue(docService instanceof DoctorServiceImpl);
	}
	@Test
	void testAddDoctor() throws DoctorException, ValidateDoctorException {
		Doctor doctor = new Doctor(1,"K Priya", "Dental","Mumbai", "Mumbai Hospital","8787778866", "priyaeee@gmail.com","Priya@1234", 800);
		assertNotNull(docService.addDoctor(doctor));
		
		Doctor doctor2 = new Doctor(2,"M Harhsitha", "ENT", "Agra Delhi", "Sunshine Hospital", "9000878787","harshitha@gmail.com", "Crafty21@", 800);
		assertNotNull(docService.addDoctor(doctor2));
	}
		
	@Test
	void testEditDoctor() throws DoctorException  {
		Doctor doctor = new Doctor(1,"K Priya", "Dental","Mumbai", "Shivaji Hospital","8787778866", "priyaeee@gmail.com","Joshi@123", 800);
		doctor = docService.updateDoctorProfile(doctor);
		assertEquals(doctor.getHospitalName(), "Shivaji Hospital");
	}
	
	@Test
	void testRemovedoctor() throws DoctorException {
		Doctor doctor = docDao.findById(2).get();
		Doctor deletedDoctor = docService.removeDoctor(doctor);
		assertEquals(deletedDoctor, doctor);
	}
	
	@Test
	void testGetDoctor() throws DoctorException {
		Doctor doctor = new Doctor(1,"K Priya", "Dental","Mumbai", "Shivaji Hospital","8787778866", "priyaeee@gmail.com","Joshi@123", 800);
		Doctor doctorGetter = docService.getDoctor(doctor);
		assertNotNull(doctorGetter);
	}
	
	@Test 
	void testGetDoctorList() {
		List<Doctor> docList = docService.getDoctorList();
		assertNotNull(docList);
	}
	
	
	@After
	public void setDown() {
		docService = null;
	}
}

