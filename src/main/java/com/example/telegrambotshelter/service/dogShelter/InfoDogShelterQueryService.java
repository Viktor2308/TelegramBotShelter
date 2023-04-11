package com.example.telegrambotshelter.service.dogShelter;

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

import static com.example.telegrambotshelter.utils.Emojis.SMILE;
import static com.example.telegrambotshelter.utils.Emojis.TRUMBSUP;

@Service
public class InfoDogShelterQueryService {

    private final ReplyMessagesService replyMessagesService;

    public InfoDogShelterQueryService(ReplyMessagesService replyMessagesService) {
        this.replyMessagesService = replyMessagesService;
    }

    public List<PartialBotApiMethod<Message>> getInfoDogShelterService(long chatId) {
        List<PartialBotApiMethod<Message>> partialBotApiMethodsList = new ArrayList<>();
        InputFile inputFile = new InputFile(
                new File("C:\\Users\\User\\Downloads\\TelegramBotShelter\\src\\main\\resources\\img\\infoDogShelter.png"));
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(inputFile);
        SendMessage sendInfoMessage = new SendMessage();
        sendInfoMessage.setChatId(chatId);
        sendInfoMessage.setText(replyMessagesService.getEmojiReplyText("reply.info.dog.shelter.message", SMILE,TRUMBSUP));

        partialBotApiMethodsList.add(sendPhoto);
        partialBotApiMethodsList.add(sendInfoMessage);


        return partialBotApiMethodsList;
    }
}
