package edu.depaul.notepad;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private ArrayList<Note> lst;
    MainActivity mainAct;

    NoteAdapter(ArrayList<Note> aList){
        lst=aList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.note_list_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Note selection=lst.get(position);
        holder.title.setText(selection.getTitle());
        holder.notetext.setText(selection.getNoteText());
        holder.dateTime.setText("Created on" +selection.getTime());

    }

    @Override
    public int getItemCount() {
        return lst.size();
    }
}
