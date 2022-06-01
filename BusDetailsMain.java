package BusTicketReservation;


import java.util.ArrayList;

public class BusDetailsMain implements AddBus{

    ArrayList<Bus> busList =new ArrayList<Bus>();
    @Override
    public void addBus() {

        Bus b =new Bus(1,"Chennai","Madurai",3);
        busList.add(b);

    }
}
