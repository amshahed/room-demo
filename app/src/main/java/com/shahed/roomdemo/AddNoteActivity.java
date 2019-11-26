package com.shahed.roomdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

public class AddNoteActivity extends AppCompatActivity {
    private EditText title, description;
    private NumberPicker priority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        priority = findViewById(R.id.priorityPicker);
        priority.setMinValue(1);
        priority.setMaxValue(10);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.icon_close);
        setTitle("Add Note");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_note_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.save){
            saveNote();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void saveNote(){
        String t = title.getText().toString().trim();
        String d = description.getText().toString().trim();
        int p = priority.getValue();

        if (t.isEmpty() || d.isEmpty()){
            Toast.makeText(this, "Please insert title and description", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent data = new Intent();
        data.putExtra("title", t);
        data.putExtra("description", d);
        data.putExtra("priority", p);
        setResult(RESULT_OK, data);
        finish();
    }
}
