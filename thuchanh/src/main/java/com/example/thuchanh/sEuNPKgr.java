package com.example.thuchanh;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class sEuNPKgr {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress iA = InetAddress.getByName("203.162.10.109");
        int iP = 2207;
        String id = ";B21DCCN669;sEuNPKgr";
        DatagramPacket dggui = new DatagramPacket(id.getBytes(), id.length(), iA, iP);
        socket.send(dggui);

        byte[] bytes = new byte[1024];
        DatagramPacket dgnhan = new DatagramPacket(bytes, bytes.length);
        socket.receive(dgnhan);
        String s = new String(dgnhan.getData()).trim();

        s = s.replace(";", " ");
        s = s.replace(",", " ");
        String a[] = s.split("\\s+");

        int Max = -999999;
        int Min = 99999999;
        for (int i = 1; i < a.length; i++) {
            Max = Math.max(Max, Integer.parseInt(a[i]));
            Min = Math.min(Min, Integer.parseInt(a[i]));
        }
        String res = a[0] + ";" + Integer.toString(Max) + "," + Integer.toString(Min);
        System.out.println(res);

        DatagramPacket dggui2 = new DatagramPacket(res.getBytes(), res.length(), iA, iP);
        socket.send(dggui2);
        socket.close();

//        DatagramSocket socket = new DatagramSocket();
//        InetAddress iA = InetAddress.getByName("203.162.10.109");
//        int iP = 2207;
//
//        String id = ";B21DCCN669;sEuNPKgr";
//        DatagramPacket dgGui = new DatagramPacket(id.getBytes(), id.length(), iA, iP);
//        socket.send(dgGui);
//
//        byte[] bytes = new byte[1024];
//        DatagramPacket dgNhan = new DatagramPacket(bytes, bytes.length);
//        socket.receive(dgNhan);
//
//        String s = new String(dgNhan.getData()).trim();
//        s = s.replace(";", " ");
//        s = s.replace(",", " ");
//        System.out.println(s);
//
//        String a[] = s.split("\\s+");
//        ArrayList<Integer> vt = new ArrayList<>();
//        for (int i = 1; i < a.length; i++) {
//            vt.add(Integer.parseInt(a[i]));
//        }
//        Collections.sort(vt);
//
//        String out = a[0] + ";" + vt.get(vt.size() - 1) + "," + vt.get(0);
//        System.out.println(out);
//
//        dgGui = new DatagramPacket(out.getBytes(), out.length(), iA, iP);
//        socket.send(dgGui);
//
//        socket.close();

    }
}
