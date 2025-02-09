package com.example.thuchanh;

import java.io.IOException;
import java.net.*;

public class clientUDP {
    public static void main(String[] args) throws IOException {
        DatagramSocket client = new DatagramSocket();
        String req = "hello world";
        byte[] data = req.getBytes();
        DatagramPacket dqReq = new DatagramPacket(data, data.length, InetAddress.getByName("localhost"), 1506);
        client.send(dqReq);

        byte[] dataRes = new byte[1024];
        DatagramPacket dgRes = new DatagramPacket(dataRes, dataRes.length);
        client.receive(dgRes);
        String res = new String(dgRes.getData()).trim();
        System.out.println(res);
    }
}
