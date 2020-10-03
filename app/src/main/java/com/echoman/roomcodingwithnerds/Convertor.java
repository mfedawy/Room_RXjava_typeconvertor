package com.echoman.roomcodingwithnerds;

import androidx.room.TypeConverter;

import com.google.gson.Gson;

class Convertor {
    @TypeConverter
    public String fromUserToGson(User user) {
        return new Gson().toJson(user);
    }

    @TypeConverter
    public User fromGsonToUser(String stringUser) {
        return new Gson().fromJson(stringUser, User.class);
    }


}
