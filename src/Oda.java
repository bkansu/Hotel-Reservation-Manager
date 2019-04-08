import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Oda {
    boolean havuzManzarali;

    int numara;

    private List<Rezervation> rezervations;
    public List<Rezervation> getRezervations() {
        return rezervations;
    }


    public Oda(){
         this.rezervations = new ArrayList<>(); /* Oda rezervasyonları bir arraylist olarak tutuluyor. Çünkü bir odanın çakışmayan (intersect)
          birden fazla odası olabilir. */
    }

    public Oda(boolean havuzManzarali,int numara) {
        this();
        this.havuzManzarali = havuzManzarali;
        this.numara=numara;

    }

    public abstract int getTip() ;

    public boolean isHavuzManzarali() {
        return havuzManzarali;
    }

    public int getNumara() {
        return numara;
    }




}
