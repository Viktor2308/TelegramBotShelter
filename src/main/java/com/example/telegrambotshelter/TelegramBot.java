package com.example.telegrambotshelter;

import com.example.telegrambotshelter.config.BotConfig;
import com.example.telegrambotshelter.handlerMain.HandlerMain;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
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
        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {

            log.info("New message from User: {} with data: {}"
                    , update.getMessage().getChat().getFirstName()
                    , update.getMessage().getText());

            SendMessage sendMessage = handlerMain.handleUpdate(update);

            try {

                execute(sendMessage); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
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
