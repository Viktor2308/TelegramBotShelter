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
public class CatsShelterMenuQueryService {

    private final ReplyMessagesService replyMessagesService;

    public CatsShelterMenuQueryService(ReplyMessagesService replyMessagesService) {
        this.replyMessagesService = replyMessagesService;
    }

    public SendMessage getCatsShelterMenuQuery(long chatId) {

        final ReplyKeyboard keyboard = getMainMenuKeyboard();
        return createMessageWithKeyboard(chatId
                , replyMessagesService.getEmojiReplyText("reply.CatShelterMenu.message", CAT)
                , keyboard);
    }

    private ReplyKeyboard getMainMenuKeyboard() {

        List<InlineKeyboardButton> buttons1 = new ArrayList<>();
        List<InlineKeyboardButton> buttons2 = new ArrayList<>();
        List<InlineKeyboardButton> buttons3 = new ArrayList<>();
        List<InlineKeyboardButton> buttons4 = new ArrayList<>();

        InlineKeyboardButton buttonCatMenuInfo = new InlineKeyboardButton(
                replyMessagesService.getEmojiReplyText("button.catMenu.info.shelter", INFORMATION_SOURCE));
        InlineKeyboardButton buttonCatMenuTakeCat = new InlineKeyboardButton(
                replyMessagesService.getEmojiReplyText("button.catMenu.takeCat.shelter", CAT));
        InlineKeyboardButton buttonCatMenuSendInfoCat = new InlineKeyboardButton(
                replyMessagesService.getEmojiReplyText("button.catMenu.sendInfoAboutCat.shelter", CAT_1));
        InlineKeyboardButton buttonMenuVolunteer = new InlineKeyboardButton(
                replyMessagesService.getEmojiReplyText("button.menu.volunteer.shelter", BLUE_CAR));

        buttonCatMenuInfo.setCallbackData("/InfoCatChelter");
        buttonCatMenuTakeCat.setCallbackData("/TakeCat");
        buttonCatMenuSendInfoCat.setCallbackData("/SendReportAboutHomeCat");
        buttonMenuVolunteer.setCallbackData("/CallVolunteer");

        buttons1.add(buttonCatMenuInfo);
        buttons2.add(buttonCatMenuTakeCat);
        buttons3.add(buttonCatMenuSendInfoCat);
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
