package com.echoman.roomcodingwithnerds;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = Post.class,version = 1)
@TypeConverters(Convertor.class)
abstract class postsDataBase extends RoomDatabase {
    private static postsDataBase instance;

    public abstract PostsDao postsDao();


    public static synchronized postsDataBase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    postsDataBase.class, "Posts_database")
                    .build();
        }
        return instance;
    }




}
