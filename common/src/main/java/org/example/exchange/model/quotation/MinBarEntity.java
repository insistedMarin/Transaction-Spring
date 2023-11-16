package org.example.exchange.model.quotation;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.example.exchange.model.support.AbstractBarEntity;

/**
 * Store bars of minute.
 */
@Entity
@Table(name = "min_bars")
public class MinBarEntity extends AbstractBarEntity {

}