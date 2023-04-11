package com.example.telegrambotshelter.handlerMain.handler.callbackQuery;

import com.example.telegrambotshelter.handlerMain.BotState;
import com.example.telegrambotshelter.handlerMain.handler.InputHandlerQuery;
import com.example.telegrambotshelter.service.dogShelter.CallBackDogShelterQueryService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.List;

@Component
public class CallBackDogShelterQuery implements InputHandlerQuery {

    private final CallBackDogShelterQueryService callBackDogShelterQueryService;

    public CallBackDogShelterQuery(CallBackDogShelterQueryService callBackDogShelterQueryService) {
        this.callBackDogShelterQueryService = callBackDogShelterQueryService;
    }

    @Override
    public List<PartialBotApiMethod<Message>> handle(long chatId) {
        return callBackDogShelterQueryService.getCallBackDogShelter(chatId);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.CALL_BACK_DOG_SHELTER;
    }
}
