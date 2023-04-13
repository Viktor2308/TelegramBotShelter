package com.example.telegrambotshelter.service.inputCallbackQueryServiceImpl;

import com.example.telegrambotshelter.service.ReplyCallbackQueryService;
import com.example.telegrambotshelter.service.locale.ReplyMessagesService;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class InfoMenuCatShelterQueryService implements ReplyCallbackQueryService {

    private final ReplyMessagesService replyMessagesService;

    @Override
    public List<PartialBotApiMethod<Message>> replayMessage(long chatId) {
        List<PartialBotApiMethod<Message>> infoMenuCatList = new ArrayList<>();
        final ReplyKeyboard keyboard = getMainMenuKeyboard();
        final SendMessage infoMenuCat =
                createMessageWithKeyboard(Long.toString(chatId)
                        , replyMessagesService.getReplyText("reply.info.menu.cat.shelter.message")
                        , keyboard);
        infoMenuCatList .add(infoMenuCat);

        return infoMenuCatList;

    }


    private ReplyKeyboard getMainMenuKeyboard() {

        List<InlineKeyboardButton> buttons1 = new ArrayList<>();
        List<InlineKeyboardButton> buttons2 = new ArrayList<>();
        List<InlineKeyboardButton> buttons3 = new ArrayList<>();
        List<InlineKeyboardButton> buttons4 = new ArrayList<>();
        List<InlineKeyboardButton> buttons5 = new ArrayList<>();
        List<InlineKeyboardButton> buttons6 = new ArrayList<>();
        InlineKeyboardButton buttonCatInfo = new InlineKeyboardButton(
                replyMessagesService.getEmojiReplyText("button.info.cat.shelter.info", INFORMATION_SOURCE));
        InlineKeyboardButton buttonCatAddress = new InlineKeyboardButton(
                replyMessagesService.getEmojiReplyText("button.info.cat.shelter.address", COMPASS));
        InlineKeyboardButton buttonCatSecurity = new InlineKeyboardButton(
                replyMessagesService.getEmojiReplyText("button.info.cat.shelter.security", AUTOMOBILE));
        InlineKeyboardButton buttonCatInstruction = new InlineKeyboardButton(
                replyMessagesService.getEmojiReplyText("button.info.cat.shelter.instruction", PAGE_FACING_UP));
        InlineKeyboardButton buttonCatContacts = new InlineKeyboardButton(
                replyMessagesService.getEmojiReplyText("button.info.cat.shelter.contacts", TELEPHONE_RECEIVER));
        InlineKeyboardButton buttonMenuVolunteer = new InlineKeyboardButton(
                replyMessagesService.getEmojiReplyText("button.menu.volunteer.shelter", BICYCLIST));
        buttonCatInfo.setCallbackData("/INFO_CAT_SHELTER");
        buttonCatAddress.setCallbackData("/CAT_SHELTER_ADDRESS");
        buttonCatSecurity.setCallbackData("/CAT_SHELTER_SECURITY");
        buttonCatInstruction.setCallbackData("/CAT_SHELTER_RULES");
        buttonCatContacts.setCallbackData("/CALL_BACK_CAT_SHELTER");
        buttonMenuVolunteer.setCallbackData("/CALL_VOLUNTEER");
        buttons1.add(buttonCatInfo);
        buttons2.add(buttonCatAddress);
        buttons3.add( buttonCatSecurity);
        buttons4.add(buttonCatInstruction);
        buttons5.add(buttonCatContacts);
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
