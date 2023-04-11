package com.example.telegrambotshelter.handlerMain.handler.callbackQuery;

import com.example.telegrambotshelter.handlerMain.BotState;
import com.example.telegrambotshelter.handlerMain.handler.InputHandlerQuery;
import com.example.telegrambotshelter.service.dogShelter.RulesDogShelterQueryService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.List;

@Component
public class RulesDogShelterQuery implements InputHandlerQuery {

    private final RulesDogShelterQueryService rulesDogShelterQueryService;

    public RulesDogShelterQuery(RulesDogShelterQueryService rulesDogShelterQueryService) {
        this.rulesDogShelterQueryService = rulesDogShelterQueryService;
    }

    @Override
    public List<PartialBotApiMethod<Message>> handle(long chatId) {
        return rulesDogShelterQueryService.getRulesDogShelter(chatId);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.DOG_SHELTER_RULES;
    }
}
