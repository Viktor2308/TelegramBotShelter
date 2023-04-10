package com.example.telegrambotshelter.handlerMain;

import com.example.telegrambotshelter.cach.UserDataCache;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

@Service
public class HandlerMainCallbackQuery {

    private final UserDataCache userDataCache;
    private final BotStateContext botStateContext;

    public HandlerMainCallbackQuery(UserDataCache userDataCache, BotStateContext botStateContext) {
        this.userDataCache = userDataCache;
        this.botStateContext = botStateContext;
    }

    public SendMessage handleCallbackQueryMessage(CallbackQuery callbackQuery) {

        String inputQueryText = callbackQuery.getData();
        long userId = callbackQuery.getFrom().getId();


        switch (inputQueryText) {
            case "/catsShelterMenu" -> userDataCache.setUsersCurrentBotState(userId, BotState.SHOW_CAT_SHELTER_MENU);
            case "/dogsShelterMenu" -> userDataCache.setUsersCurrentBotState(userId, BotState.SHOW_DOG_SHELTER_MENU);
            default -> {
            }
        }
        return botStateContext.processInputMessage(
                userDataCache.getUsersCurrentBotState(userId), callbackQuery.getFrom().getId());
    }

}
