package com.example.telegrambotshelter.handlerMain.handler.callbackQuery;

import com.example.telegrambotshelter.handlerMain.BotState;
import com.example.telegrambotshelter.handlerMain.handler.InputHandlerQuery;
import com.example.telegrambotshelter.service.VolunteerQueryService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.List;

@Component
public class VolunteerQuery implements InputHandlerQuery {

    private final VolunteerQueryService volunteerQueryService;

    public VolunteerQuery(VolunteerQueryService volunteerQueryService) {
        this.volunteerQueryService = volunteerQueryService;
    }

    @Override
    public List<PartialBotApiMethod<Message>> handle(long chatId) {
        return volunteerQueryService.getVolunteer(chatId);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.CALL_VOLUNTEER;
    }
}
