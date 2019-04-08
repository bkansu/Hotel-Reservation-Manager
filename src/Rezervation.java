import java.util.Date;

public class Rezervation {
    private Date startDate;
    private Date endDate;

    public Rezervation(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /* Tarihler için sadece getter property'leri yeterli oalcaktır. Çünkü rezervasyon iptal işlemi arraylist üzerinden yapılmalıdır.. */

    public  boolean intersects(Date startDate, Date endDate){
        return startDate.getTime()>this.startDate.getTime() && this.endDate.getTime()>startDate.getTime() ||
                    endDate.getTime()>this.startDate.getTime() && this.endDate.getTime()>endDate.getTime() ||
                        startDate.getTime()<this.startDate.getTime() && this.endDate.getTime() < endDate.getTime();

    }
}
