package com.abnamro.repository;

import java.util.List;

import com.abnamro.assessment.entity.PersonEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

    List<PersonEntity> findByName(String name);
    List<PersonEntity> findAll();
}
