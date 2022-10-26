package com.example.cinema.core;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE,
        properties = {
                "spring.jpa.properties.hibernate.hbm2ddl.auto=none",
                "spring.jpa.properties.hibernate.hbm2ddl.import_files="
        })
@Suite
@SelectPackages("com.cinema.unit")
public abstract class AbstractUnitTest extends AbstractTest {
}
