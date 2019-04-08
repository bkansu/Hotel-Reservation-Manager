import java.util.Date;
import java.util.List;

public class Otel implements OtelInterface { /* İnterface'in implement edildiği Otel calssımız... */

    public Oda[] getOdalar() {
        return odalar;
    }

    private final Oda[] odalar; /* odalarımız array olarak tutulduğundan otelimizin oda sayısı başlangıçta belli olmalıdır. */
    private int index = 0;

    public Otel(int odaSayisi) {
        this.odalar = new Oda[odaSayisi];
    }

    /* Sırasıyla interface içinde yer alan bütün metodları override ediyoruz...  */

    @Override
    public void addOda(Oda x) {
        odalar[index++] = x;
    }

    @Override
    public boolean isOdaMüsait(Oda x, Date startDate, Date endDate) {
        List<Rezervation> rezervations = x.getRezervations();
        for (Rezervation rezervation : rezervations) {
            if (rezervation.intersects(startDate, endDate)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void makeRezervation(Oda x, Rezervation rezervation) {
        x.getRezervations().add(rezervation);
    }

    @Override
    public void cancelRezervation(Oda x, Date startDate, Date endDate) {
        List<Rezervation> rezervations = x.getRezervations();
        Rezervation temp = null;
        for (Rezervation rezervation : rezervations) {
            if (rezervation.getStartDate().getTime() == startDate.getTime() && rezervation.getEndDate().getTime() == endDate.getTime()) {
                temp = rezervation;
            }
        }
        if (temp != null) {
            rezervations.remove(temp);
        }
    }

    double dolulukOrani() {
        double dolu = 0;
        double oran;
        for (int i = 0; i < odalar.length; i++) {
            List<Rezervation> rezervations = odalar[i].getRezervations();
            for (Rezervation rezervation : rezervations) {
                if (rezervation.intersects(new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()))) {
                    dolu++;
                    break;
                }
            }
        }

        oran = dolu / odalar.length;
        return oran;
    }

    double tarihliDolulukOrani(Date startDate, Date endDate) {
        double dolu = 0;
        double oran;
        for (int i = 0; i < odalar.length; i++) {
            List<Rezervation> rezervations = odalar[i].getRezervations();
            for (Rezervation rezervation : rezervations) {
                if (rezervation.intersects(startDate, endDate)) {
                    dolu++;
                    break;
                }
            }
        }
        oran = dolu / odalar.length;
        return oran;
    }

    double tipDolulukOrani(int tip) {/*tip 1 = havuzlu tek yatak, tip2 = havuzlu çift yatak, tip 3 = havuzlu ikiz yatak,    ,
    tip 4 = denizli tek yatak, tip5 = denizli çift yatak, tip 6 = denizli ikiz yatak,*/
        double dolu = 0;
        double oran;
        for (int i = 0; i < odalar.length; i++) {
            List<Rezervation> rezervations = odalar[i].getRezervations();
            for (Rezervation rezervation : rezervations) {
                if (rezervation.intersects(new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis())) && odalar[i].getTip() == tip) {
                    dolu++;
                    break;
                }
            }
        }

        oran = dolu / odalar.length;
       return oran;
    }

}
