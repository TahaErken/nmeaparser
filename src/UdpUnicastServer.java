import java.io.IOException;
import java.net.*;




 // https://www.youtube.com/watch?v=SFrWdodD3hs





public class UdpUnicastServer implements Runnable {

    private final int clientPort;

    public UdpUnicastServer(int clientPort) {
        this.clientPort = clientPort;
    }


    @Override
    public void run() {

        try (DatagramSocket serverSocket = new DatagramSocket(50000 )) {  // herangi farklı bir aplikasyon tarafından kullanılmayan herangi bir port olabilir



            for(int i=0;i<100;i++)
            {
                String message = "Message Number"+i;
                DatagramPacket datagramPacket = new DatagramPacket(message.getBytes(),message.length(), InetAddress.getLocalHost(),clientPort);

                serverSocket.send(datagramPacket);



            }

        }
        catch (SocketException e) {
            e.printStackTrace();
        }catch (UnknownHostException e)
        {
            e.printStackTrace();

        }
        catch (IOException e) {

            e.printStackTrace();
        }

    }}







