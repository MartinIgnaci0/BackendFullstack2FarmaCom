package com.farmacom.backendFullstack.repository;

import com.farmacom.backendFullstack.model.Boleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoletaRepository extends JpaRepository<Boleta, Long> {

}
