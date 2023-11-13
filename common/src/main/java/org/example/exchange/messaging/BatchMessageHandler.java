package org.example.exchange.messaging;

import org.example.exchange.message.AbstractMessage;

import java.util.List;


@FunctionalInterface
public interface BatchMessageHandler<T extends AbstractMessage> {

    void processMessages(List<T> messages);

}