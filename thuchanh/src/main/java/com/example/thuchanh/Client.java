package com.example.thuchanh;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class Client {
    public static void main(String[] args) throws IOException {
        String studentCode = "B21DCCN669";
        String qCode = "Nfw6wMI";
        try (Socket socket = new Socket("172.188.19.218", 1605)) {
            socket.setSoTimeout(5000);

            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            DataInputStream dis = new DataInputStream(socket.getInputStream());

            String message = studentCode + ";" + qCode;
            dos.writeUTF(message);
            dos.flush();
            System.out.println("Đã gửi: " + message);

            int a = dis.readInt();
            int b = dis.readInt();
            System.out.println("Nhận được số nguyên a: " + a + ", b: " + b);

            int sum = a + b;
            int difference = a - b;
            int product = a * b;

            dos.writeInt(sum);
            dos.writeInt(difference);
            dos.writeInt(product);
            dos.flush();

            socket.close();
            System.out.println("Đã đóng kết nối với server.");
        } catch (SocketTimeoutException e) {
            System.err.println("Kết nối bị quá thời gian chờ (timeout).");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
