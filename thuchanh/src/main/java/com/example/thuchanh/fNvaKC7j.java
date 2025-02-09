package com.example.thuchanh;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class fNvaKC7j {
    public static void main(String[] args) throws IOException {
        String ip = "203.162.10.109";
        int port = 2207;
        Socket sc = new Socket(ip, port);

        DataOutputStream dos = new DataOutputStream(sc.getOutputStream());
        DataInputStream dis = new DataInputStream(sc.getInputStream());

        String id = "B21DCCN669;fNvaKC7j";
        dos.writeUTF(id);
        dos.flush();

        int a = dis.readInt();
        int b = dis.readInt();

        System.out.println(a + " " + b);
        int ucln = gcd(a, b);
        int bcnn = a * b / ucln;
        int tong = a + b;
        int tich = a * b;

        dos.writeInt(ucln);
        dos.writeInt(bcnn);
        dos.writeInt(tong);
        dos.writeInt(tich);

        dos.flush();
        sc.close();
    }

    public static int gcd(int a, int b) {
        if (b == 0)
            return a;

        if (b > a) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        while (b > 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}
