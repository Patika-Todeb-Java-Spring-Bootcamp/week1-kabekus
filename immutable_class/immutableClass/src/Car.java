import java.awt.*;
import java.util.Date;

final class Car {
    public enum Brand{
        TOYOTA,
        FORD,
        WOLKSWAGEN,
        LANDROVER,
        KIA,
        BMW
    }
    private int year,km, peopleNum;
    private Color color;
    private Date date;

    public int getYear() {
        return year;
    }

    public int getKm() {
        return km;
    }

    public int getPeopleNum() {
        return peopleNum;
    }

    public Color getColor() {
        return color;
    }

    public Date getDate() {
        return date;
    }
}
