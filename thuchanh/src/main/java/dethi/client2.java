package dethi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class client2 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12346);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        String id = "B21DCCN669;client1";
        out.println(id);

        String arrayInput = in.readLine();
        System.out.println("Received array from server: " + arrayInput);

        String[] strArray = arrayInput.split(",");
        int[] array = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            array[i] = Integer.parseInt(strArray[i]);
        }

        String clientAnswer = sol(array, array.length);
        System.out.println("Client's answer: " + clientAnswer);

        out.println(clientAnswer);

        String serverResponse = in.readLine();
        System.out.println("Server's response: " + serverResponse);

        socket.close();
    }

    public static String sol(int[] a, int n) {
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

