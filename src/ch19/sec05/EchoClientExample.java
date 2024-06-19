package ch19.sec05;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClientExample {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("192.168.0.9", 50001);
            System.out.println("서버와 연결됨");

            System.out.println("=====================================");
            /*
             * 서버에 데이터를 보냄
             */
            String message = "자바 공부 중입니다";
            byte[] bytes = message.getBytes("UTF-8");
            OutputStream os = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            dos.writeUTF(message);
            dos.flush();
            System.out.println("데이터 보내기 성공");

            System.out.println("=====================================");
            /*
             * 서버로부터 데이터를 받음
             */
            InputStream is = socket.getInputStream();
            bytes = new byte[1024];
            DataInputStream dis = new DataInputStream(is);
            message = dis.readUTF();


            Thread.sleep(5000);
            System.out.println("데이터 받기 성공: " + message);

        } catch (UnknownHostException e) {
            System.out.println("1");
            // 서버의 IP 주소가 잘못되었을 경우
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("2");
            // 서버가 실행 중이지 않을 경우
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
