package android.lifeistech.com.todo_chiken;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class CardAdapter extends ArrayAdapter<Card> {
    List<Card> mCards;
    SharedPreferences pref;
    String keyTitle;
    String keyContent;

    HashMap<String, String> keyMap = new HashMap<String, String>();


    public CardAdapter(Context context, int layoutResourceId, List<Card> objects) {
        super(context, layoutResourceId, objects);

        mCards = objects;
    }

    @Override
    public int getCount() {
        return mCards.size();
    }

    @Override
    public Card getItem(int position) {
        return mCards.get(position);
    }

    public static class ViewHolder{
        TextView titleText;
        CheckBox checkBox;

        public ViewHolder(View view){
            titleText = (TextView) view.findViewById(R.id.titleText);
            checkBox = (CheckBox)view.findViewById(R.id.checkBox);
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.card, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //TODO:この辺に、onClickで画面遷移するものもつくらないといけない

        pref = getContext().getSharedPreferences("pref_new", MODE_PRIVATE);


        final Card item = getItem(position);


        /*Setの要素を取り出したい
        for (String word : keySet){
            if(item != null){
                viewHolder.titleText.setText(pref.getString(word, null));
            }
        }*/

        if(item != null){
            viewHolder.titleText.setText(pref.getString(keyMap.get(keyTitle), null));

            /*
            if(){
                viewHolder.checkBox.
            }
            viewHolder.titleText.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    Intent intent = new Intent(this, DetailActivity.class);
                    startActivity(intent);
                }
            });

            layoutが押されたら、詳細のところに遷移するのができない。
            viewHolder.layout.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    Toast.makeText(getContext(), item.meaning, Toast.LENGTH_SHORT).show();
                }
            });*/

        }
        return convertView;
    }



}
