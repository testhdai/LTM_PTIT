package dethi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Stack;

public class server1 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);

        while (true) {
            Socket clientSocket = serverSocket.accept();

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String idStudent = in.readLine().trim();
            System.out.println("idStudent: " + idStudent);

            String randomString = getRandomString();
            out.println(randomString);

            String correctAnswer = solution(randomString);
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

    private static String getRandomString() {
        String abc = "abcdefghijklmnopqrstuvwxyz";
        Random rand = new Random();
        String inputRandom = "";
        int length = rand.nextInt(10) + 1;

        for (int i = 0; i < length; i++) {
            inputRandom += abc.charAt(rand.nextInt(abc.length()));
        }

        return inputRandom;
    }

    private static String solution(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (st.empty())
                st.push(s.charAt(i));
            else {
                char top = st.peek();
                if (top == s.charAt(i))
                    st.pop();
                else
                    st.push(s.charAt(i));
            }
        }
        if (st.empty())
            return "";

        String ans = "";
        while (!st.empty()) {
            ans = st.peek() + ans;
            st.pop();
        }

        return ans;
    }

}
