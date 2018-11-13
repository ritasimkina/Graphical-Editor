import java.net.*;
import java.io.*;


import java.util.*;

public class Server extends Thread {
    private Proxy proxy=new Proxy();;

    static final int PORT=8080;

    static final String HTML_START = "<html><title>MyServer</title><body>";
    static final String HTML_END = "</body></html>";

    Socket socket = null;
    BufferedReader in = null;
    DataOutputStream out = null;


    public Server(Socket socket) {
        this.socket = socket;
    }

    public void run() {

        try {
            System.out.println( "Client="+  socket.getInetAddress() + ":" + socket.getPort());

            in = new BufferedReader(new InputStreamReader (socket.getInputStream()));
            out = new DataOutputStream(socket.getOutputStream());

            String req = in.readLine();

            StringTokenizer header = new StringTokenizer(req);
            String httpMethod = header.nextToken();
            String httpQueryString = header.nextToken();

            StringBuffer resp = new StringBuffer();
            resp.append("<b> Response from Server </b><BR>");
            //resp.append(proxy.get_html());




            while (in.ready())  req = in.readLine();

            if (httpMethod.equals("GET")) {
                if (httpQueryString.equals("/")) {
                    sendResponse(200, resp.toString());
                } else {
                    String req_side = httpQueryString.replaceFirst("/", "");
                    req_side = URLDecoder.decode(req_side);
                    if (req_side=="A"){
                        assert false;
                        sendResponse(200, req_side);
                    }
                    else {
                        sendResponse(404, "not found");
                    }
                }
            }
            else sendResponse(404, "not found");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendResponse (int status, String resp) throws Exception {

        String statusLine = null;
        String contentLengthLine = null;
        String fileName = null;
        String contentTypeLine = "Content-Type: text/html\r\n";
        FileInputStream fin = null;

        if (status == 200)  statusLine = "HTTP/1.1 200 OK\r\n";
        else                statusLine = "HTTP/1.1 404 Not Found\r\n";

        resp = Server.HTML_START + resp + Server.HTML_END;
        contentLengthLine = "Content-Length: " + resp.length() + "\r\n";

        out.writeBytes(statusLine);
        out.writeBytes(contentTypeLine);
        out.writeBytes(contentLengthLine);
        out.writeBytes("Connection: close\r\n");
        out.writeBytes("\r\n");
        out.writeBytes(resp);

        out.close();
    }

    public static void main (String args[]) throws Exception {

        ServerSocket Server = new ServerSocket (PORT, 10, InetAddress.getByName("127.0.0.1"));
        System.out.println ("TCPServer Waiting for client on port "+PORT);

        while(true) {
            Socket connected = Server.accept();
            (new Server(connected)).start();
        }
    }
}



/*
public class Server {
    private Proxy proxy;

    public class App {

        App(Socket socket) {
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
                stop()
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
           // TCPServer server= new TCPServer();

           // App app=new App();

            ServerSocket Server = new ServerSocket (8080, 10, InetAddress.getByName("127.0.0.1"));
            System.out.println ("Waiting for client on port 8080");

            while(true) {
                Socket socket = Server.accept();
                (new App(socket)).start();
            }



            //server.start(app);
            //server.stop();

        } catch (Exception e) {
            System.out.println(e);
            assert false;
        }
    }
}
*/