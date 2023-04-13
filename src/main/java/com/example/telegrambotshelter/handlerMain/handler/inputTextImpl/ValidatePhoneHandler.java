package com.example.telegrambotshelter.handlerMain.handler.inputTextImpl;

import com.example.telegrambotshelter.handlerMain.BotState;
import com.example.telegrambotshelter.handlerMain.handler.InputHandler;
import com.example.telegrambotshelter.service.inputTextServiceImpl.ValidatePhoneHandlerService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.List;

@Component
public class ValidatePhoneHandler implements InputHandler {

    private final ValidatePhoneHandlerService validatePhoneHandlerService;

    public ValidatePhoneHandler(ValidatePhoneHandlerService validatePhoneHandlerService) {
        this.validatePhoneHandlerService = validatePhoneHandlerService;
    }

    @Override
    public List<PartialBotApiMethod<Message>> handle(Message inputMessage) {
        return validatePhoneHandlerService.replayMessage(inputMessage);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.VALIDATE_PHONE;
    }
}
