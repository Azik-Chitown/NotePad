package edu.depaul.notepad;
import android.view.View;

import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView title;
    TextView notetext;
    TextView dateTime;

    MyViewHolder(View v){
        super(v);


    }

}
