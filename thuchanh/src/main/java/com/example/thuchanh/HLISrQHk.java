package com.example.thuchanh;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashSet;
import java.util.Set;

public class HLISrQHk {
    public static void main(String[] args) throws IOException {
        InetAddress ip = InetAddress.getByName("203.162.10.109");
        int port = 2207;

        DatagramSocket sc = new DatagramSocket();
        String id = ";B21DCCN669;HLISrQHk";
        DatagramPacket dgGui = new DatagramPacket(id.getBytes(), id.length(), ip, port);
        sc.send(dgGui);

        byte[] bytes = new byte[1024];
        DatagramPacket dgNhan = new DatagramPacket(bytes, bytes.length);
        sc.receive(dgNhan);

        String s = new String(dgNhan.getData()).trim();

        String a[] = s.split(";");
        String z[] = a[1].split(",");

        Set<Integer> st = new HashSet<>();
        int Max1 = -1, Max2 = -1, Min1 = 999999, Min2 = 99999;
        for (String i : z) {
            int x = Integer.parseInt(i);
            if (x > Max1) {
                Max2 = Max1;
                Max1 = x;
            } else if (x > Max2) {
                Max2 = x;
            }

            if (x < Min1) {
                Min2 = Min1;
                Min1 = x;
            } else if (x < Min2) {
                Min2 = x;
            }
        }

        String anss = a[0] + ";" + Max2 + "," + Min2;
        System.out.println(s);
        System.out.println(anss);

        dgGui = new DatagramPacket(anss.getBytes(), anss.length(), ip, port);
        sc.send(dgGui);
        sc.close();
    }
}
