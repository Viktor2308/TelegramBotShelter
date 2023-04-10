package com.example.telegrambotshelter.handlerMain.handler;

import com.example.telegrambotshelter.handlerMain.BotState;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.List;

public interface InputHandler {

    BotState getHandlerName();

    List<PartialBotApiMethod<Message>> handle(Message inputMessage);

}
