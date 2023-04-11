package com.example.telegrambotshelter.service.catShelter;

import com.example.telegrambotshelter.service.ReplyMessagesService;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.ArrayList;
import java.util.List;

@Service
public class RulesCatShelterQueryService {

    private final ReplyMessagesService replyMessagesService;

    public RulesCatShelterQueryService(ReplyMessagesService replyMessagesService) {
        this.replyMessagesService = replyMessagesService;
    }

    public List<PartialBotApiMethod<Message>> getRulesCatShelter(long chatId) {
        List<PartialBotApiMethod<Message>> partialBotApiMethodsList = new ArrayList<>();

        partialBotApiMethodsList.add(new SendMessage(Long.toString(chatId),replyMessagesService.getReplyText("reply.rules.cat.shelter0")));
        partialBotApiMethodsList.add(new SendMessage(Long.toString(chatId),replyMessagesService.getReplyText("reply.rules.cat.shelter1")));
        partialBotApiMethodsList.add(new SendMessage(Long.toString(chatId),replyMessagesService.getReplyText("reply.rules.cat.shelter2")));
        partialBotApiMethodsList.add(new SendMessage(Long.toString(chatId),replyMessagesService.getReplyText("reply.rules.cat.shelter3")));
        partialBotApiMethodsList.add(new SendMessage(Long.toString(chatId),replyMessagesService.getReplyText("reply.rules.cat.shelter4")));

        return partialBotApiMethodsList;
    }
}
