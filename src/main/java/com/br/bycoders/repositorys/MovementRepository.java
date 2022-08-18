package com.br.bycoders.repositorys;

import com.br.bycoders.models.Movement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovementRepository extends JpaRepository<Movement, Long> {}