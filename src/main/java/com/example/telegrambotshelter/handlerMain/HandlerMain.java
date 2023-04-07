package com.example.telegrambotshelter.handlerMain;


import com.example.telegrambotshelter.cach.DataCache;
import com.example.telegrambotshelter.cach.UserDataCache;
import com.example.telegrambotshelter.service.ReplyMessagesService;
import com.example.telegrambotshelter.service.locale.LocaleMessageService;
import com.example.telegrambotshelter.utils.Emojis;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Slf4j
@Service
public class HandlerMain {

    private final ReplyMessagesService replyMessagesService;
    private final HandlerMainCallbackQuery mainCallbackQuery;
    private final UserDataCache userDataCache;
    private final BotStateContext botStateContext;

    public HandlerMain(ReplyMessagesService replyMessagesService, HandlerMainCallbackQuery mainCallbackQuery, UserDataCache userDataCache, BotStateContext botStateContext) {
        this.replyMessagesService = replyMessagesService;
        this.mainCallbackQuery = mainCallbackQuery;
        this.userDataCache = userDataCache;
        this.botStateContext = botStateContext;
    }

    public SendMessage handleUpdate(Update update){

//        SendMessage message = replyMessagesService.getReplyMessage(update.getMessage().getChatId().toString()
//                ,"reply.mainMenu.base"
//                , Emojis.CRY);

        SendMessage replyMessage = null;

//        if (update.getCallbackQuery() != null) {
//            log.info("New callbackQuery from User: {} with data: {}"
//                    , update.getCallbackQuery().getFrom().getUserName()
//                    , update.getCallbackQuery().getData());
//            replyMessage = mainCallbackQuery.processCallbackQuery(update.getCallbackQuery());
//
//            return replyMessage;
//        }

        if (update.getMessage() != null && update.getMessage().getText() != null) {
            log.info("New message from User:{}, chatId: {},  with text: {}"
                    , update.getMessage().getFrom().getUserName()
                    , update.getMessage().getChat().getId()
                    , update.getMessage().getText());
            replyMessage = handleInputMessage(update.getMessage());
        }

        return replyMessage;
    }

    public SendMessage handleInputMessage(Message message) {
        String inputText = message.getText();
        long userId = message.getChat().getId();
        BotState botState;
        SendMessage replyMessage;

        switch (inputText) {
            case "/start":
                botState = BotState.SHOW_MAIN_MENU;
                break;
            case "/info":
                botState = BotState.SHOW_INFO_MENU;
                break;
            case "/help":
                botState = BotState.SHOW_HELP_MENU;
                break;

            default:
                botState = userDataCache.getUsersCurrentBotState(userId);
                break;
        }

        userDataCache.setUsersCurrentBotState(userId, botState);

        replyMessage = botStateContext.processInputMessage(botState, message);

        return replyMessage;
    }

}
