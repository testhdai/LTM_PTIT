package dethi;

import java.io.*;
import java.net.*;
import java.util.Stack;

public class client1 {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345)) {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String id = "B21DCCN669;client1";
            out.println(id);

            String receivedString = in.readLine();
            System.out.println("Received string from server: " + receivedString);

            String ans = sol(receivedString);
            System.out.println("Answer: " + ans);

            out.println(ans);

            String verdict = in.readLine();
            System.out.println("Server response: " + verdict);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String sol(String s) {
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
