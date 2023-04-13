package com.example.telegrambotshelter.service.inputCallbackQueryServiceImpl;

import com.example.telegrambotshelter.entity.RequestsForFeedback;
import com.example.telegrambotshelter.service.ReplyCallbackQueryService;
import com.example.telegrambotshelter.service.locale.ReplyMessagesService;
import com.example.telegrambotshelter.service.repositoryServiceImpl.RequestsForFeedbackService;
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

import static com.example.telegrambotshelter.utils.Emojis.*;

@Service
@AllArgsConstructor
public class VolunteerQueryService implements ReplyCallbackQueryService {

    private final ReplyMessagesService replyMessagesService;
    private final RequestsForFeedbackService requestsForFeedbackService;

    @Override
    public List<PartialBotApiMethod<Message>> replayMessage(long chatId) {
        List<PartialBotApiMethod<Message>> partialBotApiMethodsList = new ArrayList<>();
        InputFile inputFile = new InputFile(
                new File("C:\\Users\\User\\Downloads\\TelegramBotShelter\\src\\main\\resources\\img\\volunteer.png"));
        SendPhoto sendPhoto = new SendPhoto(Long.toString(chatId), inputFile);
        SendMessage sendInfoMessage = new SendMessage(Long.toString(chatId),
                replyMessagesService.getEmojiReplyText("reply.volunteer.message", BICYCLIST));
        partialBotApiMethodsList.add(sendPhoto);
        partialBotApiMethodsList.add(sendInfoMessage);
        requestsForFeedbackService.add(new RequestsForFeedback(chatId));
        return partialBotApiMethodsList;

    }


}
