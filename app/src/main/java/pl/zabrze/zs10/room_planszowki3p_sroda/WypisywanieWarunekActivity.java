package pl.zabrze.zs10.room_planszowki3p_sroda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class WypisywanieWarunekActivity extends AppCompatActivity {

    Button button;
    EditText editText;
    ListView listView;
    List<Planszowka> planszowki;
    ArrayAdapter<Planszowka> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wypisywanie_warunek);
        PlanszowkiDatabase db = PlanszowkiDatabase.zwrocInstancje(
                getApplicationContext()
        );
        button = findViewById(R.id.button2);
        editText = findViewById(R.id.editTextTextPersonName2);
        listView = findViewById(R.id.listView);
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int liczbaGraczy = Integer.valueOf(editText.getText().toString());
                        planszowki = db.uzyjPlanszowkiDao().planszowkiWedlugLiczbyGraczy(liczbaGraczy);
                        adapter = new ArrayAdapter<>(
                                getApplicationContext(),
                                android.R.layout.simple_list_item_1,
                                planszowki
                        );
                        listView.setAdapter(adapter);

                    }
                }
        );
    }
}