package org.example.exchange.quotation;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import org.example.exchange.model.quotation.DayBarEntity;
import org.example.exchange.model.quotation.HourBarEntity;
import org.example.exchange.model.quotation.MinBarEntity;
import org.example.exchange.model.quotation.SecBarEntity;
import org.example.exchange.model.quotation.TickEntity;
import org.example.exchange.support.AbstractDbService;

@Component
@Transactional
public class QuotationDbService extends AbstractDbService {

    public void saveBars(SecBarEntity sec, MinBarEntity min, HourBarEntity hour, DayBarEntity day) {
        if (sec != null) {
            this.db.insertIgnore(sec);
        }
        if (min != null) {
            this.db.insertIgnore(min);
        }
        if (hour != null) {
            this.db.insertIgnore(hour);
        }
        if (day != null) {
            this.db.insertIgnore(day);
        }
    }

    public void saveTicks(List<TickEntity> ticks) {
        this.db.insertIgnore(ticks);
    }
}