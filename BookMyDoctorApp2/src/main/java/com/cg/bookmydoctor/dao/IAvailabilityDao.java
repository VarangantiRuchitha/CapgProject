package com.cg.bookmydoctor.dao;

import org.springframework.data.repository.CrudRepository;

import com.cg.bookmydoctor.dto.AvailabilityDates;

public interface IAvailabilityDao extends CrudRepository<AvailabilityDates,Integer>{

}
