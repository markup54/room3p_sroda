package pl.zabrze.zs10.room_planszowki3p_sroda;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PlanszowkiDAO {
    @Insert
    void wstawPlanszowkeDoBazy(Planszowka planszowka);

    @Insert
    void wstawKilkaPlanszowek (Planszowka ...planszowkas);

    @Delete
    void usunZBazy(Planszowka planszowka);

    @Query("Select * from planszowki")
    List<Planszowka> wszystkiePlanszowkiZBazy();

    @Query("Select * from planszowki where :liczbaGraczy>=min and :liczbaGraczy<=max")
    List<Planszowka> planszowkiWedlugLiczbyGraczy(int liczbaGraczy);
}
