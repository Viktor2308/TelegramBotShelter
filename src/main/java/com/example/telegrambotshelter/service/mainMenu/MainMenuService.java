package com.example.telegrambotshelter.service.mainMenu;


import com.example.telegrambotshelter.entity.User;
import com.example.telegrambotshelter.service.ReplyMessagesService;
import com.example.telegrambotshelter.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.example.telegrambotshelter.utils.Emojis.*;

@Slf4j
@Service
public class MainMenuService {

    private final ReplyMessagesService replyMessagesService;
    private final UserService userService;

    public MainMenuService(ReplyMessagesService replyMessagesService, UserService userService) {
        this.replyMessagesService = replyMessagesService;
        this.userService = userService;
    }

    public List<PartialBotApiMethod<Message>> getMainMenuMessage(Message inputMessage) {

        List<PartialBotApiMethod<Message>> mainMenuMessageList = new ArrayList<>();


        if (userService.getUserByChatId(inputMessage.getChatId()) == null) {
            userService.save(new User(inputMessage.getChatId()));
            InputFile inputFile = new InputFile(
                    new File("C:\\Users\\User\\Downloads\\TelegramBotShelter\\src\\main\\resources\\img\\mainMenu.png"));
            SendPhoto sendPhoto = new SendPhoto(inputMessage.getChatId().toString(), inputFile);
            final SendMessage helloUserMessage =
                    new SendMessage(inputMessage.getChatId().toString(),
                            replyMessagesService.getReplyText("reply.newUser.message"));

            mainMenuMessageList.add(sendPhoto);
            mainMenuMessageList.add(helloUserMessage);
        }

        final ReplyKeyboard keyboard = getMainMenuKeyboard();
        final SendMessage mainMenuMessage =
                createMessageWithKeyboard(inputMessage.getChatId().toString()
                        , replyMessagesService.getEmojiReplyText("reply.mainMenu.message", CAT, DOG)
                        , keyboard);
        mainMenuMessageList.add(mainMenuMessage);

        return mainMenuMessageList;
    }

    private ReplyKeyboard getMainMenuKeyboard() {

        List<InlineKeyboardButton> buttons = new ArrayList<>();

        InlineKeyboardButton buttonCatShelter = new InlineKeyboardButton(
                replyMessagesService.getEmojiReplyText("button.cat.shelter", CAT));
        InlineKeyboardButton buttonDogShelter = new InlineKeyboardButton(
                replyMessagesService.getEmojiReplyText("button.dog.shelter", DOG));
        buttonCatShelter.setCallbackData("/SHOW_CAT_SHELTER_MENU");
        buttonDogShelter.setCallbackData("/SHOW_DOG_SHELTER_MENU");

        buttons.add(buttonCatShelter);
        buttons.add(buttonDogShelter);

        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(buttons);

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