package com.cg.bookmydoctor.dao;

import com.cg.bookmydoctor.dto.Admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IAdminDao extends JpaRepository<Admin, Integer> {
	
}