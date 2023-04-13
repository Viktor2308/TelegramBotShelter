package com.example.telegrambotshelter.service.locale;

import com.example.telegrambotshelter.service.locale.LocaleMessageService;
import com.example.telegrambotshelter.utils.Emojis;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Service
public class ReplyMessagesService {

    private LocaleMessageService localeMessageService;

    public ReplyMessagesService(LocaleMessageService messageService) {
        this.localeMessageService = messageService;
    }

    public SendMessage getReplyMessage(String chatId, String replyMessage) {
        return new SendMessage(chatId, localeMessageService.getMessage(replyMessage));
    }

    public SendMessage getReplyMessage(String chatId, String replyMessage, Emojis emoji) {
        return new SendMessage(chatId, getEmojiReplyText(replyMessage,emoji));
    }

    public String getReplyText(String replyText) {
        return localeMessageService.getMessage(replyText);
    }

    public String getEmojiReplyText(String replyText, Emojis... emoji) {
        return localeMessageService.getMessage(replyText, emoji);
    }

}
