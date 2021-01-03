package com.premierleague.backend;

import com.premierleague.backend.controllers.Controller;
import com.premierleague.backend.models.Date;
import com.premierleague.backend.models.FootballClub;
import com.premierleague.backend.models.Match;
import com.premierleague.backend.operations.Operation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(value = Controller.class)
public class TestGenerateMatch {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Operation operations;

    Match match = new Match();

    @Test
    public void generateMatch() throws Exception{
        Mockito.when(operations.generateMatch()).thenReturn(match);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/generateMatch").accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());

        String expected = "200";
        JSONAssert.assertEquals(expected, String.valueOf(result.getResponse().getStatus()), false);
        JSONAssert.assertEquals("{date:{ }, team_1:{}, team_2:{} }", result.getResponse().getContentAsString(), false);
    }
}
