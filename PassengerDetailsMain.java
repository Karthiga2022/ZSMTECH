package BusTicketReservation;

import java.util.ArrayList;
import java.util.Scanner;

public class PassengerDetailsMain extends BusDetailsMain {
    int inc=1;
     ArrayList<Passenger> passengerList=new ArrayList<Passenger>();
     Scanner sc=new Scanner(System.in);

       public void BusTicket() {

           int userOpt=1;
           int ch;

           while (userOpt == 1) {
               System.out.println( " ");
               System.out.println("----------------------");
               System.out.println("Bus Ticket Reservation");
               System.out.println("----------------------");
               System.out.println("1.Book Ticket");
               System.out.println("2 Cancel Ticket");
               System.out.println("3.Display Ticket Details");
               System.out.println("4.Available buses");
               System.out.println("Enter 1 to continue or 0 to Exit");
               userOpt = sc.nextInt();
               if (userOpt == 1) {

                   System.out.println("Enter your choice");
                   ch = sc.nextInt();

                   switch (ch) {
                       case 1: {
                           bookTicket();
                           break;
                       }
                       case 2:
                       {
                           cancelTicket();
                           displayTicketDetails();
                           break;
                       }
                       case 3:
                       {
                           retrieveTicketDetails();
                           break;
                       }
                       case 4:
                       {
                           displayAvailableBuses();
                           break;
                       }
                   }
               }
           }
       }




       public  void bookTicket() {
           Passenger p = new Passenger();
           System.out.println("Enter Passenger name :");
           p.setPassengerName(sc.next());
           System.out.println("Enter passenger ID :");
           p.setPassengerId(sc.nextInt());
           System.out.println("Enter Travel Source :");
           p.setSource(sc.next());
           System.out.println("Enter Travel Destination");
           p.setDestination(sc.next());
           System.out.println("Enter Bus Number :");
           p.setBusNo(sc.nextInt());

           System.out.println("Booking status");
           System.out.println("--------------");

           boolean isBooked = checkSeatAvailabilty(p.getBusNo());
           if (isBooked) {
               p.setBookingStatus("Confirmed");
           } else {
               p.setBookingStatus("Cancelled");
           }
          p.setTicketId(inc++);
           passengerList.add(p);
          if(isBooked)
          {
              System.out.println("Congratulations !! Your journey with us is confirmed");
              System.out.println("Ticket Details");
              displayTicketDetails();
          }
          else {
              System.out.println("No seats available");
          }

       }

       public void cancelTicket() {
           System.out.println("Enter Ticket ID to cancel");
           try {
               int ticketID;
               ticketID = sc.nextInt();
               for (Passenger p : passengerList) {
                   if (ticketID == p.getTicketId()) {
                       p.setBookingStatus("Cancelled");
                       for (Bus b : busList) {
                           if (p.getBusNo() == b.getBusNo()) {
                               b.setAvailableSeats(b.getAvailableSeats() + 1);
                           }

                       }
                   }
               }
           }
           catch(Exception e)
           {
               e.printStackTrace();
           }
       }

       public  boolean checkSeatAvailabilty(int busNo){
           int flag=0;
           for (Bus b : busList)
           {
               if(busNo==b.getBusNo())
               {
                   if(b.getAvailableSeats()>0)
                   {
                       b.setAvailableSeats(b.getAvailableSeats()-1);
                       flag=1;

                   }
               }

           }return flag==1?true:false;

       }

       public void displayAvailableBuses()
    {
        System.out.println("Bus No" +"  "+"Bus Source   " +"Bus Destination   " +"Available Seats");
        System.out.println("----------------------------------------------------------------");
        for (Bus b : busList)
        {
            System.out.println(b.getBusNo() +"        "+b.getBusSource()+"       "+b.getBusDestination()+"      "+b.getAvailableSeats());
        }
    }

       public void displayTicketDetails()
       {
           for(Passenger p:passengerList) {
               System.out.println("Ticket ID :" +p.getTicketId());
               System.out.println("Passenger Name: "+p.getPassengerName());
               System.out.println("Travelling from: "+p.getSource());
               System.out.println("Travelling To: "+p.getDestination());
               System.out.println("Booking Status: "+p.getBookingStatus());
           }
       }

       public void retrieveTicketDetails()
       {
           int ticketID;
           System.out.println("Enter Ticket ID for details");
           ticketID=sc.nextInt();
           for(Passenger p:passengerList) {
               if(ticketID==p.getTicketId()) {
                   System.out.println("Passenger Name: "+p.getPassengerName());
                   System.out.println("Travelling from: "+p.getSource());
                   System.out.println("Travelling To: "+p.getDestination());
                   System.out.println("Booking Status: "+p.getBookingStatus());
               }
           }
           }


    public static void main(String[] args) {
        PassengerDetailsMain pmain=new PassengerDetailsMain();
        pmain.addBus();
        pmain.BusTicket();

    }

}
