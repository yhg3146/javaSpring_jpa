package com.example.part3_practice.ch08.spring_calculator.controller;

import com.example.part3_practice.ch08.spring_calculator.component.Calculator;
import com.example.part3_practice.ch08.spring_calculator.component.DollarCalculator;
import com.example.part3_practice.ch08.spring_calculator.component.MarketApi;
import com.example.part3_practice.ch08.spring_calculator.dto.Req;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest
@AutoConfigureMockMvc
@Import({Calculator.class, DollarCalculator.class,MarketApi.class})
public class ApiControllerTest {

    @MockBean
    private  MarketApi marketApi;

    @BeforeEach
    private void init(){
        Mockito.lenient().when(marketApi.connect()).thenReturn(3000);
    }

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DollarCalculator dollarCalculator;
    @Test
    public void webMvcTest() throws Exception {
        dollarCalculator.init();
        mockMvc.perform(
                MockMvcRequestBuilders.get("http://localhost:8080/api/sum")
                        .queryParam("x","10")
                        .queryParam("y","10")

        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        ).andExpect(
                MockMvcResultMatchers.content().string("60000")
        ).andDo(
                MockMvcResultHandlers.print()
        );
    }

    @Test
    public void postTest() throws Exception {
        dollarCalculator.init();

        Req req = new Req();
        req.setX(10);
        req.setY(10);

        String json = new ObjectMapper().writeValueAsString(req);
        mockMvc.perform(
                MockMvcRequestBuilders.post("http://localhost:8080/api/minus")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.result").value("0")
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.response.resultCode").value("OK")
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        ).andDo(
                MockMvcResultHandlers.print()
        );
    }
}
