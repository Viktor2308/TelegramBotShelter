package com.example.telegrambotshelter.handlerMain;

import java.util.LinkedHashMap;
import java.util.Map;

public enum BotState {
    SHOW_MAIN_MENU("/start"),
    SHOW_INFO_MENU("/info"),
    CALL_VOLUNTEER("/CALL_VOLUNTEER"),
    SHOW_CAT_SHELTER_MENU("/SHOW_CAT_SHELTER_MENU"),
    SHOW_DOG_SHELTER_MENU("/SHOW_DOG_SHELTER_MENU"),
    INFO_CAT_SHELTER("/INFO_CAT_SHELTER"),
    INFO_DOG_SHELTER("/INFO_DOG_SHELTER"),
    TAKE_DOG("/TAKE_DOG"),
    TAKE_CAT("/TAKE_CAT"),
    SEND_REPORT_CAT("/SEND_REPORT_CAT"),
    SEND_REPORT_DOG("/SEND_REPORT_DOG"),
    CAT_SHELTER_SECURITY("/CAT_SHELTER_SECURITY"),
    DOG_SHELTER_SECURITY("/DOG_SHELTER_SECURITY"),
    INFO_MENU_CAT_SHELTER("/INFO_MENU_CAT_SHELTER"),
    INFO_MENU_DOG_SHELTER("/INFO_MENU_DOG_SHELTER"),
    CAT_SHELTER_ADDRESS("/CAT_SHELTER_ADDRESS"),
    DOG_SHELTER_ADDRESS("/DOG_SHELTER_ADDRESS"),
    DOG_SHELTER_RULES("/DOG_SHELTER_RULES"),
    CAT_SHELTER_RULES("/CAT_SHELTER_RULES"),
    CALL_BACK_CAT_SHELTER("/CALL_BACK_CAT_SHELTER"),
    CALL_BACK_DOG_SHELTER("/CALL_BACK_DOG_SHELTER"),
    VALIDATE_PHONE("/VALIDATE_PHONE");

    private static final Map<String, BotState> STATE_MAP;

    static {
        STATE_MAP = new LinkedHashMap<>();
        for (BotState botState : values()) {
            STATE_MAP.put(botState.state, botState);
        }
    }

    private final String state;

    BotState(String state) {
        this.state = state;
    }

    public static Map<String, BotState> getBotStateMap() {
        return STATE_MAP;
    }
}
