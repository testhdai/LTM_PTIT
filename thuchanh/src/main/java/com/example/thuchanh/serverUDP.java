package com.example.thuchanh;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class serverUDP {
    public static void main(String[] args) throws IOException {
        DatagramSocket server = new DatagramSocket();
        while (true) {
            byte[] buf = new byte[1024];
            DatagramPacket dqReq = new DatagramPacket(buf, buf.length);
            server.receive(dqReq);
            String strRes = new String(dqReq.getData()).trim();
            System.out.println(strRes);

            String dataSend = strRes + "B21DCCN669";
            byte[] dataSendByte = dataSend.getBytes();
            DatagramPacket dgSend = new DatagramPacket(dataSendByte, dataSendByte.length, dqReq.getAddress(), dqReq.getPort());
            server.send(dgSend);
        }
    }
}
