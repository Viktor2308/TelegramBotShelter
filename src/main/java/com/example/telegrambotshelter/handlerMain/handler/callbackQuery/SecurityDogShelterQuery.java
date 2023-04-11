package com.example.telegrambotshelter.handlerMain.handler.callbackQuery;

import com.example.telegrambotshelter.handlerMain.BotState;
import com.example.telegrambotshelter.handlerMain.handler.InputHandlerQuery;
import com.example.telegrambotshelter.service.dogShelter.SecurityDogShelterQueryService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.List;

@Component
public class SecurityDogShelterQuery implements InputHandlerQuery {

    private final SecurityDogShelterQueryService securityDogShelterQueryService;

    public SecurityDogShelterQuery(SecurityDogShelterQueryService securityDogShelterQueryService) {
        this.securityDogShelterQueryService = securityDogShelterQueryService;
    }

    @Override
    public List<PartialBotApiMethod<Message>> handle(long chatId) {
        return securityDogShelterQueryService.getSecurityDogInfo(chatId);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.DOG_SHELTER_SECURITY;
    }
}
