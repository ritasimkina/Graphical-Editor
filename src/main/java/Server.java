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
import Debug.*;
import Iterator.*;
import Component.*;

public class Server extends Thread {
    static final boolean SINGLE_CONNECTION=true;
    static final int PORT=8080;
    //static final String IP="10.101.101.5";
    static final String IP="127.0.0.1";

    private Proxy proxy=new Proxy();;

    Socket socket = null;
    BufferedReader in = null;
    DataOutputStream out = null;


    public Server(Socket socket) {  Debug.out(Thread.currentThread());
        this.socket = socket;
    }

    /**
     * main Server routine
     */
    public void run() { Debug.out(Thread.currentThread());
        try {
            System.out.println( "Client="+  socket.getInetAddress() + ":" + socket.getPort());

            in = new BufferedReader(new InputStreamReader (socket.getInputStream()));
            out = new DataOutputStream(socket.getOutputStream());

            StringBuffer resp = new StringBuffer();
            String req="";

            while (true)    {

                while (!in.ready()) ;
                req = in.readLine();
                StringTokenizer header = new StringTokenizer(req);
                String httpMethod = header.nextToken();
                String httpQueryString = header.nextToken();
                while (in.ready())  req = in.readLine();


                if (httpMethod.equals("GET") || httpMethod.equals("POST")) {
                    if (httpQueryString.equals("/")) {
                        resp.append(proxy.get_html());
                        sendResponse(200, resp.toString());
                        resp.setLength(0);
                    } else {
                        String req_side = httpQueryString.replaceFirst("/", "");
                        req_side = req_side.replace("?","");

                        StringTokenizer tok = new StringTokenizer(req_side,".");
                        String command = tok.nextToken();
                        String object;

                        String r="";
                        int status=0;
                        switch (command) {
                            case "Edit":
                                proxy.edit();
                                status=200; r=proxy.get_html();
                                break;
                            case "Delete":
                                //object = tok.nextToken();
                                proxy.delete();
                                status=200; r=proxy.get_html();
                                break;
                            case "Save":
                                proxy.save();
                                status=200; r=proxy.get_html();
                                break;
                            case "svg_edit_save":
                                String s=req_side.substring(req_side.indexOf('.')+1);
                                s=s.replace("%20"," "); // url with space
                                proxy.edit_end(s);
                                status=200; r=proxy.get_html();
                                break;
                            case "svg_edit_cancel":
                                proxy.edit_end("");
                                status=200; r=proxy.get_html();
                                break;
                            case "add_svg":
                                object = tok.nextToken();
                                proxy.create_shape(object);
                                status=200; r=proxy.get_html();
                                break;
                            case "clicked_svg":
                                object = tok.nextToken();
                                proxy.select_svg(object);
                                status=200; r=proxy.get_html();
                                break;
                            case "layer_add":
                                proxy.add_layer();
                                status=200; r=proxy.get_html();
                                break;
                            case "clicked_layer_check":
                                object = tok.nextToken();
                                proxy.show_layer(object);
                                status=200; r=proxy.get_html();
                                break;
                            case "clicked_layer_radio":
                                object = tok.nextToken();
                                proxy.select_layer(object);
                                status=200; r=proxy.get_html();
                                break;
                            default:
                                status=404;
                                r="not found";

                        }
                        sendResponse(status, r.toString());
                        resp.setLength(0);
                    }
                }
                else sendResponse(404, "not found");
            }

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
    public void sendResponse (int status, String resp) throws Exception { Debug.out(Thread.currentThread());

        String statusLine = null;
        String contentLengthLine = null;
        String fileName = null;
        String contentTypeLine = "Content-Type: text/html\r\n";
        FileInputStream fin = null;

        if (status == 200)  statusLine = "HTTP/1.1 200 OK\r\n";
        else                statusLine = "HTTP/1.1 404 Not Found\r\n";

//        resp = Server.HTML_START + resp + Server.HTML_END;
        contentLengthLine = "Content-Length: " + resp.length() + "\r\n";

        out.writeBytes(statusLine);
        out.writeBytes(contentTypeLine);
        out.writeBytes(contentLengthLine);
        //out.writeBytes("Connection: close\r\n");
        out.writeBytes("\r\n");
        out.writeBytes(resp);

        //out.close();
    }

    /**
     * Entry routine of the Application
     *
     * @param args: currently no use
     * @throws java.lang.Exception error of the host
     */
    public static void main (String args[]) throws Exception {  Debug.out(Thread.currentThread());
        ServerSocket Server = new ServerSocket (PORT, 10, InetAddress.getByName(IP));

        if(!SINGLE_CONNECTION)   {
            while(true) {
                System.out.println ("TCPServer Waiting for client on port "+PORT);
                Socket connected = Server.accept();
                (new Server(connected)).start();
            }
        } else {
            System.out.println ("TCPServer Waiting for client on port "+PORT);
            Socket connected = Server.accept();
            (new Server(connected)).start();
            while(true) {Thread.sleep(1000);}

        }

    }
}

