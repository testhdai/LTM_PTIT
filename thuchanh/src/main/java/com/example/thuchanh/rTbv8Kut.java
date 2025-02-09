package com.example.thuchanh;

import UDP.Customer;

import java.io.*;
import java.net.*;

public class rTbv8Kut {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        InetAddress ip = InetAddress.getByName("203.162.10.109");
        int port = 2209;
        DatagramSocket sc = new DatagramSocket();
        String id = ";B21DCCN669;rTbv8Kut";
        DatagramPacket dgGui = new DatagramPacket(id.getBytes(), id.length(), ip, port);
        sc.send(dgGui);

        byte[] bytes = new byte[1024];
        DatagramPacket dgNhan = new DatagramPacket(bytes, bytes.length);
        sc.receive(dgNhan);

        String requestId = new String(dgNhan.getData(), 0, 8);
        System.out.println(requestId);

        ByteArrayInputStream bais = new ByteArrayInputStream(dgNhan.getData(), 8, dgNhan.getLength() - 8);
        ObjectInputStream ois = new ObjectInputStream(bais);

        Customer customer = (Customer) ois.readObject();
        System.out.println(customer);

        String[] namel = customer.name.split("\\s+");
        String empty = "";
        String oldName = customer.name;
        empty += namel[namel.length - 1].toUpperCase() + ",";
        for (int i = 0; i < namel.length - 1; i++) {
            String x = namel[i];
            empty += " " + x.substring(0, 1).toUpperCase() + x.substring(1).toLowerCase();
        }
        System.out.println(empty);
        customer.name = empty;

        String[] months = customer.dayOfBirth.split("-");
        customer.dayOfBirth = months[1] + "/" + months[0] + "/" + months[2];

        String[] acc = oldName.split("\\s+");
        empty = "";
        for (int i = 0; i < acc.length - 1; i++) {
            empty += String.valueOf(acc[i].charAt(0)).toLowerCase();
        }
        empty += acc[acc.length - 1].toLowerCase();

        System.out.println(empty);
        customer.userName = empty;

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(customer);
        System.out.println(customer);
        oos.flush();

        byte[] sendData = new byte[8 + bos.size()];
        System.arraycopy(requestId.getBytes(), 0, sendData, 0, 8);
        System.arraycopy(bos.toByteArray(), 0, sendData, 8, bos.size());
        DatagramPacket dpGuiLai = new DatagramPacket(sendData, sendData.length, ip, port);
        sc.send(dpGuiLai);
    }
}
