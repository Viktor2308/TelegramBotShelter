package com.example.telegrambotshelter.service;

import com.example.telegrambotshelter.cach.UserDataCache;
import com.example.telegrambotshelter.entity.RequestsForFeedback;
import com.example.telegrambotshelter.handlerMain.BotState;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ValidatePhoneHandlerService {

    private final ReplyMessagesService replyMessagesService;
    private final RequestsForFeedbackService requestsForFeedbackService;
    private final UserDataCache userDataCache;

    public ValidatePhoneHandlerService(ReplyMessagesService replyMessagesService, RequestsForFeedbackService requestsForFeedbackService, UserDataCache userDataCache) {
        this.replyMessagesService = replyMessagesService;
        this.requestsForFeedbackService = requestsForFeedbackService;
        this.userDataCache = userDataCache;
    }

    public List<PartialBotApiMethod<Message>> ValidatePhoneNumber(Message inputMessage) {
        List<PartialBotApiMethod<Message>> partialBotApiMethods = new ArrayList<>();
        String phoneNumber = inputMessage.getText();
        if(checkPhone(phoneNumber)){
            String phone = phoneNumber.replaceAll("[^0-9]", "");
            requestsForFeedbackService.saveRequestsForFeedback(
                    new RequestsForFeedback(inputMessage.getChatId(),inputMessage.getFrom().getUserName(),phone));
            partialBotApiMethods.add(new SendMessage(inputMessage.getChatId().toString(), replyMessagesService.getReplyText("reply.validate.phone.message")));
            userDataCache.setUsersCurrentBotState(inputMessage.getChatId(), BotState.SHOW_MAIN_MENU);
        } else {
            log.info("Non validate phone from User:{}, chatId: {},  with text: {}"
                    , inputMessage.getFrom().getUserName()
                    , inputMessage.getChat().getId()
                    , inputMessage.getText());
            partialBotApiMethods.add(new SendMessage(inputMessage.getChatId().toString(), replyMessagesService.getReplyText("reply.not.validate.phone.message")));
            userDataCache.setUsersCurrentBotState(inputMessage.getChatId(), BotState.VALIDATE_PHONE);
        }
        return partialBotApiMethods;
    }

    public static boolean checkPhone(String phone) {
        String regex = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$";
        return phone.matches(regex);
    }

}
