package com.example.telegrambotshelter.service.catShelter;

import com.example.telegrambotshelter.service.ReplyMessagesService;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.ArrayList;
import java.util.List;

@Service
public class SecurityCatShelterQueryService {

    private final ReplyMessagesService replyMessagesService;

    public SecurityCatShelterQueryService(ReplyMessagesService replyMessagesService) {
        this.replyMessagesService = replyMessagesService;
    }

    public List<PartialBotApiMethod<Message>> getSecurityCat(long chatId) {
        List<PartialBotApiMethod<Message>> partialBotApiMethodsList = new ArrayList<>();
        partialBotApiMethodsList.add(
                new SendMessage(Long.toString(chatId)
                        , replyMessagesService.getReplyText("reply.security.cat.message")));
        return partialBotApiMethodsList;
    }
}
