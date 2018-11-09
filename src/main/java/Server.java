import java.net.*;
import java.io.*;

public class Server {
    private Proxy proxy;

    public class App {

        App() {
            prepare();
        }
        private void prepare()  {
            proxy = new Proxy();
        }
    }
    public class TCPServer  {
        final int SERVER_PORT=8080;
        private ServerSocket s;
        private Socket s1;
        private OutputStream s1out;
        private DataOutputStream dos;

        TCPServer() throws IOException {
            prepare();
        }
        private void prepare() throws IOException    {
            // Register service on port 1254
            s = new ServerSocket(SERVER_PORT);
        }
        public void start(App app) throws IOException    {
            // Wait and accept a connection

            do {
                s1 = s.accept();

                // Get a communication stream
                // associated with the socket
                s1out = s1.getOutputStream();
                dos = new DataOutputStream(s1out);

                dos.writeUTF(proxy.get_html());
                dos.writeUTF(proxy.get_html());
                dos.writeUTF(proxy.get_html());
                System.out.println(proxy.get_html());
            } while(true);
        }
        public void stop() throws IOException    {
            // Close the connection, but not the server socket
            dos.close();

            s1out.close();
            s1.close();
        }
    }




    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }
    public void start(){
        try {
            TCPServer server= new TCPServer();
            App app=new App();

            server.start(app);
            server.stop();

        } catch (Exception e) {
            System.out.println(e);
            assert false;
        }
    }
}
