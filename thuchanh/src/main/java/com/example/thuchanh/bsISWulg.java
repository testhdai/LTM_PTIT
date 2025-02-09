package com.example.thuchanh;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class bsISWulg {
    public static void main(String[] args) throws IOException {
        String id = "B21DCCN669;bsISWulg";
        String ip = "203.162.10.109";
        int port = 2208;

        Socket sc = new Socket(ip, port);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(sc.getOutputStream()));
        bw.write(id);
        bw.newLine();
        bw.flush();

        BufferedReader br = new BufferedReader(new InputStreamReader(sc.getInputStream()));
        String s = br.readLine().trim();
        System.out.println(s);
        String[] a = s.split("\\s+");

        List<String> vt = new ArrayList<>();
        for (String i : a) {
            vt.add(i);
        }
        Collections.sort(vt);
        String ans = "";
        ans = String.join(" ", vt);
        System.out.println(ans);

        bw.write(ans);
        bw.flush();
        sc.close();
    }
}
