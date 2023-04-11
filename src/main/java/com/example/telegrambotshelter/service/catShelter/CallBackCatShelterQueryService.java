package com.example.telegrambotshelter.service.catShelter;

import com.example.telegrambotshelter.cach.UserDataCache;
import com.example.telegrambotshelter.service.ReplyMessagesService;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.ArrayList;
import java.util.List;

import static com.example.telegrambotshelter.handlerMain.BotState.VALIDATE_PHONE;
import static com.example.telegrambotshelter.utils.Emojis.TELEPHONE_RECEIVER;

@Service
public class CallBackCatShelterQueryService {
    private final ReplyMessagesService replyMessagesService;
    private final UserDataCache userDataCache;

    public CallBackCatShelterQueryService(ReplyMessagesService replyMessagesService, UserDataCache userDataCache) {
        this.replyMessagesService = replyMessagesService;
        this.userDataCache = userDataCache;
    }

    public List<PartialBotApiMethod<Message>> getCallBackCatShelter(long chatId) {
        List<PartialBotApiMethod<Message>> partialBotApiMethodsList = new ArrayList<>();
        partialBotApiMethodsList.add(
                new SendMessage(Long.toString(chatId)
                        , replyMessagesService.getEmojiReplyText("reply.call.back.cat.message", TELEPHONE_RECEIVER)));
        userDataCache.setUsersCurrentBotState(chatId, VALIDATE_PHONE);
        return partialBotApiMethodsList;

    }
}
