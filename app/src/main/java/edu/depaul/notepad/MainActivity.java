package edu.depaul.notepad;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
/*import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;*/
import java.util.ArrayList;
import java.util.List;
import android.view.View;

import android.os.Bundle;
import android.view.Menu;



public class MainActivity extends AppCompatActivity {
    private final List <Note> noteList =new ArrayList<>();
    //private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.add_note, menu);
        return true;
    }
}
