package com.example.telegrambotshelter.handlerMain.handler.menu;


import com.example.telegrambotshelter.handlerMain.BotState;
import com.example.telegrambotshelter.handlerMain.handler.InputHandler;
import com.example.telegrambotshelter.service.mainMenu.MainMenuService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.List;


@Component
public class MainMenuHandler implements InputHandler {

    private final MainMenuService mainMenuService;

    public MainMenuHandler(MainMenuService mainMenuService) {
        this.mainMenuService = mainMenuService;
    }

    @Override
    public List<PartialBotApiMethod<Message>> handle(Message inputMessage) {
        return mainMenuService.getMainMenuMessage(inputMessage);
    }


    @Override
    public BotState getHandlerName() {
        return BotState.SHOW_MAIN_MENU;
    }


}
