package com.srini.protobuf.controller;

import com.srini.protobuf.model.Stocks;
import com.srini.protobuf.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * The type Stocks controller.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/stocks")
public class StocksController {

    private final StockRepository stockRepository ;


    /**
     * Get all iterable.
     *
     * @return the iterable
     */
    @GetMapping("all")
    public Iterable<Stocks> getAll(){
        return stockRepository.findAll();
    }

    /**
     * Get optional.
     *
     * @param id the id
     * @return the optional
     */
    @GetMapping("get")
    public Optional<Stocks> get(@RequestParam Integer id){
        return stockRepository.findById(id) ;
    }

    /**
     * Delete all response entity.
     *
     * @return the response entity
     */
    @DeleteMapping("deleteAll")
    public ResponseEntity<HttpStatus> deleteAll(){
        stockRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK) ;
    }
}
