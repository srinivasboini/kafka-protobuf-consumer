package com.srini.protobuf.repository;

import com.srini.protobuf.model.Stocks;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends CrudRepository<Stocks, Integer> {
}
