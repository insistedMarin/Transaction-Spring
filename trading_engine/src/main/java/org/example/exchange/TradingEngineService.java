package org.example.exchange;

import org.example.exchange.assets.AssetService;
import org.example.exchange.clearing.ClearingService;
import org.example.exchange.match.MatchEngine;
import org.example.exchange.order.OrderService;
import org.example.exchange.support.LoggerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TradingEngineService extends LoggerSupport {
    @Autowired
    AssetService assetService;
    @Autowired
    OrderService orderService;

    @Autowired
    MatchEngine matchEngine;

    @Autowired
    ClearingService clearingService;

}
