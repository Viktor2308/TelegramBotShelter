package com.example.telegrambotshelter.utils;
import com.vdurmont.emoji.EmojiParser;
import lombok.AllArgsConstructor;



@AllArgsConstructor
public enum Emojis {
    CRY(EmojiParser.parseToUnicode(":cry:")),
    CAT(EmojiParser.parseToUnicode(":cat2:")),
    DOG(EmojiParser.parseToUnicode(":dog2:")),
    NOTIFICATION_PRICE_UP(EmojiParser.parseToUnicode(":chart_with_upwards_trend:")),
    NOTIFICATION_PRICE_DOWN(EmojiParser.parseToUnicode(":chart_with_downwards_trend:")),
    HELP_MENU_WELCOME(EmojiParser.parseToUnicode(":hatched_chick:"));

    private String emojiName;

    @Override
    public String toString() {
        return emojiName;
    }
}
