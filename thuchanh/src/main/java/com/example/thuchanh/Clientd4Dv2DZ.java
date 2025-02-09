package com.example.thuchanh;

import java.io.*;
import java.net.Socket;
import java.io.*;
import java.net.Socket;
import java.util.Arrays;

public class Clientd4Dv2DZ {
    private static final String SERVER_IP = "172.188.19.218";
    private static final int SERVER_PORT = 1604;
    private static final int TIMEOUT = 5000; // 5 seconds

    public static void main(String[] args) {
        String studentCode = "B21DCCN669";
        String questionCode = "d4Dv2DZ";
        String request = studentCode + ";" + questionCode;

        try (Socket socket = new Socket(SERVER_IP, SERVER_PORT)) {
            socket.setSoTimeout(TIMEOUT);  // Set timeout for reading response

            // Gửi mã sinh viên và mã bài tập đến server
            OutputStream output = socket.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
            writer.write(request);
            writer.newLine();
            writer.flush();

            // Nhận dữ liệu từ server
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String response = reader.readLine();
            System.out.println("Received response: " + response);

            // Phân tích chuỗi nhận được và tính tổng
//            String[] numbers = response.split("\\|");
//            int sum = Arrays.stream(numbers).mapToInt(Integer::parseInt).sum();
//            System.out.println("Calculated sum: " + sum);

            // Gửi kết quả tổng lại cho server
            writer.write("hello");
            System.out.println("Sent sum: ");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}