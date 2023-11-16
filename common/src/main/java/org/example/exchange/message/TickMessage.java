package org.example.exchange.message;


import org.example.exchange.model.quotation.TickEntity;

import java.util.List;

public class TickMessage extends AbstractMessage {

    public long sequenceId;

    public List<TickEntity> ticks;

}
