package com.example.telegrambotshelter.handlerMain.handler.callbackQuery;

import com.example.telegrambotshelter.handlerMain.BotState;
import com.example.telegrambotshelter.handlerMain.handler.InputHandlerQuery;
import com.example.telegrambotshelter.service.catShelter.MainMenuCatsShelterQueryService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.List;

@Component
public class MainMenuCatsShelterQuery implements InputHandlerQuery {

    private final MainMenuCatsShelterQueryService catsShelterMenuQueryService;

    public MainMenuCatsShelterQuery(MainMenuCatsShelterQueryService catsShelterMenuQueryService) {
        this.catsShelterMenuQueryService = catsShelterMenuQueryService;
    }

    @Override
    public List<PartialBotApiMethod<Message>> handle(long chatId) {
        return catsShelterMenuQueryService.getCatsShelterMenuQuery(chatId);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.SHOW_CAT_SHELTER_MENU;
    }
}
