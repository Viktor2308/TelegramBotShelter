package com.example.telegrambotshelter.handlerMain;

import com.example.telegrambotshelter.cach.UserDataCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class HandlerMain {

    private final HandlerMainCallbackQuery mainCallbackQuery;
    private final UserDataCache userDataCache;
    private final BotStateContext botStateContext;

    public HandlerMain(HandlerMainCallbackQuery mainCallbackQuery, UserDataCache userDataCache, BotStateContext botStateContext) {
        this.mainCallbackQuery = mainCallbackQuery;
        this.userDataCache = userDataCache;
        this.botStateContext = botStateContext;
    }

    public List<PartialBotApiMethod<Message>> handleUpdate(Update update) {

        List<PartialBotApiMethod<Message>> replyMessageArrayList = new ArrayList<>();

        if (update.hasCallbackQuery()) {
            log.info("New callbackQuery from User: {}, chatId: {}, with data: {}"
                    , update.getCallbackQuery().getFrom().getUserName()
                    , update.getCallbackQuery().getFrom().getId()
                    , update.getCallbackQuery().getData());

            replyMessageArrayList.add(mainCallbackQuery.handleCallbackQueryMessage(update.getCallbackQuery()));
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

        String inputText = message.getText();
        long userId = message.getChat().getId();

        switch (inputText) {
            case "/start" -> userDataCache.setUsersCurrentBotState(userId, BotState.SHOW_MAIN_MENU);
            case "/info" -> userDataCache.setUsersCurrentBotState(userId, BotState.SHOW_INFO_MENU);
            default -> userDataCache.getUsersCurrentBotState(userId);
        }

        List<PartialBotApiMethod<Message>> replyMessageList = botStateContext.processInputMessage(userDataCache.getUsersCurrentBotState(userId), message);

        return replyMessageList;
    }


}
