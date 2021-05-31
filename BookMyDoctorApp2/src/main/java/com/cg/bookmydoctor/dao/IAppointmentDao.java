package com.cg.bookmydoctor.dao;


import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.bookmydoctor.dto.Appointment;


public interface IAppointmentDao extends JpaRepository<Appointment, Integer>  {
	
	List<Appointment> findAllByAppointmentDate(LocalDate date);
	
}
