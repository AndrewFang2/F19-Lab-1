import java.net.*;
import java.io.*;
public class Client {
    public static void main(String args[]) throws IOException {
        Socket client = new Socket("localhost", 1254);
        InputStream s1In = client.getInputStream();
        DataInputStream dis = new DataInputStream(s1In);
        String st = new String (dis.readUTF());
        System.out.println(st);
        dis.close();
        s1In.close();
        client.close();
    }
}
