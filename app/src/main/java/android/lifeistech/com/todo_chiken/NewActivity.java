package android.lifeistech.com.todo_chiken;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.HashSet;

public class NewActivity extends AppCompatActivity {

    SharedPreferences pref;
    EditText titleEditText;
    EditText contentEditText;
    String titleText;
    String contentText;

    //keyの変数
    String keyTitle;
    String keyContent;
    //String keyBoolean;


    HashMap<String, String> keyMap = new HashMap<String, String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        titleEditText = (EditText) findViewById(R.id.newTitle);
        contentEditText = (EditText) findViewById(R.id.newContent);

        pref = getSharedPreferences("pref_new", MODE_PRIVATE);
    }


    public void add(View v) {
        titleText = titleEditText.getText().toString();
        contentText = contentEditText.getText().toString();

        keyTitle = titleText;
        keyContent = contentText;

        //TODO:Booleanのこれ、どうするの？
        //keyBoolean = titleEditText.getText().toString();

        keyMap.put(keyTitle, titleText);
        keyMap.put(keyContent, contentText);
        //keySet.add(keyBoolean);

        SharedPreferences.Editor editor = pref.edit();
        editor.putString(keyTitle, titleText);
        editor.putString(keyContent, contentText);
        //editor.putString(keyBoolean, );
        editor.commit();

        Toast.makeText(this, "追加しました", Toast.LENGTH_SHORT).show();

        finish();
    }
}
