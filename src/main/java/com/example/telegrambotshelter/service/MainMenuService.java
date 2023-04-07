package com.example.telegrambotshelter.service;


import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

import static com.example.telegrambotshelter.utils.Emojis.*;


@Service
public class MainMenuService {

    private final ReplyMessagesService replyMessagesService;

    public MainMenuService(ReplyMessagesService replyMessagesService) {
        this.replyMessagesService = replyMessagesService;
    }

    public SendMessage getMainMenuMessage(final String chatId, final String textMessage) {
        final ReplyKeyboard keyboard = getMainMenuKeyboard();
        final SendMessage mainMenuMessage =
                createMessageWithKeyboard(chatId, textMessage, keyboard);
        return mainMenuMessage;
    }

    private ReplyKeyboard getMainMenuKeyboard() {

        List<InlineKeyboardButton> buttons = new ArrayList<>();

        InlineKeyboardButton buttonCatShelter = new InlineKeyboardButton(
                replyMessagesService.getEmojiReplyText("button.cat.shelter", CAT));
        InlineKeyboardButton buttonDogShelter = new InlineKeyboardButton(
                replyMessagesService.getEmojiReplyText("button.dog.shelter", DOG));
        buttonCatShelter.setCallbackData("/catsShelterMenu");
        buttonDogShelter.setCallbackData("/dogsShelterMenu");

        buttons.add(buttonCatShelter);
        buttons.add(buttonDogShelter);

        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(buttons);

        final ReplyKeyboard replyKeyboard = new InlineKeyboardMarkup(keyboard);

        return replyKeyboard;
    }


    private SendMessage createMessageWithKeyboard(final String chatId,
                                                  String textMessage,
                                                  final ReplyKeyboard keyboard) {
        final SendMessage sendMessage = new SendMessage(chatId, textMessage);
        if (keyboard != null) {
            sendMessage.setReplyMarkup(keyboard);
        }
        return sendMessage;
    }



}
