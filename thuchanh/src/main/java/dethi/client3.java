package dethi;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

public class client3 {
    public static void main(String[] args) throws Exception {
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("localhost");

        byte[] receiveData = new byte[1024];

        String idStudent = "B21DCCN669;client3";
        DatagramPacket sendPacket = new DatagramPacket(idStudent.getBytes(), idStudent.length(), IPAddress, 9876);
        clientSocket.send(sendPacket);

        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);
        String input = new String(receivePacket.getData()).trim();
        System.out.println("Received input: " + input);

        String clientAnswer = sol(input).trim();
        System.out.println("Answer: " + clientAnswer);

        sendPacket = new DatagramPacket(clientAnswer.getBytes(), clientAnswer.length(), IPAddress, 9876);
        clientSocket.send(sendPacket);

        receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);
        String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
        System.out.println("Server response: " + response);

        clientSocket.close();
    }

    public static String sol(String input) {
        String[] parts = input.split(";");
        int n = Integer.parseInt(parts[0]);

        Vector<Pair> times = new Vector<>();
        for (int i = 1; i <= n; i++) {
            String[] pair = parts[i].split(" ");
            int t = Integer.parseInt(pair[0]);
            int d = Integer.parseInt(pair[1]);
            times.add(new Pair(t, d));
        }

        Collections.sort(times, new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                if (a.t != b.t)
                    return a.t - b.t;
                return a.d - b.d;
            }
        });

        int s = 0;
        for (int i = 0; i < times.size(); i++) {
            if (s < times.get(i).t) {
                s = times.get(i).t;
            }
            s += times.get(i).d;
        }
        return String.valueOf(s);
    }
}
