package onlineTraining;

import lombok.Cleanup;
import lombok.SneakyThrows;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class DemoApp {

    /**
     * TASK 2
     * :point_right: Send a message via Java Socket
     * Using java.net library, create a Socket and connect to host 93.175.204.87 on port 8899
     * Send a text message "Hello from {full name} ({location})" to that socket. E.g. "Hello from Taras Boychuk (Ivano-Frankivsk)"
     * Close the connection
     * @param args
     */

//    @SneakyThrows
//    public static void main(String[] args) {
//        try(var socket = new Socket("93.175.204.87", 8899)){
//            var outputStream = socket.getOutputStream();
//            var writer = new PrintWriter(new OutputStreamWriter(outputStream));
//            writer.println("Hello from Victoria");
//            writer.flush();
//        }
//    }
//
//    @SneakyThrows
//    public void sendHttpRequest(){
//        @Cleanup var socket = new Socket();
//        var inetAddress = new InetSocketAddress("93.175.204.87", 8080);
//        socket.connect(inetAddress);
//
//    }


}
