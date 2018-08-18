package com.marketMakers.repository;

import com.marketMakers.model.Nota;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaRepository extends CrudRepository<Nota, Long> {
}