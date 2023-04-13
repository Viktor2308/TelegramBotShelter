package com.example.telegrambotshelter.service.inputCallbackQueryServiceImpl;

import com.example.telegrambotshelter.cach.UserDataCache;
import com.example.telegrambotshelter.service.ReplyCallbackQueryService;
import com.example.telegrambotshelter.service.locale.ReplyMessagesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.ArrayList;
import java.util.List;

import static com.example.telegrambotshelter.handlerMain.BotState.VALIDATE_PHONE;
import static com.example.telegrambotshelter.utils.Emojis.TELEPHONE_RECEIVER;

@Service
@AllArgsConstructor
public class CallBackDogShelterQueryService implements ReplyCallbackQueryService {

    private final ReplyMessagesService replyMessagesService;
    private final UserDataCache userDataCache;

    @Override
    public List<PartialBotApiMethod<Message>> replayMessage(long chatId) {
        List<PartialBotApiMethod<Message>> partialBotApiMethodsList = new ArrayList<>();
        partialBotApiMethodsList.add(
                new SendMessage(Long.toString(chatId)
                        , replyMessagesService.getEmojiReplyText("reply.call.back.dog.message", TELEPHONE_RECEIVER)));
        userDataCache.setUsersCurrentBotState(chatId, VALIDATE_PHONE);
        return partialBotApiMethodsList;
    }


}
