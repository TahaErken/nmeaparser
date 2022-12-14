import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpUnicastClient implements Runnable {

    private final int port;

    public UdpUnicastClient(int port) {
        this.port = port;
    }


    @Override
    public void run() {

        try (DatagramSocket clientSocket = new DatagramSocket(port)) {

            byte[] buffer = new byte[32];
            clientSocket.setSoTimeout(50000);

            while (true) {
                DatagramPacket datagramPacket = new DatagramPacket(buffer, 0, buffer.length);
                clientSocket.receive(datagramPacket);

                String receivedMessage = new String(datagramPacket.getData());
                System.out.println(receivedMessage);

                NMEA nmea = new NMEA();
                nmea.parse(receivedMessage);
                System.out.println(nmea.position);


            }

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {

            System.out.println("Timeout. Client is closing");
        }

    }}







