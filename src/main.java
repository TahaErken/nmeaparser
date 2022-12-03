import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class main{
    static String GPGGA_Test = "$GPGGA,211034,4738.9577,N,12220.9329,W,1,09,1.0,10.8,M,-18.4,M,,*42";



    public static void main(String [ ] args)
    {
        int port = 50001;
        UdpUnicastClient client = new UdpUnicastClient(port);
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(client);






        NMEA nmea = new NMEA();
        nmea.parse(GPGGA_Test);
        System.out.println(nmea.position);







    }
}