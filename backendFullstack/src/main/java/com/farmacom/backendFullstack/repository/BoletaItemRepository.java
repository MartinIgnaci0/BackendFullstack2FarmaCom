package com.farmacom.backendFullstack.repository;

import com.farmacom.backendFullstack.model.BoletaItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoletaItemRepository extends JpaRepository<BoletaItem, Long> {

}
