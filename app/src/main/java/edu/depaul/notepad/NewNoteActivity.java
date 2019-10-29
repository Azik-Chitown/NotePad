package edu.depaul.notepad;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class NewNoteActivity extends AppCompatActivity {
    private EditText title;
    private EditText textBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title=findViewById(R.id.editTextTitle);
        textBody=findViewById(R.id.editTextNote);
        setContentView(R.layout.new_note_activity);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) // inflating menu items
    {
        getMenuInflater().inflate(R.menu.save_new_note, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){ // save button action, taking title and text body and passing them to main activity
        switch(item.getItemId()){
            case R.id.save_new_note:
                Intent data=new Intent();
                data.putExtra("USER TITLE",title.getText().toString() );
                data.putExtra("USER TEXT", textBody.getText().toString());
                setResult(RESULT_OK,data);
                finish();
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public void onBackPressed() { // title and text are saved on pressing onBack button
        Intent data=new Intent();
        data.putExtra("USER TITLE",title.getText().toString() );
        data.putExtra("USER TEXT", textBody.getText().toString());
        setResult(RESULT_OK,data);
        super.onBackPressed();
    }


}
