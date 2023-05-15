package com.example.telegrambotshelter.handlerMain.handler.inputCallbackQueryImpl;

import com.example.telegrambotshelter.handlerMain.BotState;
import com.example.telegrambotshelter.service.inputCallbackQueryServiceImpl.AddressDogShelterQueryService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@DisplayName("Test Handler Query - AddressDogShelterQuery")
@ExtendWith(MockitoExtension.class)
class AddressDogShelterQueryTest {
    @Mock
    private AddressDogShelterQueryService service;
    @InjectMocks
    private AddressDogShelterQuery query;
    long chatId = 123L;

    @DisplayName("JUnit test should return List<PartialBotApiMethod<Message>>")
    @Test
    void handle() {

        List<PartialBotApiMethod<Message>> expectedArrayList = new ArrayList<>();
        InputFile inputFile = new InputFile(
                new File("src/test/resources/TestImg.png"));
        expectedArrayList.add(new SendMessage(Long.toString(chatId), "Test"));
        expectedArrayList.add(new SendPhoto(Long.toString(chatId), inputFile));

        when(service.replayMessage(chatId)).thenReturn(expectedArrayList);

        List<PartialBotApiMethod<Message>> actualList = query.handle(chatId);

        assertEquals(actualList.size(), expectedArrayList.size());
        assertEquals(actualList.get(0).getClass(), expectedArrayList.get(0).getClass());
        assertEquals(actualList.get(1).getClass(), expectedArrayList.get(1).getClass());

    }

    private BotState botState = BotState.DOG_SHELTER_ADDRESS;

    @DisplayName("JUnit test should return bot state DOG_SHELTER_ADDRESS")
    @Test
    void getHandlerName() {
        assertEquals(query.getHandlerName(), botState);
    }
}