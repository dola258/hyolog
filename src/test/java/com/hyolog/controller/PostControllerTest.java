package com.hyolog.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    @DisplayName("/posts 요청 시 Hello World를 출력한다.")
    void test() throws Exception {

        // expected
        mockMvc.perform(post("/posts") // application/json
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\": \"제목입니다\", \"content\": \"내용입니다\"}")
                )
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World")) // "Hello World2"라고 하면 PostController.java랑 다르기 때문에 오류 발생
                .andDo(print());
    }
}