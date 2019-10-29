package edu.depaul.notepad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;


import java.util.ArrayList;
import java.util.List;

import android.view.MenuItem;
import android.view.View;

import android.os.Bundle;
import android.view.Menu;



public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {
    private final ArrayList<Note> noteList = new ArrayList<>();
    private static final int CODE_FOR_NEW_ACTIVITY = 111;
    private RecyclerView recyclerView;
    NoteAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler);
        mAdapter = new NoteAdapter(noteList, this);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        
       
      // createFromAcivity();

        makeList();

    }
    
    private void createFromAcivity(){

        Intent intent =getIntent();
        if (intent.hasExtra("USER TITLE")){

            Note a =new Note(intent.getStringExtra("USER TITLE"),intent.getStringExtra("USER TEXT"));
            noteList.add(a);}
    }

    private void makeList() {
        for (int i = 0; i < 4; i++) {
            Note a = new Note("Title", "something something blah blah cdsf gbe m jncvdf vjhf dvkd k vmf vjkrfdnfemfker jkb vrfvk");
            noteList.add(a);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_note, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about_item:
                Intent intent = new Intent(this, FullscreenActivity.class);
                startActivity(intent);
                return true;
            case R.id.addNoteMenuItem:
                Intent intent1 = new Intent(this, NewNoteActivity.class);
                startActivityForResult(intent1,CODE_FOR_NEW_ACTIVITY);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View view) { // I dont know we need it. if i comment it out, it is not compiling
        int pos = recyclerView.getChildAdapterPosition(view);
        Note select = noteList.get(pos);


    }

    @Override
    public boolean onLongClick(View view) {
        int pos = recyclerView.getChildAdapterPosition(view);
        Note select = noteList.get(pos);
        noteList.remove(select);
        mAdapter.notifyDataSetChanged();
        return true;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode, data);
       if (requestCode==CODE_FOR_NEW_ACTIVITY) {
           if (resultCode == RESULT_OK) {

               if (data.hasExtra("USER TITLE")&&data.hasExtra("USER TEXT")){
                   Note a = new Note(data.getStringExtra("USER TITLE"), data.getStringExtra("USER TEXT"));
                   noteList.add(a);


               }
               }

           }
       }
    }

