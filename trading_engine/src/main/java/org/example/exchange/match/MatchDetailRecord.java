package org.example.exchange.match;

import java.math.BigDecimal;

import org.example.exchange.model.trade.OrderEntity;
/*
* Taker 主动发起交易并立即成交
* Maker 提供挂单，等待成交
* */
public record MatchDetailRecord(BigDecimal price, BigDecimal quantity, OrderEntity takerOrder, OrderEntity makerOrder) {
}