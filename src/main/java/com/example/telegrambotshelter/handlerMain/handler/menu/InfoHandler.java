package com.example.telegrambotshelter.handlerMain.handler.menu;

import com.example.telegrambotshelter.handlerMain.BotState;
import com.example.telegrambotshelter.handlerMain.handler.InputHandler;
import com.example.telegrambotshelter.service.mainMenu.InfoServise;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.List;


@Component
public class InfoHandler implements InputHandler {

    private final InfoServise infoServise;

    public InfoHandler(InfoServise infoServise) {
        this.infoServise = infoServise;
    }

    @Override
    public List<PartialBotApiMethod<Message>> handle(Message inputMessage) {
        return infoServise.getInfoMenu(inputMessage);
    }


    @Override
    public BotState getHandlerName() {
        return BotState.SHOW_INFO_MENU;
    }
}
