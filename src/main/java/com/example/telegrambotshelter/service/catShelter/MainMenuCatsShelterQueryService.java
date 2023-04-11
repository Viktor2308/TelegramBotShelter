package com.example.telegrambotshelter.service.catShelter;

import com.example.telegrambotshelter.service.ReplyMessagesService;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

import static com.example.telegrambotshelter.utils.Emojis.*;

@Service
public class MainMenuCatsShelterQueryService {

    private final ReplyMessagesService replyMessagesService;

    public MainMenuCatsShelterQueryService(ReplyMessagesService replyMessagesService) {
        this.replyMessagesService = replyMessagesService;
    }

    public List<PartialBotApiMethod<Message>> getCatsShelterMenuQuery(long chatId) {
        List<PartialBotApiMethod<Message>> partialBotApiMethodsList = new ArrayList<>();
        final ReplyKeyboard keyboard = getMainMenuKeyboard();
        partialBotApiMethodsList.add(createMessageWithKeyboard(chatId
                , replyMessagesService.getEmojiReplyText("reply.сat.shelter.menu.message", CAT)
                , keyboard));
        return partialBotApiMethodsList;
    }

    private ReplyKeyboard getMainMenuKeyboard() {

        List<InlineKeyboardButton> buttons1 = new ArrayList<>();
        List<InlineKeyboardButton> buttons2 = new ArrayList<>();
        List<InlineKeyboardButton> buttons3 = new ArrayList<>();
        List<InlineKeyboardButton> buttons4 = new ArrayList<>();

        InlineKeyboardButton buttonCatMenuInfo = new InlineKeyboardButton(
                replyMessagesService.getEmojiReplyText("button.cat.menu.info.shelter", INFORMATION_SOURCE));
        InlineKeyboardButton buttonCatMenuTakeCat = new InlineKeyboardButton(
                replyMessagesService.getEmojiReplyText("button.cat.menu.takeCat.shelter", CAT));
        InlineKeyboardButton buttonCatMenuSendInfoCat = new InlineKeyboardButton(
                replyMessagesService.getEmojiReplyText("button.cat.menu.sendInfoAboutCat.shelter", CAT_1));
        InlineKeyboardButton buttonMenuVolunteer = new InlineKeyboardButton(
                replyMessagesService.getEmojiReplyText("button.menu.volunteer.shelter", BICYCLIST));

        buttonCatMenuInfo.setCallbackData("/INFO_MENU_CAT_SHELTER");
        buttonCatMenuTakeCat.setCallbackData("/TAKE_CAT");
        buttonCatMenuSendInfoCat.setCallbackData("/SEND_REPORT_CAT");
        buttonMenuVolunteer.setCallbackData("/CALL_VOLUNTEER");

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