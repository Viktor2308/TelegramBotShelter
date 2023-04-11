package com.example.telegrambotshelter.handlerMain.handler.callbackQuery;

import com.example.telegrambotshelter.handlerMain.BotState;
import com.example.telegrambotshelter.handlerMain.handler.InputHandlerQuery;
import com.example.telegrambotshelter.service.dogShelter.AddressDogShelterQueryService;
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
        return dogShelterAddressQueryService.getDogShelterAddress(chatId);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.DOG_SHELTER_ADDRESS;
    }
}
