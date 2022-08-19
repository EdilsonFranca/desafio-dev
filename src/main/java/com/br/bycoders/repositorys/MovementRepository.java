package com.br.bycoders.repositorys;

import com.br.bycoders.models.Movement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovementRepository extends JpaRepository<Movement, Long> {
    @Query("from Movement p where p.store LIKE :name")
    List<Movement> findByStore(String name);
}