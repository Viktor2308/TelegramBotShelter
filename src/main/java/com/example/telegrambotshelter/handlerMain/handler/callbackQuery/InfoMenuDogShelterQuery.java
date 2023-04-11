package com.example.telegrambotshelter.handlerMain.handler.callbackQuery;

import com.example.telegrambotshelter.handlerMain.BotState;
import com.example.telegrambotshelter.handlerMain.handler.InputHandlerQuery;
import com.example.telegrambotshelter.service.dogShelter.InfoMenuDogShelterQueryService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.List;

@Component
public class InfoMenuDogShelterQuery implements InputHandlerQuery {

    private final InfoMenuDogShelterQueryService infoDogShelterQueryService;

    public InfoMenuDogShelterQuery(InfoMenuDogShelterQueryService infoDogShelterQueryService) {
        this.infoDogShelterQueryService = infoDogShelterQueryService;
    }

    @Override
    public List<PartialBotApiMethod<Message>> handle(long chatId) {
        return infoDogShelterQueryService.getInfoDogShelter(chatId);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.INFO_MENU_DOG_SHELTER;
    }
}
