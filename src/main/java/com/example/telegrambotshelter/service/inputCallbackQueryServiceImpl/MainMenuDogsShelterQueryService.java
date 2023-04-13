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
public class MainMenuDogsShelterQueryService implements ReplyCallbackQueryService {

  private final ReplyMessagesService replyMessagesService;

    @Override
    public List<PartialBotApiMethod<Message>> replayMessage(long chatId) {
        List<PartialBotApiMethod<Message>> partialBotApiMethodsList = new ArrayList<>();
        final ReplyKeyboard keyboard = getMainMenuKeyboard();
        partialBotApiMethodsList.add(createMessageWithKeyboard(chatId
                , replyMessagesService.getEmojiReplyText("reply.dog.shelter.menu.message",DOG)
                , keyboard));
        return partialBotApiMethodsList;
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
                replyMessagesService.getEmojiReplyText("button.menu.volunteer.shelter", BICYCLIST));

        buttonDogMenuInfo.setCallbackData("/INFO_MENU_DOG_SHELTER");
        buttonDogMenuTakeDog.setCallbackData("/TAKE_DOG");
        buttonDogMenuSendInfoDog.setCallbackData("/SEND_REPORT_DOG");
        buttonMenuVolunteer.setCallbackData("/CALL_VOLUNTEER");

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


    private SendMessage createMessageWithKeyboard(long chatId, String textMessage, final ReplyKeyboard keyboard) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(textMessage);
        sendMessage.setChatId(chatId);
        if (keyboard != null) {
            sendMessage.setReplyMarkup(keyboard);
        }
        return sendMessage;
    }

}
