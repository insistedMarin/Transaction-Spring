package org.example.exchange.support;

import org.example.exchange.db.DbTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Service with db support.
 */
public abstract class AbstractDbService extends LoggerSupport {

    @Autowired
    protected DbTemplate db;
}