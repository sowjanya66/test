package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

import antlr.collections.List;

@Repository
public interface UserRpository extends JpaRepository<User, Integer>  {
//	 @Query("SELECT p FROM User p WHERE LOWER(p.email) = LOWER(:email) AND LOWER(p.password) = LOWER(:password)  ")
//	    public List <User> getuserbyemail(@Param("email") String email, @Param("password") String password);
//	 
	User findByEmailAndPassword(String email, String password);

}
