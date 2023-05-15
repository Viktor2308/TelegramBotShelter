package com.example.telegrambotshelter.service.inputTextServiceImpl;

import com.example.telegrambotshelter.service.ReplyTextService;
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

import static com.example.telegrambotshelter.utils.Emojis.*;

@Service
@AllArgsConstructor
public class InfoService implements ReplyTextService {

    private final ReplyMessagesService replyMessagesService;

    @Override
    public List<PartialBotApiMethod<Message>> replayMessage(Message inputMessage) {
        List<PartialBotApiMethod<Message>> partialBotApiMethodsList = new ArrayList<>();
        InputFile inputFile = new InputFile(
                new File("src/main/resources/img/infoBot.png"));
        SendPhoto sendPhoto = new SendPhoto(inputMessage.getChatId().toString(), inputFile);
        SendMessage sendInfoMessage = new SendMessage(inputMessage.getChatId().toString(),
                replyMessagesService.getEmojiReplyText("reply.info.message", ROBOT_FACE, MALE_STUDENT));
        partialBotApiMethodsList.add(sendPhoto);
        partialBotApiMethodsList.add(sendInfoMessage);
        return partialBotApiMethodsList;
    }
}
