package com.example.telegrambotshelter.handlerMain.handler.callbackQuery;

import com.example.telegrambotshelter.handlerMain.BotState;
import com.example.telegrambotshelter.handlerMain.handler.InputHandlerQuery;
import com.example.telegrambotshelter.service.catShelter.AddressCatShelterQueryService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.List;

@Component
public class AddressCatShelterQuery implements InputHandlerQuery {

    private final AddressCatShelterQueryService catShelterAddressQueryService;

    public AddressCatShelterQuery(AddressCatShelterQueryService catShelterAddressQueryService) {
        this.catShelterAddressQueryService = catShelterAddressQueryService;
    }

    @Override
    public List<PartialBotApiMethod<Message>> handle(long chatId) {
        return catShelterAddressQueryService.getCatShelterAddress(chatId);
    }

    @Override
    public BotState getHandlerName() {
        return BotState.CAT_SHELTER_ADDRESS;
    }
}
