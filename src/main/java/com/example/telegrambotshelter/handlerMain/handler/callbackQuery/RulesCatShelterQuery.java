package com.example.telegrambotshelter.handlerMain.handler.callbackQuery;

import com.example.telegrambotshelter.handlerMain.BotState;
import com.example.telegrambotshelter.handlerMain.handler.InputHandlerQuery;
import com.example.telegrambotshelter.service.catShelter.RulesCatShelterQueryService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.List;

@Component
public class RulesCatShelterQuery implements InputHandlerQuery {

    private final RulesCatShelterQueryService rulesCatShelterQueryService;

    public RulesCatShelterQuery(RulesCatShelterQueryService rulesCatShelterQueryService) {
        this.rulesCatShelterQueryService = rulesCatShelterQueryService;
    }

    @Override
    public List<PartialBotApiMethod<Message>> handle(long chatId) {
        return rulesCatShelterQueryService.getRulesCatShelter(chatId);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.CAT_SHELTER_RULES;
    }
}
