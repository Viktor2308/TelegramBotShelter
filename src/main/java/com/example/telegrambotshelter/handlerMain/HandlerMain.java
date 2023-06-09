package com.example.telegrambotshelter.handlerMain;

import com.example.telegrambotshelter.cache.UserDataCache;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class HandlerMain {

    private final HandlerMainCallbackQuery mainCallbackQuery;
    private final UserDataCache userDataCache;
    private final BotStateContext botStateContext;


    public List<PartialBotApiMethod<Message>> handleUpdate(Update update) {

        List<PartialBotApiMethod<Message>> replyMessageArrayList = new ArrayList<>();

        if (update.hasCallbackQuery()) {
            log.info("New callbackQuery from User: {}, chatId: {}, with data: {}"
                    , update.getCallbackQuery().getFrom().getUserName()
                    , update.getCallbackQuery().getFrom().getId()
                    , update.getCallbackQuery().getData());

            replyMessageArrayList.addAll(mainCallbackQuery.handleCallbackQueryMessage(update.getCallbackQuery()));
        }

        if (update.getMessage() != null && update.getMessage().getText() != null) {
            log.info("New message from User:{}, chatId: {},  with text: {}"
                    , update.getMessage().getFrom().getUserName()
                    , update.getMessage().getChat().getId()
                    , update.getMessage().getText());

            replyMessageArrayList.addAll(handleInputMessage(update.getMessage()));
        }

        return replyMessageArrayList;
    }

    public List<PartialBotApiMethod<Message>> handleInputMessage(Message message) {
        BotState botState = BotState.getBotStateMap().getOrDefault(message.getText(), userDataCache.getUsersCurrentBotState(message.getChat().getId()));
        return botStateContext.processInputMessage(botState, message);
    }


}
