package com.example.telegrambotshelter.handlerMain.handler.callbackQuery;

import com.example.telegrambotshelter.handlerMain.BotState;
import com.example.telegrambotshelter.handlerMain.handler.InputHandlerQuery;
import com.example.telegrambotshelter.service.DogsShelterMenuQueryService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Component
public class DogsShelterMenuQuery implements InputHandlerQuery {

    private final DogsShelterMenuQueryService dogsShelterMenuQueryService;

    public DogsShelterMenuQuery(DogsShelterMenuQueryService dogsShelterMenuQueryService) {
        this.dogsShelterMenuQueryService = dogsShelterMenuQueryService;
    }

    @Override
    public SendMessage handle(long chatId) {
        return dogsShelterMenuQueryService.getDogsShelterMenuQuery(chatId);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.SHOW_DOG_SHELTER_MENU;
    }
}
