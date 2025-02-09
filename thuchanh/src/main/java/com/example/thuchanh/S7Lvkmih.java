package com.example.thuchanh;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class S7Lvkmih {
    public static void main(String[] args) throws IOException {
        InetAddress ip = InetAddress.getByName("203.162.10.109");
        int port = 2208;
        String id = ";B21DCCN669;S7Lvkmih";

        DatagramSocket sc = new DatagramSocket();
        DatagramPacket dgGui = new DatagramPacket(id.getBytes(), id.length(), ip, port);
        sc.send(dgGui);

        byte[] bytes = new byte[1024];
        DatagramPacket dgNhan = new DatagramPacket(bytes, bytes.length);
        sc.receive(dgNhan);

        String s = new String(dgNhan.getData()).trim();
        System.out.println(s);
        String[] a = s.split(";");
        String ans = "";
        for (int i = 0; i < a[1].length(); i++) {
            String x = String.valueOf(a[1].charAt(i));
            if (!a[2].contains(x)) {
                ans += x;
            }
        }

        ans = a[0] + ";" + ans;

        System.out.println(ans);
        DatagramPacket dgGui2 = new DatagramPacket(ans.getBytes(), ans.length(), ip, port);
        sc.send(dgGui2);

        sc.close();
    }
}
