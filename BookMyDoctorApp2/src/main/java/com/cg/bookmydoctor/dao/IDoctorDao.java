package com.cg.bookmydoctor.dao;

import java.util.Optional;
import com.cg.bookmydoctor.dto.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IDoctorDao  extends CrudRepository<Doctor,Integer >
{
	Optional<Doctor> findBySpeciality(String speciality);

}