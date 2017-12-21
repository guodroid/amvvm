package com.cloudtech.ads.utils;

public enum RequestMethod {

    GET("GET"),

    POST("POST");

    private final String value;


    RequestMethod(String value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return this.value;
    }
}