package com.example.thuchanh;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class test {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        String id = ";B21DCCN669;oBZ4YJUx";
        InetAddress iA = InetAddress.getByName("203.162.10.109");
        int iP = 2207;
        DatagramPacket dggui = new DatagramPacket(id.getBytes(), id.length(), iA, iP);
        socket.send(dggui);

        byte[] bytes = new byte[1024];
        DatagramPacket dgnhan = new DatagramPacket(bytes, bytes.length);
        socket.receive(dgnhan);
        String s = new String(dgnhan.getData()).trim();

        s = s.replace(";", " ");
        s = s.replace(",", " ");
        String a[] = s.split("\\s+");
        int Max1 = Integer.parseInt(a[1]), Max2 = Integer.parseInt(a[1]), Min1 = Integer.parseInt(a[1]), Min2 = Integer.parseInt(a[1]);
        for (int i = 1; i < a.length; i++) {
            int x = Integer.parseInt(a[i]);
            if (x > Max1) {
                Max2 = Max1;
                Max1 = x;
            } else if (x > Max2 && x < Max1) {
                Max2 = x;
            }

            if (x < Min1) {
                Min2 = Min1;
                Min1 = x;
            } else if (x < Min2 && x > Min1) {
                Min2 = x;
            }
        }

        String ans = a[0] + ";" + Max2 + "," + Min2;
        System.out.println(ans);
        DatagramPacket dggui2 = new DatagramPacket(ans.getBytes(), ans.length(), iA, iP);
        socket.send(dggui2);
        socket.close();
    }
}
