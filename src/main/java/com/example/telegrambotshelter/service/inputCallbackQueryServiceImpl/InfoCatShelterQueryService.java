package com.example.telegrambotshelter.service.inputCallbackQueryServiceImpl;

import com.example.telegrambotshelter.service.ReplyCallbackQueryService;
import com.example.telegrambotshelter.service.locale.ReplyMessagesService;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class InfoCatShelterQueryService implements ReplyCallbackQueryService {

    private final ReplyMessagesService replyMessagesService;


    @Override
    public List<PartialBotApiMethod<Message>> replayMessage(long chatId) {
        List<PartialBotApiMethod<Message>> partialBotApiMethodsList = new ArrayList<>();
        InputFile inputFile = new InputFile(
                new File("src/main/resources/img/infoCatShelter.png"));
        partialBotApiMethodsList.add(new SendPhoto(Long.toString(chatId), inputFile));
        partialBotApiMethodsList.add(
                new SendMessage(Long.toString(chatId)
                        , replyMessagesService.getEmojiReplyText("reply.info.cat.shelter.message", SMILE, TRUMBSUP)));

        return partialBotApiMethodsList;
    }


}
