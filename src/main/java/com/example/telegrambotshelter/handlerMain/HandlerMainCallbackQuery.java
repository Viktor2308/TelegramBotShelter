package com.example.telegrambotshelter.handlerMain;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

@Service
public class HandlerMainCallbackQuery {

    public SendMessage processCallbackQuery(CallbackQuery callbackQuery) {
        return null;
    }
}
