package android.lifeistech.com.todo_chiken;

public class Card {
    public boolean check;
    public String title;
    public String content;

    public Card(boolean check, String title, String content){
        this.check = check;

        //合ってる？
        this.check = false;

        this.title = title;
        this.content = content;
    }

}
