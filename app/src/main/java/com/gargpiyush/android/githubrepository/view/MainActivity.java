package com.gargpiyush.android.githubrepository.view;

import android.content.pm.ActivityInfo;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gargpiyush.android.githubrepository.R;
import com.gargpiyush.android.githubrepository.util.AlertDialogScreen;

/**
 * Created by Piyush Garg on 3/17/2019 at 21:46.
 */
public class MainActivity extends AppCompatActivity {

    Fragment fragment = new MainFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activityMain, fragment, "MainFragment");
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        new AlertDialogScreen().showAlert(this);
    }
}