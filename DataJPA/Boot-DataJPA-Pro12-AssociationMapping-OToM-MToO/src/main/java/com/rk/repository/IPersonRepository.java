package com.rk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rk.entity.Person;

public interface IPersonRepository extends JpaRepository<Person, Integer> {

}
