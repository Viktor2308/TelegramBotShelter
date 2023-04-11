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

import static com.example.telegrambotshelter.utils.Emojis.ARROW_DOUBLE;
import static com.example.telegrambotshelter.utils.Emojis.CLOCK_3;

@Service
public class AddressDogShelterQueryService {

    private final ReplyMessagesService replyMessagesService;

    public AddressDogShelterQueryService(ReplyMessagesService replyMessagesService) {
        this.replyMessagesService = replyMessagesService;
    }

    public List<PartialBotApiMethod<Message>> getDogShelterAddress(long chatId) {

        List<PartialBotApiMethod<Message>> partialBotApiMethodsList = new ArrayList<>();
        InputFile inputFile = new InputFile(
                new File("C:\\Users\\User\\Downloads\\TelegramBotShelter\\src\\main\\resources\\img\\addressDog.png"));
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(inputFile);
        SendMessage sendInfoMessage = new SendMessage();
        sendInfoMessage.setChatId(chatId);
        sendInfoMessage.setText(replyMessagesService.getEmojiReplyText("reply.address.dog.message", CLOCK_3,ARROW_DOUBLE));

        partialBotApiMethodsList.add(sendInfoMessage);
        partialBotApiMethodsList.add(sendPhoto);

        return partialBotApiMethodsList;
    }
}
