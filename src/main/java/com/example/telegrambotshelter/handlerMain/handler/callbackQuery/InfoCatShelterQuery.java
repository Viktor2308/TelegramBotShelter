package com.example.telegrambotshelter.handlerMain.handler.callbackQuery;

import com.example.telegrambotshelter.handlerMain.BotState;
import com.example.telegrambotshelter.handlerMain.handler.InputHandlerQuery;
import com.example.telegrambotshelter.service.catShelter.InfoCatShelterQueryService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.List;

@Component
public class InfoCatShelterQuery implements InputHandlerQuery {

    private final InfoCatShelterQueryService infoCatShelterQueryService;

    public InfoCatShelterQuery(InfoCatShelterQueryService infoCatShelterQueryService) {
        this.infoCatShelterQueryService = infoCatShelterQueryService;
    }

    @Override
    public List<PartialBotApiMethod<Message>> handle(long chatId) {
        return infoCatShelterQueryService.getInfoCatShelter(chatId);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.INFO_CAT_SHELTER;
    }
}
