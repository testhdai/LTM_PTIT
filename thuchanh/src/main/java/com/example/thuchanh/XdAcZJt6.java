package com.example.thuchanh;

import java.io.IOException;
import java.net.*;
import java.util.Arrays;

public class XdAcZJt6 {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress iA = InetAddress.getByName("203.162.10.109");
        int iP = 2208;
        String id = ";B21DCCN669;XdAcZJt6";
        DatagramPacket dggui = new DatagramPacket(id.getBytes(), id.length(), iA, iP);
        socket.send(dggui);

        byte[] bytes = new byte[1024];
        DatagramPacket dgnhan = new DatagramPacket(bytes, bytes.length);
        socket.receive(dgnhan);
        String s = new String(dgnhan.getData());
        System.out.println(s);
        s = s.replace(";", " ");
        String[] a = s.split("\\s+");
        String res = a[0] + ";";
        for (int i = 1; i < a.length; i++) {
            res += Character.toUpperCase(a[i].charAt(0)) + a[i].substring(1).toLowerCase() + " ";
        }
//        res = res.trim();
        System.out.println(res);
        DatagramPacket dggui2 = new DatagramPacket(res.getBytes(), res.length(), iA, iP);
        socket.send(dggui2);
        socket.close();

    }
}

//
//    DatagramSocket socket = new DatagramSocket();
//    InetAddress iA = InetAddress.getByName("203.162.10.109");
//    int iP = 2208;
//    String code = ";B21DCCN669;XdAcZJt6";
//    DatagramPacket dpgui = new DatagramPacket(code.getBytes(), code.length(), iA, iP);
//        socket.send(dpgui);
//
//                byte[] bytes = new byte[1024];
//                DatagramPacket dpnhan = new DatagramPacket(bytes, bytes.length);
//                socket.receive(dpnhan);
//
//                String s = new String(dpnhan.getData());
//                System.out.println(s);
//                String[] s1 = s.split(";\\s+");
//                String id = s1[0];