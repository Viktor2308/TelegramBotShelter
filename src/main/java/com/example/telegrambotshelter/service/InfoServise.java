package com.example.telegrambotshelter.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.ArrayList;
import java.util.List;

import static com.example.telegrambotshelter.utils.Emojis.*;

@Service
public class InfoServise {

    private final ReplyMessagesService replyMessagesService;

    public InfoServise(ReplyMessagesService replyMessagesService) {
        this.replyMessagesService = replyMessagesService;
    }

    public List<PartialBotApiMethod<Message>> getInfoMenu(Message inputMessage) {
        ArrayList<PartialBotApiMethod<Message>> infoMenuMessageList = new ArrayList<>();
        final SendMessage infoMenuMessage =
                new SendMessage(inputMessage.getChatId().toString()
                        ,replyMessagesService.getEmojiReplyText("reply.info.message",ROBOT_FACE,MALE_STUDENT));
        infoMenuMessageList.add(infoMenuMessage);
        return infoMenuMessageList;
    }
}
