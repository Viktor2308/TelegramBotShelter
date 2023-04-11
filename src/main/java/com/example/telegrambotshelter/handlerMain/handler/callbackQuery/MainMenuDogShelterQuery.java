package com.example.telegrambotshelter.handlerMain.handler.callbackQuery;

import com.example.telegrambotshelter.handlerMain.BotState;
import com.example.telegrambotshelter.handlerMain.handler.InputHandlerQuery;
import com.example.telegrambotshelter.service.dogShelter.MainMenuDogsShelterQueryService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.List;

@Component
public class MainMenuDogShelterQuery implements InputHandlerQuery {

    private final MainMenuDogsShelterQueryService dogsShelterMenuQueryService;

    public MainMenuDogShelterQuery(MainMenuDogsShelterQueryService dogsShelterMenuQueryService) {
        this.dogsShelterMenuQueryService = dogsShelterMenuQueryService;
    }

    @Override
    public List<PartialBotApiMethod<Message>> handle(long chatId) {
        return dogsShelterMenuQueryService.getDogsShelterMenuQuery(chatId);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.SHOW_DOG_SHELTER_MENU;
    }
}
