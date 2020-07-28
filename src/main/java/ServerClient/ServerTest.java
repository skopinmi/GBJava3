package ServerClient;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;


class Server {

    public Server() {
        ServerSocket server = null;
        Socket socket = null;

        try {

            server = new ServerSocket(8189);
            System.out.println("Сервер запущен!");
            socket = server.accept();
            System.out.println("Клиент подключился");
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            System.out.println((Cat) in.readObject());

        } catch (IOException | ClassNotFoundException e) {
             e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static class ServerTest {
        public static void main(String[] args) {
            new Server();
        }
    }
}

