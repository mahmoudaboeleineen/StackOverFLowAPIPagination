package com.maboe.stackoverflowapipagination;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.text.util.Linkify;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@RequiresApi(api = Build.VERSION_CODES.O)
public class UserDetailsActivity extends AppCompatActivity {


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        Objects.requireNonNull(getSupportActionBar()).setTitle("User Details");

        TextView userName = findViewById(R.id.details_userName);
        TextView userEmail = findViewById(R.id.user_email);
        ImageView userImage = findViewById(R.id.details_userImage);
        TextView userScore = findViewById(R.id.details_userScore);
        TextView userReputation = findViewById(R.id.details_userReputation);
        TextView userAcceptRate = findViewById(R.id.details_userAcceptrate);
        TextView userLastActivityDate = findViewById(R.id.userLastActivityDate);
        TextView userCreationDate = findViewById(R.id.details_userCreationDate);
        TextView userEditDate = findViewById(R.id.details_userEditDate);

        String name = Objects.requireNonNull(getIntent().getExtras()).getString("userName");
        userName.setText(name);

        String email = getIntent().getExtras().getString("userEmail");
        userEmail.setText(email);
        Linkify.addLinks(userEmail, Linkify.WEB_URLS);

        String avatarUrl = getIntent().getExtras().getString("userImage");
        Glide.with(UserDetailsActivity.this)
                .load(avatarUrl)
                .into(userImage);

        int score = getIntent().getIntExtra("score", 0);
        userScore.setText(String.valueOf(score));

        String rate = getIntent().getExtras().getString("acceptRate");
        if (rate == null) {
            userAcceptRate.setText("0");
        } else {
            userAcceptRate.setText(rate);
        }

        String reputation = getIntent().getExtras().getString("reputation");
        userReputation.setText(reputation);

        long lastDate = getIntent().getLongExtra("lastDate", 0);
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM dd, yyyy - HH:mm:ss a");
        sdf.format(new Date(lastDate * 1000L));
        String textLastDate = sdf.format(lastDate * 1000L);
        userLastActivityDate.setText(textLastDate);

        long editDate = getIntent().getLongExtra("editDate", 0);
        sdf.format(new Date(editDate * 1000L));
        String textEditDate = sdf.format(editDate * 1000L);
        if (textEditDate.equals("Thu, Jan 01, 1970 - 02:00:00 am")) {
            userEditDate.setText("Sorry! Un Defined Date.");
        } else {
            userEditDate.setText(textEditDate);
        }
        Log.d("editDate", sdf.format(editDate * 1000L));


        long creationDate = getIntent().getLongExtra("creationDate", 0);
        sdf.format(new Date(creationDate * 1000L));
        String textCreationDate = sdf.format(creationDate * 1000L);
        userCreationDate.setText(textCreationDate);
    }
}

