package com.example.telegrambotshelter.handlerMain.handler.inputCallbackQueryImpl;

import com.example.telegrambotshelter.handlerMain.BotState;
import com.example.telegrambotshelter.handlerMain.handler.InputHandlerQuery;
import com.example.telegrambotshelter.service.inputCallbackQueryServiceImpl.InfoMenuCatShelterQueryService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.List;

@Component
public class InfoMenuCatShelterQuery implements InputHandlerQuery {

    private final InfoMenuCatShelterQueryService infoCatShelterQueryService;

    public InfoMenuCatShelterQuery(InfoMenuCatShelterQueryService infoCatShelterQueryService) {
        this.infoCatShelterQueryService = infoCatShelterQueryService;
    }

    @Override
    public List<PartialBotApiMethod<Message>> handle(long chatId) {
        return infoCatShelterQueryService.replayMessage(chatId);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.INFO_MENU_CAT_SHELTER;
    }
}
