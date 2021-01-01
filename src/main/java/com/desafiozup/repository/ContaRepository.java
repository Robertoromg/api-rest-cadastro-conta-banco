package com.desafiozup.repository;


import org.springframework.data.repository.CrudRepository;

import com.desafiozup.models.Conta;

public interface ContaRepository extends CrudRepository<Conta, Long> {
	Conta findById(long id);
}
