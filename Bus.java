package BusTicketReservation;

public class Bus {
    private int busNo;
    private String busSource;
    private String busDestination;
    private int availableSeats;

    Bus(int busNo,String busSource,String busDestination,int availableSeats)
    {
        this.busNo=busNo;
        this.busSource=busSource;
        this.busDestination=busDestination;
        this.availableSeats=availableSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public int getBusNo() {
        return busNo;
    }

    public void setBusNo(int busNo) {
        this.busNo = busNo;
    }

    public String getBusSource() {
        return busSource;
    }

    public void setBusSource(String busSource) {
        this.busSource = busSource;
    }

    public String getBusDestination() {
        return busDestination;
    }

    public void setBusDestination(String busDestination) {
        this.busDestination = busDestination;
    }
}
