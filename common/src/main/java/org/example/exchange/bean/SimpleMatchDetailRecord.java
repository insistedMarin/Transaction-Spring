package org.example.exchange.bean;

import java.math.BigDecimal;
import org.example.exchange.enums.MatchType;
public record SimpleMatchDetailRecord(BigDecimal price, BigDecimal quantity, MatchType type) {
}