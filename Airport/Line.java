package Airport;
/*
 *User:t.me/abu_org tt:@abu_ed1t
 *Date:21.10.2023 *Time:18:59
 */

public class Line {
    private String origin; //qayerdan

    private String destination;  //qayerga

    private String departure; //qachondan

    private String wreturn; //qachongacha

    private int price;  //narxi


    public Line(String origin, String destination, String departure, String wreturn, int price) {
        this.origin = origin;
        this.destination = destination;
        this.departure = departure;
        this.wreturn = wreturn;
        this.price = price;
    }

    public Line() {
    }

    public String getOrigin() {
        return origin;
    }


    public String getDestination() {
        return destination;
    }


    public String getDeparture() {
        return departure;
    }


    public String getWreturn() {
        return wreturn;
    }


    public int getPrice() {
        return price;
    }

}
