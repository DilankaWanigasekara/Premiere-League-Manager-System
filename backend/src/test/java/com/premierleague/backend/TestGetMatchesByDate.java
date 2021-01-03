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
public class TestGetMatchesByDate {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Operation operations;

    List<Match> matchList = new ArrayList<>();

    @Test
    public void getMatchesByDate() throws Exception{

        Date date = new Date(10, 11, 2020);

        Mockito.when(operations.getPlayedMatches(date)).thenReturn(matchList);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getMatches/" + date.getDay() + "-" + date.getMonth() + "-" + date.getYear()).accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());
        result.getResponse().getStatus();

        String expected = "200";
        JSONAssert.assertEquals(expected, String.valueOf(result.getResponse().getStatus()), false);
    }
}
