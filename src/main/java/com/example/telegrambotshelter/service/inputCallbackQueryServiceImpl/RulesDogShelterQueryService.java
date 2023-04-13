package com.example.telegrambotshelter.service.inputCallbackQueryServiceImpl;

import com.example.telegrambotshelter.service.ReplyCallbackQueryService;
import com.example.telegrambotshelter.service.locale.ReplyMessagesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class RulesDogShelterQueryService implements ReplyCallbackQueryService {

    private final ReplyMessagesService replyMessagesService;

    @Override
    public List<PartialBotApiMethod<Message>> replayMessage(long chatId) {

        List<PartialBotApiMethod<Message>> partialBotApiMethodsList = new ArrayList<>();

        partialBotApiMethodsList.add(new SendMessage(Long.toString(chatId),replyMessagesService.getReplyText("reply.rules.dog.shelter0")));
        partialBotApiMethodsList.add(new SendMessage(Long.toString(chatId),replyMessagesService.getReplyText("reply.rules.dog.shelter1")));
        partialBotApiMethodsList.add(new SendMessage(Long.toString(chatId),replyMessagesService.getReplyText("reply.rules.dog.shelter2")));
        partialBotApiMethodsList.add(new SendMessage(Long.toString(chatId),replyMessagesService.getReplyText("reply.rules.dog.shelter3")));
        partialBotApiMethodsList.add(new SendMessage(Long.toString(chatId),replyMessagesService.getReplyText("reply.rules.dog.shelter4")));

        return partialBotApiMethodsList;
    }
}
