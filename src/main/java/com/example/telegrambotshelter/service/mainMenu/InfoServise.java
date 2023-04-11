package com.example.telegrambotshelter.service.mainMenu;

import com.example.telegrambotshelter.service.ReplyMessagesService;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.io.File;
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
        List<PartialBotApiMethod<Message>> partialBotApiMethodsList = new ArrayList<>();
        InputFile inputFile = new InputFile(
                new File("C:\\Users\\User\\Downloads\\TelegramBotShelter\\src\\main\\resources\\img\\infoBot.png"));
        SendPhoto sendPhoto = new SendPhoto(inputMessage.getChatId().toString(), inputFile);
        SendMessage sendInfoMessage = new SendMessage(inputMessage.getChatId().toString(),
                replyMessagesService.getEmojiReplyText("reply.info.message", ROBOT_FACE, MALE_STUDENT));
        partialBotApiMethodsList.add(sendPhoto);
        partialBotApiMethodsList.add(sendInfoMessage);
        return partialBotApiMethodsList;
    }
}
