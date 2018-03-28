package com.bratek.transit.controller;

import com.bratek.transit.model.Transit;
import com.bratek.transit.service.TransitService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class TransitControllerIT {

    private static final String TRANSIT_JSON = "{\n" +
            "  \"sourceAddress\" : \"ul. Zakręt 8, Poznań\",\n" +
            "  \"destinationAddress\": \"Złota 44, Warszawa\",\n" +
            "  \"price\": 450,\n" +
            "  \"date\": \"2018-03-15\"\n" +
            "}";
    @Autowired
    private WebApplicationContext context;

    @Autowired
    private TransitService transitService;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        transitService.save(new Transit(null, "Krk", "Wawa", 20.f, null));
    }

    @Test
    public void shouldReturnAllTransits() throws Exception {
        mockMvc.perform(get("/api/transit"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("totalElements", equalTo(1)))
                .andExpect(jsonPath("$.content[0].sourceAddress", equalTo("Krk")));
    }

    @Test
    public void shouldReturnStatusCreatedWhenBodyIsValid() throws Exception {
        mockMvc.perform(post("/api/transit")
                .contentType(MediaType.APPLICATION_JSON)
                .content(TRANSIT_JSON))
                .andExpect(status().isCreated());
    }
}