package com.example.telegrambotshelter.handlerMain.handler;


import com.example.telegrambotshelter.handlerMain.BotState;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public interface InputHandlerMessage {

    SendMessage handle(Message inputMessage);

    BotState getHandlerName();
}
