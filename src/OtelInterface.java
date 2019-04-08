import java.util.Date;

public interface OtelInterface { /* Otel sınıfında kullanmak üzere bir interface oluşturduk. */
    void addOda(Oda x);
    boolean isOdaMüsait(Oda x,Date startDate, Date endDate);
    void makeRezervation(Oda x,Rezervation rezervation);
    void cancelRezervation(Oda x,Date startDate, Date endDate);

}
