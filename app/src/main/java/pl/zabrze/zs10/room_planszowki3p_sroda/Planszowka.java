package pl.zabrze.zs10.room_planszowki3p_sroda;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "planszowki")
public class Planszowka {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_gry")
    private int id;
    private String nazwa;
    @ColumnInfo(name = "min")
    private int minLiczbaGraczy;
    @ColumnInfo(name = "max")
    private int maksymalnaLiczbaGraczy;
    private int wiek;
    private int czasGry;

    public Planszowka(String nazwa, int minLiczbaGraczy, int maksymalnaLiczbaGraczy, int wiek, int czasGry) {
        id =0;
        this.nazwa = nazwa;
        this.minLiczbaGraczy = minLiczbaGraczy;
        this.maksymalnaLiczbaGraczy = maksymalnaLiczbaGraczy;
        this.wiek = wiek;
        this.czasGry = czasGry;
    }

    @Override
    public String toString() {
        return "Planszowka{" +
                "nazwa='" + nazwa +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getMinLiczbaGraczy() {
        return minLiczbaGraczy;
    }

    public void setMinLiczbaGraczy(int minLiczbaGraczy) {
        this.minLiczbaGraczy = minLiczbaGraczy;
    }

    public int getMaksymalnaLiczbaGraczy() {
        return maksymalnaLiczbaGraczy;
    }

    public void setMaksymalnaLiczbaGraczy(int maksymalnaLiczbaGraczy) {
        this.maksymalnaLiczbaGraczy = maksymalnaLiczbaGraczy;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public int getCzasGry() {
        return czasGry;
    }

    public void setCzasGry(int czasGry) {
        this.czasGry = czasGry;
    }
}
