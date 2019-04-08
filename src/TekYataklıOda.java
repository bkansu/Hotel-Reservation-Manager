public class TekYataklıOda extends Oda {
            /* Oda sınıfından türetilmiş  bir sınıf. İçerisinde sadece constructor ve property var.. */
    public TekYataklıOda(boolean havuzManzarali, int numara) {
        super(havuzManzarali, numara);
    }

    @Override
    public int getTip() {
        return havuzManzarali ? 1 : 4;
    }
}
