

public class main{
    static String GPGGA_Test = "$GPGGA,211034,4738.9577,N,12220.9329,W,1,09,1.0,10.8,M,-18.4,M,,*42";



    public static void main(String [ ] args)
    {
        NMEA nmea = new NMEA();
        nmea.parse(GPGGA_Test);
        System.out.println(nmea.position);

    }
}