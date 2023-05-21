package com.srini.protobuf.repository;

import com.srini.protobuf.model.StockEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends ListCrudRepository<StockEntity, String> {
}
