package edu.depaul.notepad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;


import java.util.ArrayList;
import java.util.List;
import android.view.View;

import android.os.Bundle;
import android.view.Menu;



public class MainActivity extends AppCompatActivity {
    private final ArrayList <Note> noteList =new ArrayList<>();
    private RecyclerView recyclerView;
    NoteAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycler);
        mAdapter=new NoteAdapter(noteList);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        makeList();

    }
    private void makeList()
    {
        for (int i=0; i<20; i++)
        {
            Note a =new Note("Title", "something something blah blah");
            noteList.add(a);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.add_note, menu);
        return true;
    }
}
