package org.karenapp.repository;

import org.karenapp.model.Idol;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface IdolRepository extends JpaRepository<Idol, Long> {

// Al extender JpaRepository, ya tenemos métodos como save(), findAll(), findById(), deleteById()

}

