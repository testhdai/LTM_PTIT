package com.example.thuchanh;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class u45DFP93 {
    public static void main(String[] args) throws IOException {
        String ip = "203.162.10.109";
        int port = 2206;
        Socket sc = new Socket(ip, port);

        String id = "B21DCCN669;u45DFP93";
        OutputStream os = sc.getOutputStream();
        os.write(id.getBytes());
        os.flush();

        InputStream is = sc.getInputStream();
        byte[] bytes = new byte[1024];
        int byteRead = is.read(bytes);
        String s = new String(bytes, 0, byteRead).trim();
        String[] a = s.split(",");

        System.out.println(s);
        List<Integer> x1 = new ArrayList<>();
        List<Integer> x2 = new ArrayList<>();
        for (String i : a) {
            int x = Integer.parseInt(i);
            if (x % 2 == 0) {
                x1.add(x);
            } else {
                x2.add(x);
            }
        }
        Collections.sort(x1);
        Collections.sort(x2);

        String chan = "";
        String le = "";
        for (int i : x1) {
            chan += String.valueOf(i) + ", ";
        }
        if (chan.length() >= 3)
            chan = chan.substring(0, chan.length() - 2);
        for (int i : x2) {
            le += String.valueOf(i) + ", ";
        }
        if (le.length() >= 3)
            le = le.substring(0, le.length() - 2);
        String ans = "[" + chan + "]" + ";" + "[" + le + "]";
        System.out.println(ans);

        os.write(ans.getBytes());
//        bw.newLine();
//        bw.flush();

        sc.close();
    }
}
