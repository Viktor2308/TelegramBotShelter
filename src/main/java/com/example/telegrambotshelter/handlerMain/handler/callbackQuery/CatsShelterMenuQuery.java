package com.example.telegrambotshelter.handlerMain.handler.callbackQuery;

import com.example.telegrambotshelter.handlerMain.BotState;
import com.example.telegrambotshelter.handlerMain.handler.InputHandlerQuery;
import com.example.telegrambotshelter.service.CatsShelterMenuQueryService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Component
public class CatsShelterMenuQuery implements InputHandlerQuery {

    private final CatsShelterMenuQueryService catsShelterMenuQueryService;

    public CatsShelterMenuQuery(CatsShelterMenuQueryService catsShelterMenuQueryService) {
        this.catsShelterMenuQueryService = catsShelterMenuQueryService;
    }

    @Override
    public SendMessage handle(long chatId) {
        return catsShelterMenuQueryService.getCatsShelterMenuQuery(chatId);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.SHOW_CAT_SHELTER_MENU;
    }
}
