package com.example.telegrambotshelter.service;

import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.List;

public interface ReplyTextService {

    List<PartialBotApiMethod<Message>> replayMessage(Message inputMessage);

}
