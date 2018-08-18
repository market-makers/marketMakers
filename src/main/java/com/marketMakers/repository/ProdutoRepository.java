package com.marketMakers.repository;

import com.marketMakers.model.Nota;
import com.marketMakers.model.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {
}