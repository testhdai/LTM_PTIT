package com.example.thuchanh;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ClientI33q85z {
    private static final String SERVER_IP = "172.188.19.218";
    private static final int SERVER_PORT = 1606;
    private static final int TIMEOUT = 5000; // 5 seconds

    public static void main(String[] args) {
        String studentCode = "B21DCCN669";
        String questionCode = "I33q85z";
        String request = studentCode + ";" + questionCode;

        try (Socket socket = new Socket(SERVER_IP, SERVER_PORT)) {
            // Gửi mã sinh viên và mã bài tập đến server
            OutputStream output = socket.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
            writer.write(request);
            writer.newLine();
            writer.flush();

            // Nhận chuỗi tên miền từ server
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String domainList = reader.readLine();
            System.out.println("Received domain list: " + domainList);

            // Phân tích chuỗi nhận được và lọc các tên miền .edu
            List<String> eduDomains = Arrays.stream(domainList.split(",\\s*"))
                    .filter(domain -> domain.endsWith(".edu"))
                    .collect(Collectors.toList());

            // Gửi các tên miền .edu lại cho server
            String eduDomainsStr = String.join(", ", eduDomains);
            writer.write(eduDomainsStr);
//            writer.newLine();
//            writer.flush();
            System.out.println("Sent .edu domains: " + eduDomainsStr);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
