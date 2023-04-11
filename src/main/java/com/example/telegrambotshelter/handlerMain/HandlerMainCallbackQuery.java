package com.example.telegrambotshelter.handlerMain;

import com.example.telegrambotshelter.cach.UserDataCache;
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

        String inputQueryText = callbackQuery.getData();
        long userId = callbackQuery.getFrom().getId();


        switch (inputQueryText) {
            case "/SHOW_CAT_SHELTER_MENU" ->
                    userDataCache.setUsersCurrentBotState(userId, BotState.SHOW_CAT_SHELTER_MENU);
            case "/SHOW_DOG_SHELTER_MENU" ->
                    userDataCache.setUsersCurrentBotState(userId, BotState.SHOW_DOG_SHELTER_MENU);
            case "/INFO_CAT_SHELTER" -> userDataCache.setUsersCurrentBotState(userId, BotState.INFO_CAT_SHELTER);
            case "/INFO_DOG_SHELTER" -> userDataCache.setUsersCurrentBotState(userId, BotState.INFO_DOG_SHELTER);
            case "/CALL_VOLUNTEER" -> userDataCache.setUsersCurrentBotState(userId, BotState.CALL_VOLUNTEER);
            case "/TAKE_DOG" -> userDataCache.setUsersCurrentBotState(userId, BotState.TAKE_DOG);
            case "/TAKE_CAT" -> userDataCache.setUsersCurrentBotState(userId, BotState.TAKE_CAT);
            case "/SEND_REPORT_CAT" -> userDataCache.setUsersCurrentBotState(userId, BotState.SEND_REPORT_CAT);
            case "/SEND_REPORT_DOG" -> userDataCache.setUsersCurrentBotState(userId, BotState.SEND_REPORT_DOG);
            case "/CAT_SHELTER_SECURITY" ->
                    userDataCache.setUsersCurrentBotState(userId, BotState.CAT_SHELTER_SECURITY);
            case "/DOG_SHELTER_SECURITY" ->
                    userDataCache.setUsersCurrentBotState(userId, BotState.DOG_SHELTER_SECURITY);
            case "/INFO_MENU_CAT_SHELTER" ->
                    userDataCache.setUsersCurrentBotState(userId, BotState.INFO_MENU_CAT_SHELTER);
            case "/INFO_MENU_DOG_SHELTER" ->
                    userDataCache.setUsersCurrentBotState(userId, BotState.INFO_MENU_DOG_SHELTER);
            case "/CAT_SHELTER_ADDRESS" -> userDataCache.setUsersCurrentBotState(userId, BotState.CAT_SHELTER_ADDRESS);
            case "/DOG_SHELTER_ADDRESS" -> userDataCache.setUsersCurrentBotState(userId, BotState.DOG_SHELTER_ADDRESS);
            case "/CALL_BACK_CAT_SHELTER" ->
                    userDataCache.setUsersCurrentBotState(userId, BotState.CALL_BACK_CAT_SHELTER);
            case "/CALL_BACK_DOG_SHELTER" ->
                    userDataCache.setUsersCurrentBotState(userId, BotState.CALL_BACK_DOG_SHELTER);
            case "/CAT_SHELTER_RULES" -> userDataCache.setUsersCurrentBotState(userId, BotState.CAT_SHELTER_RULES);
            case "/DOG_SHELTER_RULES" -> userDataCache.setUsersCurrentBotState(userId, BotState.DOG_SHELTER_RULES);
            default -> log.error("Callback query error");
        }
        return botStateContext.processInputMessage(userDataCache.getUsersCurrentBotState(userId), callbackQuery.getFrom().getId());
    }

}
