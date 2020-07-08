package test0611;

import java.io.*;
import java.net.*;

/**
 * @auther alex
 * @description 创建3条流和1个套接字
 * 1、客户机从键盘读取一行字符，通过套接字发给服务器；
 * 2、服务器从其套接字读取字符；
 * 3、将字符修改为大写；
 * 4、服务器通过套接字将修改后的字符发给客户机；
 * 5、客户机从套接字中读取修改后的字符，并将其打印/输出
 * @data 2020/6/15
 **/

//客户机系统
public class TCPClient {
     public static void main(String[] args) throws IOException {
         String sentence;//用户输入字符
         String modifiedSentence;//服务器返回字符
         //新建所示类型的流对象inFromUser，输入流用System.in初始化
         BufferedReader inFromUser = new BufferedReader(
                 new InputStreamReader(System.in));
         //新建客户机套间字
         Socket clientSocket = new Socket("hostname",6789);
         //创建了两个连接到套间字的流对象
         //outToServer为进程提供了到套间字的输出
         DataOutputStream outToServer = new DataOutputStream(
                 clientSocket.getOutputStream());
         //inFromServer为进程提供了来自套间字的输入
         BufferedReader inFromServer = new BufferedReader(
                 new InputStreamReader(
                         clientSocket.getInputStream()));
         //将用户的输入读到sentence
         sentence = inFromServer.readLine();
         //发送到outToServer流中
         outToServer.writeBytes(sentence + '\n');
         modifiedSentence = inFromServer.readLine();
         System.out.println(modifiedSentence);
         clientSocket.close();
     }
}
