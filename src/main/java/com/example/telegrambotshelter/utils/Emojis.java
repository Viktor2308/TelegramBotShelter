package com.example.telegrambotshelter.utils;
import com.vdurmont.emoji.EmojiParser;
import lombok.AllArgsConstructor;



@AllArgsConstructor
public enum Emojis {
    SMILE(EmojiParser.parseToUnicode(":blush:")),
    TRUMBSUP(EmojiParser.parseToUnicode(":thumbsup:")),
    CAT(EmojiParser.parseToUnicode(":cat2:")),
    CAT_1(EmojiParser.parseToUnicode(":cat:")),
    DOG(EmojiParser.parseToUnicode(":dog2:")),
    DOG_1(EmojiParser.parseToUnicode(":dog:")),
    ROBOT_FACE(EmojiParser.parseToUnicode(":robot_face:")),
    MALE_STUDENT(EmojiParser.parseToUnicode(":male_student:")),
    INFORMATION_SOURCE(EmojiParser.parseToUnicode(":information_source:")),
    COMPASS(EmojiParser.parseToUnicode(":compass:")),
    AUTOMOBILE(EmojiParser.parseToUnicode(":oncoming_automobile:")),
    PAGE_FACING_UP(EmojiParser.parseToUnicode(":page_facing_up:")),
    BICYCLIST(EmojiParser.parseToUnicode(":bicyclist:")),
    CLOCK_3(EmojiParser.parseToUnicode(":clock3:")),
    ARROW_DOUBLE(EmojiParser.parseToUnicode(":arrow_double_down:")),
    TELEPHONE_RECEIVER(EmojiParser.parseToUnicode(":telephone_receiver:"));

    private final String emojiName;

    @Override
    public String toString() {
        return emojiName;
    }
}
