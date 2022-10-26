package com.example.cinema.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
        properties = {"spring.jpa.properties.hibernate.hbm2ddl.auto=create-drop",
                "spring.jpa.properties.hibernate.hbm2ddl.import_files=test-data.sql"})
@AutoConfigureWireMock(port = 0)
public abstract class AbstractApiTest {

    @Autowired
    protected MockMvc mockMvc;

    protected static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
}
