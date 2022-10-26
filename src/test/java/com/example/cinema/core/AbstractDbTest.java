package com.example.cinema.core;

import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@Transactional
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE,
        properties = {"spring.jpa.properties.hibernate.hbm2ddl.auto=create-drop",
                "spring.jpa.properties.hibernate.hbm2ddl.import_files=test-data.sql"})
public abstract class AbstractDbTest extends AbstractTest {
}
