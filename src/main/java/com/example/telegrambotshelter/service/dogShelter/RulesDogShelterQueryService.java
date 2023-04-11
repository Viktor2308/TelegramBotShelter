package com.example.telegrambotshelter.service.dogShelter;

import com.example.telegrambotshelter.service.ReplyMessagesService;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.ArrayList;
import java.util.List;

@Service
public class RulesDogShelterQueryService {

    private final ReplyMessagesService replyMessagesService;

    public RulesDogShelterQueryService(ReplyMessagesService replyMessagesService) {
        this.replyMessagesService = replyMessagesService;
    }


    public List<PartialBotApiMethod<Message>> getRulesDogShelter(long chatId) {
        List<PartialBotApiMethod<Message>> partialBotApiMethodsList = new ArrayList<>();

        partialBotApiMethodsList.add(new SendMessage(Long.toString(chatId),replyMessagesService.getReplyText("reply.rules.dog.shelter0")));
        partialBotApiMethodsList.add(new SendMessage(Long.toString(chatId),replyMessagesService.getReplyText("reply.rules.dog.shelter1")));
        partialBotApiMethodsList.add(new SendMessage(Long.toString(chatId),replyMessagesService.getReplyText("reply.rules.dog.shelter2")));
        partialBotApiMethodsList.add(new SendMessage(Long.toString(chatId),replyMessagesService.getReplyText("reply.rules.dog.shelter3")));
        partialBotApiMethodsList.add(new SendMessage(Long.toString(chatId),replyMessagesService.getReplyText("reply.rules.dog.shelter4")));

        return partialBotApiMethodsList;
    }
}
