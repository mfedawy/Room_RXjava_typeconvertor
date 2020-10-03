package com.echoman.roomcodingwithnerds;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private Button insertBtn, getBtn;
    private EditText titleEt, bodyEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.posts_recyclerView);
        final PostsAdapter postsAdapter = new PostsAdapter();
        mRecyclerView.setAdapter(postsAdapter);

        insertBtn = findViewById(R.id.insertButton);
        getBtn = findViewById(R.id.getButton);

        titleEt = findViewById(R.id.editTexttitle);
        bodyEt = findViewById(R.id.editTextBody);

        final postsDataBase postsDataBase = com.echoman.roomcodingwithnerds.postsDataBase.getInstance(this);


        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postsDataBase.postsDao().insertPost(new Post(new User(1,"mm"), titleEt.getEditableText().toString(), bodyEt.getEditableText().toString()))
                        .subscribeOn(Schedulers.computation())
                        .subscribe(new CompletableObserver() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onComplete() {
//                                Toast.makeText(getApplicationContext(), "completed", Toast.LENGTH_LONG).show();

                            }

                            @Override
                            public void onError(Throwable e) {

                            }
                        });

            }
        });


        getBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postsDataBase.postsDao().getPosts()
                        .subscribeOn(io.reactivex.schedulers.Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new SingleObserver<List<Post>>() {
                            @Override
                            public void onSubscribe(io.reactivex.disposables.Disposable d) {

                            }

                            @Override
                            public void onSuccess(List<Post> posts) {
                                postsAdapter.setList(posts);
                                postsAdapter.notifyDataSetChanged();
                            }

                            @Override
                            public void onError(Throwable e) {

                            }
                        });


            }
        });

    }

}