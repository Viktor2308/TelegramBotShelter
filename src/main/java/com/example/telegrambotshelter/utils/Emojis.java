package com.example.telegrambotshelter.utils;
import com.vdurmont.emoji.EmojiParser;
import lombok.AllArgsConstructor;



@AllArgsConstructor
public enum Emojis {
    CRY(EmojiParser.parseToUnicode(":cry:")),
    CAT(EmojiParser.parseToUnicode(":cat2:")),
    CAT_1(EmojiParser.parseToUnicode(":cat:")),
    DOG(EmojiParser.parseToUnicode(":dog2:")),
    DOG_1(EmojiParser.parseToUnicode(":dog:")),
    ROBOT_FACE(EmojiParser.parseToUnicode(":robot_face:")),
    MALE_STUDENT(EmojiParser.parseToUnicode(":male_student:")),
    BLUE_CAR(EmojiParser.parseToUnicode(":blue_car:")),
    INFORMATION_SOURCE(EmojiParser.parseToUnicode(":information_source:")),
    NOTIFICATION_PRICE_DOWN(EmojiParser.parseToUnicode(":chart_with_downwards_trend:")),
    HELP_MENU_WELCOME(EmojiParser.parseToUnicode(":hatched_chick:"));

    private final String emojiName;

    @Override
    public String toString() {
        return emojiName;
    }
}
