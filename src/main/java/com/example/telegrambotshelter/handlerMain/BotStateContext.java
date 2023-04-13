package com.example.telegrambotshelter.handlerMain;


import com.example.telegrambotshelter.handlerMain.handler.InputHandler;
import com.example.telegrambotshelter.handlerMain.handler.InputHandlerQuery;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.*;



@Component
public class BotStateContext {

    private final Map<BotState, InputHandler> inputHandler = new HashMap<>();
    private final Map<BotState, InputHandlerQuery> inputHandlerQuery = new HashMap<>();

    public BotStateContext(List<InputHandler> inputHandler, List<InputHandlerQuery> inputHandlerQuery ) {
        inputHandler.forEach(handler -> this.inputHandler.put(handler.getHandlerName(), handler));
        inputHandlerQuery.forEach(handler -> this.inputHandlerQuery.put(handler.getHandlerName(), handler));
    }

    public List<PartialBotApiMethod<Message>> processInputMessage(BotState currentState, Message message) {
        InputHandler currentMessageHandler = findMessageHandler(currentState);
        return currentMessageHandler.handle(message);
    }

    public List<PartialBotApiMethod<Message>> processInputMessage(BotState currentState, long chatId) {
        InputHandlerQuery inputHandlerQuery = findMessageHandlerQuery(currentState);
        return inputHandlerQuery.handle(chatId);
    }

    private InputHandler findMessageHandler(BotState currentState) {
        return inputHandler.get(currentState);
    }

    private InputHandlerQuery findMessageHandlerQuery(BotState currentState) {
        return inputHandlerQuery.get(currentState);
    }

}
