package com.example.telegrambotshelter.cach;


import com.example.telegrambotshelter.handlerMain.BotState;

public interface DataCache {

    void setUsersCurrentBotState(long userId, BotState botState);

    BotState getUsersCurrentBotState(long userId);

}
