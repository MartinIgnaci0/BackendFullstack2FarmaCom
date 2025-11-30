package com.farmacom.backendFullstack.repository;

import com.farmacom.backendFullstack.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepositoty extends JpaRepository<Categoria, Long> {

}
