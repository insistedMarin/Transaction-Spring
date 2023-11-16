package org.example.exchange.model.quotation;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import org.example.exchange.model.support.AbstractBarEntity;

/**
 * Store bars of second.
 */
@Entity
@Table(name = "sec_bars")
public class SecBarEntity extends AbstractBarEntity {

}