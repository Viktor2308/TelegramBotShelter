package com.example.telegrambotshelter.service.catShelter;

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
public class AddressCatShelterQueryService {

    private final ReplyMessagesService replyMessagesService;

    public AddressCatShelterQueryService(ReplyMessagesService replyMessagesService) {
        this.replyMessagesService = replyMessagesService;
    }

    public List<PartialBotApiMethod<Message>> getCatShelterAddress(long chatId) {
        List<PartialBotApiMethod<Message>> partialBotApiMethodsList = new ArrayList<>();
        InputFile inputFile = new InputFile(
                new File("C:\\Users\\User\\Downloads\\TelegramBotShelter\\src\\main\\resources\\img\\addressCat.png"));
        partialBotApiMethodsList.add(new SendMessage(Long.toString(chatId), replyMessagesService.getEmojiReplyText("reply.address.cat.message", CLOCK_3, ARROW_DOUBLE)));
        partialBotApiMethodsList.add(new SendPhoto(Long.toString(chatId), inputFile));

        return partialBotApiMethodsList;
    }
}
