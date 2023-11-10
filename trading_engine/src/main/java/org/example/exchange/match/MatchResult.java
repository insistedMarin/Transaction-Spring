package org.example.exchange.match;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.example.exchange.model.trade.OrderEntity;

/*
* 记录某个TakerOrder匹配的MakerOrder结果，包括潜在成交价格，匹配数量，和Makerorder的实体
* */

public class MatchResult {

    public final OrderEntity takerOrder;
    public final List<MatchDetailRecord> matchDetails = new ArrayList<>();

    public MatchResult(OrderEntity takerOrder) {
        this.takerOrder = takerOrder;
    }

    public void add(BigDecimal price, BigDecimal matchedQuantity, OrderEntity makerOrder) {
        matchDetails.add(new MatchDetailRecord(price, matchedQuantity, this.takerOrder, makerOrder));
    }

    @Override
    public String toString() {
        if (matchDetails.isEmpty()) {
            return "no matched.";
        }
        return matchDetails.size() + " matched: "
                + String.join(", ", this.matchDetails.stream().map(MatchDetailRecord::toString).toArray(String[]::new));
    }
}