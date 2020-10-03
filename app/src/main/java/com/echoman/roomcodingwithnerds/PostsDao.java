package com.echoman.roomcodingwithnerds;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;


@Dao
interface PostsDao {
    @Insert
    Completable insertPost(Post post);

    @Query("select * from posts_table")
    Single<List<Post>> getPosts();

//    @Query("select id from posts_table")
//    List<Post> getId();
//    @Query("select userId from posts_table")
//    List<Post> getUserId();
//    @Query("select * from posts_table where userId= 5 ")
//    List<Post> getPostsfromUser(int x);

}
