package com.example.telegrambotshelter.handlerMain.handler.inputCallbackQueryImpl;

import com.example.telegrambotshelter.handlerMain.BotState;
import com.example.telegrambotshelter.handlerMain.handler.InputHandlerQuery;
import com.example.telegrambotshelter.service.inputCallbackQueryServiceImpl.CallBackCatShelterQueryService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.List;

@Component
public class CallBackCatShelterQuery implements InputHandlerQuery {

    private final CallBackCatShelterQueryService callBackCatShelterQueryService;

    public CallBackCatShelterQuery(CallBackCatShelterQueryService callBackCatShelterQueryService) {
        this.callBackCatShelterQueryService = callBackCatShelterQueryService;
    }

    @Override
    public List<PartialBotApiMethod<Message>> handle(long chatId) {
        return callBackCatShelterQueryService.replayMessage(chatId);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.CALL_BACK_CAT_SHELTER;
    }
}
