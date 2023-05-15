package com.example.telegrambotshelter.handlerMain.handler.inputCallbackQueryImpl;

import com.example.telegrambotshelter.handlerMain.BotState;
import com.example.telegrambotshelter.handlerMain.handler.InputHandlerQuery;
import com.example.telegrambotshelter.service.inputCallbackQueryServiceImpl.InfoDogShelterQueryService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.List;

@Component
public class InfoDogShelterQuery implements InputHandlerQuery {

    private final InfoDogShelterQueryService infoDogShelterQueryService;

    public InfoDogShelterQuery(InfoDogShelterQueryService infoDogShelterQueryService) {
        this.infoDogShelterQueryService = infoDogShelterQueryService;
    }

    @Override
    public List<PartialBotApiMethod<Message>> handle(long chatId) {
        return infoDogShelterQueryService.replayMessage(chatId);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.INFO_DOG_SHELTER;
    }
}
