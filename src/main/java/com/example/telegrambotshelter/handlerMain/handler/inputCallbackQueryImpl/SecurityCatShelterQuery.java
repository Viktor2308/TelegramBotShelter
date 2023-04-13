package com.example.telegrambotshelter.handlerMain.handler.inputCallbackQueryImpl;

import com.example.telegrambotshelter.handlerMain.BotState;
import com.example.telegrambotshelter.handlerMain.handler.InputHandlerQuery;
import com.example.telegrambotshelter.service.inputCallbackQueryServiceImpl.SecurityCatShelterQueryService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.List;

@Component
public class SecurityCatShelterQuery implements InputHandlerQuery {

    private final SecurityCatShelterQueryService securityCatShelterQueryService;

    public SecurityCatShelterQuery(SecurityCatShelterQueryService securityCatShelterQueryService) {
        this.securityCatShelterQueryService = securityCatShelterQueryService;
    }

    @Override
    public List<PartialBotApiMethod<Message>> handle(long chatId) {
        return securityCatShelterQueryService.replayMessage(chatId);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.CAT_SHELTER_SECURITY;
    }
}
