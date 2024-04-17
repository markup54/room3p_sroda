package pl.zabrze.zs10.room_planszowki3p_sroda;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Planszowka.class}, version = 1)
public abstract class PlanszowkiDatabase extends RoomDatabase {

    public abstract PlanszowkiDAO uzyjPlanszowkiDao();

    private static PlanszowkiDatabase instancja;
    public static PlanszowkiDatabase zwrocInstancje(Context context){
        if(instancja == null){
            instancja = Room.databaseBuilder(context.getApplicationContext(),
                    PlanszowkiDatabase.class,
                    "planszowki_db")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();

        }
        return instancja;
    }
}
