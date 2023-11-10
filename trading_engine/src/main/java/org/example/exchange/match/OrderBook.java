package org.example.exchange.match;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;

import org.example.exchange.bean.OrderBookItemBean;
import org.example.exchange.enums.Direction;
import org.example.exchange.model.trade.OrderEntity;

import java.util.TreeMap;

public class OrderBook {

    public final Direction direction;
    public final TreeMap<OrderKey, OrderEntity> book;

    public OrderBook(Direction direction) {
        this.direction = direction;
        // red-black tree，使用红黑树针对不同的订单簿维持不同的顺序
        this.book = new TreeMap<>(direction == Direction.BUY ? SORT_BUY : SORT_SELL);
    }

    public OrderEntity getFirst() {
        return this.book.isEmpty() ? null : this.book.firstEntry().getValue();
    }

    public boolean remove(OrderEntity order) {
        return this.book.remove(new OrderKey(order.sequenceId, order.price)) != null;
    }

    public boolean add(OrderEntity order) {
        return this.book.put(new OrderKey(order.sequenceId, order.price), order) == null;
    }

    public boolean exist(OrderEntity order) {
        return this.book.containsKey(new OrderKey(order.sequenceId, order.price));
    }

    public int size() {
        return this.book.size();
    }
    /*
    * Generate a certain number of order snapshots
    * */
    public List<OrderBookItemBean> getOrderBook(int maxDepth) {
        List<OrderBookItemBean> items = new ArrayList<>(maxDepth);
        OrderBookItemBean prevItem = null;
        for (OrderKey key : this.book.keySet()) {
            OrderEntity order = this.book.get(key);
            if (prevItem == null) {
                prevItem = new OrderBookItemBean(order.price, order.unfilledQuantity);
                items.add(prevItem);
            } else {
                if (order.price.compareTo(prevItem.price) == 0) {
                    prevItem.addQuantity(order.unfilledQuantity);
                } else {
                    if (items.size() >= maxDepth) {
                        break;
                    }
                    prevItem = new OrderBookItemBean(order.price, order.unfilledQuantity);
                    items.add(prevItem);
                }
            }
        }
        return items;
    }

    @Override
    public String toString() {
        if (this.book.isEmpty()) {
            return "(empty)";
        }
        List<String> orders = new ArrayList<>(10);
        for (Entry<OrderKey, OrderEntity> entry : this.book.entrySet()) {
            OrderEntity order = entry.getValue();
            orders.add("  " + order.price + " " + order.unfilledQuantity + " " + order.toString());
        }
        if (direction == Direction.SELL) {
            Collections.reverse(orders);
        }
        return String.join("\n", orders);
    }

    private static final Comparator<OrderKey> SORT_SELL = new Comparator<>() {
        @Override
        public int compare(OrderKey o1, OrderKey o2) {
            // Sort by price in ascending order: 升序
            int cmp = o1.price().compareTo(o2.price());
            return cmp == 0 ? Long.compare(o1.sequenceId(), o2.sequenceId()) : cmp;
        }
    };

    private static final Comparator<OrderKey> SORT_BUY = new Comparator<>() {
        @Override
        public int compare(OrderKey o1, OrderKey o2) {
            // Sort by price in descending order: 降序
            int cmp = o2.price().compareTo(o1.price());
            return cmp == 0 ? Long.compare(o1.sequenceId(), o2.sequenceId()) : cmp;
        }
    };
}