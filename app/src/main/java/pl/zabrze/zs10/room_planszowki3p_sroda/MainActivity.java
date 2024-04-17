package pl.zabrze.zs10.room_planszowki3p_sroda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Planszowka> wszystkiePlanszowki;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PlanszowkiDatabase db = PlanszowkiDatabase.zwrocInstancje(getApplicationContext());

        Planszowka p1 = new Planszowka("Splendor",2,4,8,30);
        Planszowka p2 = new Planszowka("Root",2,4,14,90);
        Planszowka p3 = new Planszowka("Everdell",2,4,10,60);
        //db.uzyjPlanszowkiDao().wstawPlanszowkeDoBazy(p1);
        //db.uzyjPlanszowkiDao().wstawPlanszowkeDoBazy(p2);
        //db.uzyjPlanszowkiDao().wstawPlanszowkeDoBazy(p3);

        wszystkiePlanszowki = db.uzyjPlanszowkiDao().wszystkiePlanszowkiZBazy();
        ArrayAdapter<Planszowka> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                wszystkiePlanszowki
        );
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Planszowka planszowka = wszystkiePlanszowki.get(i);
                        db.uzyjPlanszowkiDao().usunZBazy(planszowka);
                        //TODO dlaczego się nie odświeża
                        //dlaczego w bazie zmiana a tu nie widze
                        //ViewModel https://developer.android.com/codelabs/android-room-with-a-view#1

                        //to rozwiazanie to wiocha !!!!!!
                        wszystkiePlanszowki = db.uzyjPlanszowkiDao().wszystkiePlanszowkiZBazy();
                        adapter.notifyDataSetChanged();
                    }
                }
        );

    }
}