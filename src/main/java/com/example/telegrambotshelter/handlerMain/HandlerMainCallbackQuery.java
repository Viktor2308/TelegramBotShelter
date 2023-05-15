package com.example.telegrambotshelter.handlerMain;

import com.example.telegrambotshelter.cache.UserDataCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.List;

@Slf4j
@Service
public class HandlerMainCallbackQuery {

    private final UserDataCache userDataCache;
    private final BotStateContext botStateContext;

    public HandlerMainCallbackQuery(UserDataCache userDataCache, BotStateContext botStateContext) {
        this.userDataCache = userDataCache;
        this.botStateContext = botStateContext;
    }

    public List<PartialBotApiMethod<Message>> handleCallbackQueryMessage(CallbackQuery callbackQuery) {
        BotState botState = BotState.getBotStateMap().getOrDefault(callbackQuery.getData(), userDataCache.getUsersCurrentBotState(callbackQuery.getFrom().getId()));
        return botStateContext.processInputMessage(botState, callbackQuery.getFrom().getId());
    }

}
