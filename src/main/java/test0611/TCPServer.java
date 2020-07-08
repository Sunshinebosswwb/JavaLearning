package test0611;
import java.io.*;
import java.net.*;

import java.net.ServerSocket;

/**
 * @auther alex
 * @description 服务器程序
 * @data 2020/6/15
 **/
public class TCPServer {
    public static void main(String[] args) throws IOException {
        String clientSentence;
        String capitalizeSentence;
        ServerSocket welcomeSocket = new ServerSocket(6789);
        while(true){
            Socket connectionSocket = welcomeSocket.accept();
            BufferedReader inFromClient =
                    new BufferedReader(new InputStreamReader(
                            connectionSocket.getInputStream() ));
            DataOutputStream outToClient =
                    new DataOutputStream(
                            connectionSocket.getOutputStream());
            clientSentence = inFromClient.readLine();
            capitalizeSentence =
                    clientSentence.toUpperCase() + '\n';
            outToClient.writeBytes(capitalizeSentence);
        }
    }
}
