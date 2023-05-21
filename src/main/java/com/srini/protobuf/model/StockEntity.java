package com.srini.protobuf.model;

import org.springframework.data.annotation.Id;

public record StockEntity(@Id String name, Integer isin, Integer volume) {
}
