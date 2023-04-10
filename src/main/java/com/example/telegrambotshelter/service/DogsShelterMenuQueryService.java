package com.example.telegrambotshelter.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

import static com.example.telegrambotshelter.utils.Emojis.*;
import static com.example.telegrambotshelter.utils.Emojis.BLUE_CAR;

@Service
public class DogsShelterMenuQueryService {

  private final   ReplyMessagesService replyMessagesService;

    public DogsShelterMenuQueryService(ReplyMessagesService replyMessagesService) {
        this.replyMessagesService = replyMessagesService;
    }

    public SendMessage getDogsShelterMenuQuery(long chatId) {

        final ReplyKeyboard keyboard = getMainMenuKeyboard();
        return createMessageWithKeyboard(chatId
                , replyMessagesService.getEmojiReplyText("reply.DogShelterMenu.message",DOG)
                , keyboard);
    }

    private ReplyKeyboard getMainMenuKeyboard() {

        List<InlineKeyboardButton> buttons1 = new ArrayList<>();
        List<InlineKeyboardButton> buttons2 = new ArrayList<>();
        List<InlineKeyboardButton> buttons3 = new ArrayList<>();
        List<InlineKeyboardButton> buttons4 = new ArrayList<>();

        InlineKeyboardButton buttonDogMenuInfo = new InlineKeyboardButton(
                replyMessagesService.getEmojiReplyText("button.dogMenu.info.shelter", INFORMATION_SOURCE));
        InlineKeyboardButton buttonDogMenuTakeDog = new InlineKeyboardButton(
                replyMessagesService.getEmojiReplyText("button.dogMenu.takeDog.shelter",DOG));
        InlineKeyboardButton buttonDogMenuSendInfoDog = new InlineKeyboardButton(
                replyMessagesService.getEmojiReplyText("button.dogMenu.sendInfoAboutDog.shelter", DOG_1));
        InlineKeyboardButton buttonMenuVolunteer = new InlineKeyboardButton(
                replyMessagesService.getEmojiReplyText("button.menu.volunteer.shelter", BLUE_CAR));

        buttonDogMenuInfo.setCallbackData("/InfoDogShelter");
        buttonDogMenuTakeDog.setCallbackData("/TakeDog");
        buttonDogMenuSendInfoDog.setCallbackData("/SendReportAboutHomeDog");
        buttonMenuVolunteer.setCallbackData("/CallVolunteer");

        buttons1.add(buttonDogMenuInfo);
        buttons2.add(buttonDogMenuTakeDog);
        buttons3.add(buttonDogMenuSendInfoDog);
        buttons4.add(buttonMenuVolunteer);

        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(buttons1);
        keyboard.add(buttons2);
        keyboard.add(buttons3);
        keyboard.add(buttons4);

        return new InlineKeyboardMarkup(keyboard);
    }


    private SendMessage createMessageWithKeyboard(final long chatId, String textMessage, final ReplyKeyboard keyboard) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(textMessage);
        sendMessage.setChatId(chatId);
        if (keyboard != null) {
            sendMessage.setReplyMarkup(keyboard);
        }
        return sendMessage;
    }

}
