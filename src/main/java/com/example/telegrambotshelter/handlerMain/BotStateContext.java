package com.example.telegrambotshelter.handlerMain;


import com.example.telegrambotshelter.handlerMain.handler.InputHandlerMessage;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.*;



@Component
public class BotStateContext {

    private final Map<BotState, InputHandlerMessage> messageHandlers = new HashMap<>();

    public BotStateContext(List<InputHandlerMessage> messageHandlers) {
        messageHandlers.forEach(handler -> this.messageHandlers.put(handler.getHandlerName(), handler));
    }

    public SendMessage processInputMessage(BotState currentState, Message message) {
        InputHandlerMessage currentMessageHandler = findMessageHandler(currentState);
        return currentMessageHandler.handle(message);
    }

    private InputHandlerMessage findMessageHandler(BotState currentState) {
        return messageHandlers.get(currentState);
    }

//    private boolean isFilingTaskState(BotState currentState) {
//        switch (currentState) {
//            case CREATE_REMINDER:
//                return true;
//            default:
//                return false;
//        }
//    }

}
