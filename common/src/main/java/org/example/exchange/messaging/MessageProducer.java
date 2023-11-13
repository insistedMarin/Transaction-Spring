package org.example.exchange.messaging;

import java.util.List;

import org.example.exchange.message.AbstractMessage;

// 实现类必须是abscractmessage的子类,函数式接口只能含有一个抽象方法
@FunctionalInterface
public interface MessageProducer<T extends AbstractMessage> {

    void sendMessage(T message);

    default void sendMessages(List<T> messages) {
        for (T message : messages) {
            sendMessage(message);
        }
    }
}