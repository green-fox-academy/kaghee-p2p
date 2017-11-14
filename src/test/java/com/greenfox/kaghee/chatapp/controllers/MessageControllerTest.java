package com.greenfox.kaghee.chatapp.controllers;

import com.greenfox.kaghee.chatapp.ChatappApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


import java.nio.charset.Charset;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ChatappApplication.class)
@WebAppConfiguration
@EnableWebMvc
public class MessageControllerTest {

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void test() throws Exception {
        mockMvc.perform(post("/api/message/receive")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"message\": {\n" +
                        "    \"id\": 7655482,\n" +
                        "    \"username\": \"EggDice\",\n" +
                        "    \"text\": \"How you doin'?\",\n" +
                        "    \"timestamp\": 1322018752992\n" +
                        "  },\n" +
                        "  \"client\": {\n" +
                        "    \"id\": \"EggDice\"\n" +
                        "  }\n" +
                        "}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.status", is("ok")));
    }

//    @Test
//    public void testSuccessfulDountilSum() throws Exception {
//        mockMvc.perform(post("/dountil/sum")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("{\"until\": 15}"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(contentType))
//                .andExpect(jsonPath("$.result", is(120)));
//    }

}