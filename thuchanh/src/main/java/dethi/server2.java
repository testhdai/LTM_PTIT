package dethi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class server2 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12346);

        while (true) {
            Socket clientSocket = serverSocket.accept();

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String idStudent = in.readLine().trim();
            System.out.println("idStudent: " + idStudent);

            int[] array = getRandomArray();
            String arrayString = convertArrayToString(array);
            System.out.println(arrayString);
            out.println(arrayString);

            String correctAnswer = solution(array, array.length);
            System.out.println("Server's correct answer: " + correctAnswer);

            String clientResponse = in.readLine();
            System.out.println("Client's response: " + clientResponse);

            if (clientResponse.equals(correctAnswer)) {
                out.println("Dung");
            } else {
                out.println("Sai");
            }

            clientSocket.close();
        }
    }

    private static int[] getRandomArray() {
        Random rand = new Random();
        int n = rand.nextInt(10) + 1;
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = rand.nextInt(10);
        }
        return array;
    }

    private static String convertArrayToString(int[] array) {
        String output = "";
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                output += ",";
            }
            output += array[i];
        }
        return output;
    }

    public static String solution(int[] a, int n) {
        int l = 0;
        int r = n - 1;
        while (l < r) {
            if (a[l++] != a[r--]) {
                return "NO";
            }
        }
        return "YES";
    }
}

