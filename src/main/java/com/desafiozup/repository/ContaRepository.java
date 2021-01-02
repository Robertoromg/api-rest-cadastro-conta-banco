package com.desafiozup.repository;


import org.springframework.data.jpa.repository.JpaRepository;


import com.desafiozup.models.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {
	Conta findById(long id);
	
}
