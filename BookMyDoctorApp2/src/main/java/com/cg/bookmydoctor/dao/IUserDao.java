package com.cg.bookmydoctor.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.bookmydoctor.dto.User;


@Repository
public interface IUserDao extends JpaRepository<User, Integer>{

}
