package com.example.telegrambotshelter.service.dogShelter;

import com.example.telegrambotshelter.service.ReplyMessagesService;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.ArrayList;
import java.util.List;

@Service
public class SecurityDogShelterQueryService {

    private final ReplyMessagesService replyMessagesService;

    public SecurityDogShelterQueryService(ReplyMessagesService replyMessagesService) {
        this.replyMessagesService = replyMessagesService;
    }

    public List<PartialBotApiMethod<Message>> getSecurityDogInfo(long chatId) {

        List<PartialBotApiMethod<Message>> partialBotApiMethodsList = new ArrayList<>();

        SendMessage sendInfoMessage = new SendMessage();
        sendInfoMessage.setChatId(chatId);
        sendInfoMessage.setText(replyMessagesService.getReplyText("reply.security.dog.message"));

        partialBotApiMethodsList.add(sendInfoMessage);

        return partialBotApiMethodsList;
    }
}
