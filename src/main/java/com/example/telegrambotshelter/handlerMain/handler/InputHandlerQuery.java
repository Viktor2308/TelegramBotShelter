package com.example.telegrambotshelter.handlerMain.handler;

import com.example.telegrambotshelter.handlerMain.BotState;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public interface InputHandlerQuery{

    BotState getHandlerName();

    SendMessage handle(long chatId);
}
