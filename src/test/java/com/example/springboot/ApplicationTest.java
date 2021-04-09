package com.example.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@SpringBootTest
@AutoConfigureMockMvc
class ApplicationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void test_one() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/api?post_input_text=test_one")).andReturn();
        mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/delete?post_text=test_one")).andReturn();
        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/history").contentType(MediaType.ALL))
                .andExpect(content().string(not(containsString("test_one"))));
    }

    @Test
    void test_two() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/api?post_input_text=test_TWO")).andReturn();
        mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/delete?post_text=test_two")).andReturn();
        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/history").contentType(MediaType.ALL))
                .andExpect(content().string(not(containsString("test_TWO"))));
    }

}