package org.saucedemo.enums;

public enum AppMenu {
    All_ITEMS ("All Items"),
    ABOUT ("About"),
    LOGOUT ("Logout"),
    REST_APP_STATE ("Reset App State");

    private String menu;

    AppMenu(String menu) {
        this.menu = menu;
    }

    public String value() {
        return menu;
    }
}
