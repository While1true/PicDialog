package com.master.picdialog;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.master.piclib.PicDialog;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView viewById = findViewById(R.id.image);
        show(viewById);
        viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(viewById);
            }
        });
    }

    private void show(final ImageView viewById) {
        new PicDialog().setListener(new PicDialog.ResultListener() {
            @Override
            public void onResult(String result) {

                viewById.setImageURI(Uri.fromFile(new File(result)));
            }
        }).show(getSupportFragmentManager(),"xx");
    }
}
