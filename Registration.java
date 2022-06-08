package AnonymousPackage;

public class Registration {
    work w=new work(){

        @Override
        public void displayDate(String date) {
            System.out.println("Registration Date: "+date);
        }
    };

    public static void main(String[] args) {
        Registration r=new Registration();
        Calendar c=new Calendar();
        c.showDate(r.w);
    }
}


class Calendar
{
    public void showDate(work w)
    {
        String date="8/6/2022";
        w.displayDate(date);
    }
}
