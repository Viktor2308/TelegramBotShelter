package com.example.telegrambotshelter;

import com.example.telegrambotshelter.config.BotConfig;
import com.example.telegrambotshelter.handlerMain.HandlerMain;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


@Slf4j
@Component
public class TelegramBot extends TelegramLongPollingBot {

    private final BotConfig botConfig;
    private final HandlerMain handlerMain;


    public TelegramBot(BotConfig botConfig, HandlerMain handlerMain) {
        this.botConfig = botConfig;
        this.handlerMain = handlerMain;
    }

    @Override
    public void onUpdateReceived(Update update) {


        handlerMain.handleUpdate(update).forEach(message -> {
            if(message.getClass()==SendMessage.class){
                try {
                    execute((SendMessage) message);
                } catch (TelegramApiException e) {
                    log.error(e.getMessage());
                }
            } else if (message.getClass()==SendPhoto.class) {
                try {
                    execute((SendPhoto) message);
                } catch (TelegramApiException e) {
                    log.error(e.getMessage());
                }
            }
        });
    }


    @Override
    public String getBotUsername() {
        return botConfig.getBotUserName();
    }

    @Override
    public String getBotToken() {
        return botConfig.getBotToken();
    }






}
