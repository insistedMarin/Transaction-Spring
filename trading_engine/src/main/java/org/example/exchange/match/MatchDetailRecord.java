package org.example.exchange.match;

import java.math.BigDecimal;

import org.example.exchange.model.trade.OrderEntity;

public record MatchDetailRecord(BigDecimal price, BigDecimal quantity, OrderEntity takerOrder, OrderEntity makerOrder) {
}