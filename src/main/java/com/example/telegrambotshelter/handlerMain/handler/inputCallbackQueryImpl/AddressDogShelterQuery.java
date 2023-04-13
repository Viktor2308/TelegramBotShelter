package com.example.telegrambotshelter.handlerMain.handler.inputCallbackQueryImpl;

import com.example.telegrambotshelter.handlerMain.BotState;
import com.example.telegrambotshelter.handlerMain.handler.InputHandlerQuery;
import com.example.telegrambotshelter.service.inputCallbackQueryServiceImpl.AddressDogShelterQueryService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.List;

@Component
public class AddressDogShelterQuery implements InputHandlerQuery {

    private final AddressDogShelterQueryService dogShelterAddressQueryService;

    public AddressDogShelterQuery(AddressDogShelterQueryService dogShelterAddressQueryService) {
        this.dogShelterAddressQueryService = dogShelterAddressQueryService;
    }

    @Override
    public List<PartialBotApiMethod<Message>> handle(long chatId) {
        return dogShelterAddressQueryService.replayMessage(chatId);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.DOG_SHELTER_ADDRESS;
    }
}
