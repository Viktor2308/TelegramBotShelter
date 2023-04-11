package com.example.telegrambotshelter.service.dogShelter;

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
import static com.example.telegrambotshelter.utils.Emojis.BICYCLIST;

@Service
public class InfoMenuDogShelterQueryService {
    private final ReplyMessagesService replyMessagesService;

    public InfoMenuDogShelterQueryService(ReplyMessagesService replyMessagesService) {
        this.replyMessagesService = replyMessagesService;
    }

    public List<PartialBotApiMethod<Message>> getInfoDogShelter(long chatId) {
        List<PartialBotApiMethod<Message>> infoMenuDogList = new ArrayList<>();
        final ReplyKeyboard keyboard = getMainMenuKeyboard();
        final SendMessage infoMenuCat =
                createMessageWithKeyboard(Long.toString(chatId)
                        , replyMessagesService.getReplyText("reply.info.menu.dog.shelter.message")
                        , keyboard);
        infoMenuDogList .add(infoMenuCat);

        return infoMenuDogList;

    }


    private ReplyKeyboard getMainMenuKeyboard() {

        List<InlineKeyboardButton> buttons1 = new ArrayList<>();
        List<InlineKeyboardButton> buttons2 = new ArrayList<>();
        List<InlineKeyboardButton> buttons3 = new ArrayList<>();
        List<InlineKeyboardButton> buttons4 = new ArrayList<>();
        List<InlineKeyboardButton> buttons5 = new ArrayList<>();
        List<InlineKeyboardButton> buttons6 = new ArrayList<>();
        InlineKeyboardButton buttonDogInfo = new InlineKeyboardButton(
                replyMessagesService.getEmojiReplyText("button.info.dog.shelter.info", INFORMATION_SOURCE));
        InlineKeyboardButton buttonDogAddress = new InlineKeyboardButton(
                replyMessagesService.getEmojiReplyText("button.info.dog.shelter.address", COMPASS));
        InlineKeyboardButton buttonDogSecurity = new InlineKeyboardButton(
                replyMessagesService.getEmojiReplyText("button.info.dog.shelter.security", AUTOMOBILE));
        InlineKeyboardButton buttonDogInstruction = new InlineKeyboardButton(
                replyMessagesService.getEmojiReplyText("button.info.dog.shelter.instruction", PAGE_FACING_UP));
        InlineKeyboardButton buttonDogContacts = new InlineKeyboardButton(
                replyMessagesService.getEmojiReplyText("button.info.dog.shelter.contacts", TELEPHONE_RECEIVER));
        InlineKeyboardButton buttonMenuVolunteer = new InlineKeyboardButton(
                replyMessagesService.getEmojiReplyText("button.menu.volunteer.shelter", BICYCLIST));
        buttonDogInfo.setCallbackData("/INFO_DOG_SHELTER");
        buttonDogAddress.setCallbackData("/DOG_SHELTER_ADDRESS");
        buttonDogSecurity.setCallbackData("/DOG_SHELTER_SECURITY");
        buttonDogInstruction.setCallbackData("/DOG_SHELTER_RULES");
        buttonDogContacts.setCallbackData("/CALL_BACK_DOG_SHELTER");
        buttonMenuVolunteer.setCallbackData("/CALL_VOLUNTEER");
        buttons1.add(buttonDogInfo);
        buttons2.add(buttonDogAddress);
        buttons3.add( buttonDogSecurity);
        buttons4.add(buttonDogInstruction);
        buttons5.add(buttonDogContacts);
        buttons6.add(buttonMenuVolunteer);
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(buttons1);
        keyboard.add(buttons2);
        keyboard.add(buttons3);
        keyboard.add(buttons4);
        keyboard.add(buttons5);
        keyboard.add(buttons6);
        return new InlineKeyboardMarkup(keyboard);
    }

    private SendMessage createMessageWithKeyboard(final String chatId, String textMessage, final ReplyKeyboard keyboard) {
        final SendMessage sendMessage = new SendMessage(chatId, textMessage);
        if (keyboard != null) {
            sendMessage.setReplyMarkup(keyboard);
        }
        return sendMessage;
    }
}
