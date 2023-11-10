package org.example.exchange.match;

import java.math.BigDecimal;


/*
* immutable class
* */
public record OrderKey(long sequenceId, BigDecimal price) {
}