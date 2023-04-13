package com.example.telegrambotshelter.service;

import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.List;

public interface ReplyCallbackQueryService {

    List<PartialBotApiMethod<Message>> replayMessage(long chatId);

}
