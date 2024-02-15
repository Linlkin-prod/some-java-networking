import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
/**
 * DateServer
 */
public class DateServer {

    public static void main(String[] args) {
        int port = Integer.valueOf(args[0]);
        try {
            ServerSocket app = new ServerSocket(port);
            System.out.println("Date server waiting on port "+ port);
            while (true) {
                Socket socket = app.accept();
                System.out.println("Connection accepted with"+socket.getRemoteSocketAddress().toString());
                PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
                out.println(new Date().toString());
                socket.close();
            }
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    // /127.0.0.1:40596
}