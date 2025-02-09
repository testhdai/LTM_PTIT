package com.example.thuchanh;

import java.io.IOException;
import java.net.*;

public class multicastServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        DatagramSocket server = new DatagramSocket();

        int cnt = 0;
        while (true) {
            String x = "Video " + cnt;
            byte[] dataSend = x.getBytes();
            DatagramPacket dg = new DatagramPacket(dataSend, dataSend.length, InetAddress.getByName("224.2.2.3"), 1107);
            server.send(dg);
            Thread.sleep(2000);
            System.out.println(x);
        }

    }
}
