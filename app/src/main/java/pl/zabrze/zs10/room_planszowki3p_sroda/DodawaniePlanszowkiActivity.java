package pl.zabrze.zs10.room_planszowki3p_sroda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DodawaniePlanszowkiActivity extends AppCompatActivity {

    Button button;
    EditText editTextNazwa;
    EditText editTextMin;
    EditText editTextMax;
    EditText editTextWiek;
    EditText editTextCzas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodawanie_planszowki);
        button = findViewById(R.id.button);
        editTextCzas = findViewById(R.id.editTextNumberCza);
        editTextNazwa = findViewById(R.id.editTextTextPersonName);
        editTextMax = findViewById(R.id.editTextNumberMax);
        editTextMin = findViewById(R.id.editTextNumberMin);
        editTextWiek = findViewById(R.id.editTextNumberWiek);
        PlanszowkiDatabase db = PlanszowkiDatabase.zwrocInstancje(
                getApplicationContext()
        );
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Planszowka planszowka = new Planszowka(
                                editTextNazwa.getText().toString(),
                                Integer.valueOf(editTextMin.getText().toString()),
                                Integer.valueOf(editTextMax.getText().toString()),
                                Integer.valueOf(editTextWiek.getText().toString()),
                                Integer.valueOf(editTextCzas.getText().toString())
                        );
                        db.uzyjPlanszowkiDao().wstawPlanszowkeDoBazy(planszowka);
                    }
                }
        );
    }
}