 package lut.bipika.easynotesbook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;

 public class AddNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        final EditText titleInput=findViewById(R.id.titleinput);
        final EditText descriptionInput=findViewById(R.id.descriptioninput);

        Button  saveBtn=findViewById(R.id.saveBtn);

        Realm.init((getApplicationContext()));
        final Realm realm=Realm.getDefaultInstance();

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title=titleInput.getText().toString();
                String description=descriptionInput.getText().toString();
                long createdTime=System.currentTimeMillis();

                realm.beginTransaction();
                Note note =realm.createObject(Note.class);
                note.setTitle(title);
                note.setDescription(description);
                note.setCreatedTime(createdTime);
                realm.commitTransaction();
                Toast.makeText(getApplicationContext(),"Note Saved", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}