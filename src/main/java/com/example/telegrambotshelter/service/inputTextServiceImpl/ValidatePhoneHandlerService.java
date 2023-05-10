package com.example.telegrambotshelter.service.inputTextServiceImpl;

import com.example.telegrambotshelter.cach.UserDataCache;
import com.example.telegrambotshelter.db.entity.RequestsForFeedback;
import com.example.telegrambotshelter.handlerMain.BotState;
import com.example.telegrambotshelter.service.ReplyTextService;
import com.example.telegrambotshelter.service.locale.ReplyMessagesService;
import com.example.telegrambotshelter.db.DAO.RequestsForFeedbackDAOImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ValidatePhoneHandlerService implements ReplyTextService {

    private final ReplyMessagesService replyMessagesService;
    private final RequestsForFeedbackDAOImpl requestsForFeedbackDAOImpl;
    private final UserDataCache userDataCache;

    public ValidatePhoneHandlerService(ReplyMessagesService replyMessagesService, RequestsForFeedbackDAOImpl requestsForFeedbackDAOImpl, UserDataCache userDataCache) {
        this.replyMessagesService = replyMessagesService;
        this.requestsForFeedbackDAOImpl = requestsForFeedbackDAOImpl;
        this.userDataCache = userDataCache;
    }

    @Override
    public List<PartialBotApiMethod<Message>> replayMessage(Message inputMessage) {
        List<PartialBotApiMethod<Message>> partialBotApiMethods = new ArrayList<>();
        String phoneNumber = inputMessage.getText();
        if(checkPhone(phoneNumber)){
            String phone = phoneNumber.replaceAll("[^0-9]", "");
            requestsForFeedbackDAOImpl.add(
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
