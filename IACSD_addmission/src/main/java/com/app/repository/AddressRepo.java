package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Address;
import com.app.entities.Course;
import com.app.entities.CourseEnum;

@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {
}
