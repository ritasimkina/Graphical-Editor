/**
 * Processing the client's access.
 * The ip-address is: 127.0.0.1:8080
 *
 * @author Klaus Bareis
 * @version 1.0
 */

import java.net.*;
import java.io.*;


import java.util.*;

public class Server extends Thread {
    static final int PORT=8080;
    //static final String IP="10.101.101.5";
    static final String IP="127.0.0.1";

    private Proxy proxy=new Proxy();;

    static final String HTML_START = "<html><head><title>Forms</title>";
    static final String HTML_END = "</html>";

    Socket socket = null;
    BufferedReader in = null;
    DataOutputStream out = null;


    public Server(Socket socket) {
        this.socket = socket;
    }

    /**
     * main Server routine
     */
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
            //resp.append("<b> Response from Server </b><BR>");
            resp.append(proxy.get_html());




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

    /**
     * Sends a string to the client
     *
     * @param resp: the string to send
     * @param status: the status
     * @throws java.lang.Exception Error writing the host
     */
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

    /**
     * Entry routine of the Application
     *
     * @param args: currently no use
     * @throws java.lang.Exception error of the host
     */
    public static void main (String args[]) throws Exception {

        ServerSocket Server = new ServerSocket (PORT, 10, InetAddress.getByName(IP));
        System.out.println ("TCPServer Waiting for client on port "+PORT);

        while(true) {
            Socket connected = Server.accept();
            (new Server(connected)).start();
        }
    }
}

