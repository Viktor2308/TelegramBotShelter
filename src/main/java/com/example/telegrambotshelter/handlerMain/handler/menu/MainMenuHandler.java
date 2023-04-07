package com.example.telegrambotshelter.handlerMain.handler.menu;


import com.example.telegrambotshelter.handlerMain.BotState;
import com.example.telegrambotshelter.handlerMain.handler.InputHandlerMessage;
import com.example.telegrambotshelter.service.MainMenuService;
import com.example.telegrambotshelter.service.ReplyMessagesService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import static com.example.telegrambotshelter.utils.Emojis.CAT;
import static com.example.telegrambotshelter.utils.Emojis.DOG;


@Component
public class MainMenuHandler implements InputHandlerMessage {

    private final MainMenuService mainMenuService;
    private final ReplyMessagesService replyMessagesService;

    public MainMenuHandler(MainMenuService mainMenuService, ReplyMessagesService replyMessagesService) {
        this.mainMenuService = mainMenuService;
        this.replyMessagesService = replyMessagesService;
    }

    @Override
    public SendMessage handle(Message message) {
        return mainMenuService.getMainMenuMessage(message.getChatId().toString(), replyMessagesService.getEmojiReplyText("reply.mainMenu.message",CAT,DOG));
    }

    @Override
    public BotState getHandlerName() {
        return BotState.SHOW_MAIN_MENU;
    }


}
