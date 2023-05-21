package com.srini.protobuf.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

public record Stocks(@Id int id, String name, int isin, int volume) {
}
