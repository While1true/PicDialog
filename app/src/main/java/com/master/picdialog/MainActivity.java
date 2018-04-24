package com.master.picdialog;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.master.piclib.PicDialog;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private PicDialog picDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView viewById = findViewById(R.id.image);
        show(viewById, savedInstanceState);
        viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                picDialog.show(getSupportFragmentManager(), "PicDialog");
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (picDialog != null && picDialog.isAdded())
            getSupportFragmentManager().putFragment(outState, "PicDialog", picDialog);
    }

    private void show(final ImageView viewById, Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            picDialog = (PicDialog) getSupportFragmentManager().getFragment(savedInstanceState, "PicDialog");
        }
        if (picDialog == null) {
            picDialog = new PicDialog();
        }
        picDialog.setListener(new PicDialog.ResultListener() {
            @Override
            public void onResult(String result) {
                viewById.setImageURI(Uri.fromFile(new File(result)));
            }
        });

    }
}
