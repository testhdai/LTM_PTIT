package dethi;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Vector;

class Pair {
    public int t;
    public int d;

    public Pair(int t, int d) {
        this.t = t;
        this.d = d;
    }
}

public class server3 {
    public static void main(String[] args) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(9876);

        while (true) {
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            InetAddress clientAddress = receivePacket.getAddress();
            int clientPort = receivePacket.getPort();
            String idStudent = new String(receivePacket.getData()).trim();
            System.out.println("idStudent: " + idStudent);

            Vector<Pair> inputArray = getRandomInput();

            String inputString = convertInputToString(inputArray).trim();
            byte[] sendData = inputString.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
            serverSocket.send(sendPacket);

            receiveData = new byte[1024];
            receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            String clientResponse = new String(receivePacket.getData()).trim();
            System.out.println("Client's response: " + clientResponse);

            String correctAnswer = solution(inputArray);
            System.out.println("Server's correct answer: " + correctAnswer);

            String response = clientResponse.equals(correctAnswer) ? "Dung" : "Sai";
            sendData = response.getBytes();
            sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
            serverSocket.send(sendPacket);
        }
    }

    public static Vector<Pair> getRandomInput() {
        Random random = new Random();
        int n = random.nextInt(5) + 1;
        Vector<Pair> inputArray = new Vector<>();
        for (int i = 0; i < n; i++) {
            int t = random.nextInt(10);
            int d = random.nextInt(5) + 1;
            inputArray.add(new Pair(t, d));
        }
        return inputArray;
    }

    public static String convertInputToString(Vector<Pair> inputArray) {
        String sb = "";
        sb += inputArray.size();
        for (Pair p : inputArray) {
            sb += ";" + p.t + " " + p.d;
        }
        return sb;
    }

    public static String solution(Vector<Pair> v) {
        Collections.sort(v, new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                if (a.t != b.t)
                    return a.t - b.t;
                return a.d - b.d;
            }
        });

        int s = 0;
        for (int i = 0; i < v.size(); i++) {
            if (s < v.get(i).t) {
                s = v.get(i).t;
            }
            s += v.get(i).d;
        }
        return String.valueOf(s);
    }
}
