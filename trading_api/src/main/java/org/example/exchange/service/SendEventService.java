package org.example.exchange.service;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.example.exchange.message.event.AbstractEvent;
import org.example.exchange.messaging.MessageProducer;
import org.example.exchange.messaging.Messaging;
import org.example.exchange.messaging.MessagingFactory;

@Component
public class SendEventService {

    @Autowired
    private MessagingFactory messagingFactory;

    private MessageProducer<AbstractEvent> messageProducer;

    @PostConstruct
    public void init() {
        this.messageProducer = messagingFactory.createMessageProducer(Messaging.Topic.SEQUENCE, AbstractEvent.class);
    }

    public void sendMessage(AbstractEvent message) {
        this.messageProducer.sendMessage(message);
    }
}