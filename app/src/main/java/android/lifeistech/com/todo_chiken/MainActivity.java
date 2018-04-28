package android.lifeistech.com.todo_chiken;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.HashMap;
import java.util.HashSet;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter<String> adapter;
    ListView listView;
    SharedPreferences pref;
    HashMap<String, String> keyMap;

    //keyの変数
    String keyTitle;
    String keyContent;
    //String keyBoolean;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);


        pref = getSharedPreferences("pref_new", MODE_PRIVATE);

        keyMap = new HashMap<String, String>();

        /*
        //TODO:prefのキーに、String型の変数って使えないの？どこがおかしい？
        if (common.pref.getString(common.titleText, null) != null) {
            common.adapter.add(common.pref.getString(common.titleText, null));
        }*/

        adapter.add(keyTitle);
        listView.setAdapter(adapter);
    }

    @Override
    protected void onResume(){
        //setを更新
        super.onResume();

        keyMap.put(keyTitle, keyTitle);
    }


    public void plus(View v) {

        //adapter.add("あああああ");
        //common.adapter.add(common.pref.getString(common.titleText, ""));


        Intent intent = new Intent(this, NewActivity.class);
        startActivity(intent);
    }
}
