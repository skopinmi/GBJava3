package ServerClient;



import java.io.*;
import java.net.Socket;



public class Client {

    final String IP_ADRESS = "localhost";
    final int PORT = 8189;
    Socket socket;
    public void connect() {
        try {
            socket = new Socket(IP_ADRESS, PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Client client = new Client();
        client.connect();
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(client.socket.getOutputStream());
            Cat cat = new Cat("Chernysh");
            out.writeObject(cat);
            System.out.println("send " + cat);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Cat implements Serializable {
    private String name;
    public Cat(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Кот " + name;
    }
}