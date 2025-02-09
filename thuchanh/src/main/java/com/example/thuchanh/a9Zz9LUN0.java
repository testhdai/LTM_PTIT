package com.example.thuchanh;

import TCP.Student;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class a9Zz9LUN0 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket sc = new Socket("203.162.10.109", 2209);
        String id = "B21DCCN669;9Zz9LUN0";
        ObjectOutputStream oos = new ObjectOutputStream(sc.getOutputStream());
        oos.writeObject(id);
        oos.flush();

        ObjectInputStream ois = new ObjectInputStream(sc.getInputStream());
        Student stu = (Student) ois.readObject();
        System.out.println(stu);

        if (stu.gpa <= 1) {
            stu.gpaLetter = "F";
        } else if (stu.gpa <= 2) {
            stu.gpaLetter = "D";
        } else if (stu.gpa <= 3) {
            stu.gpaLetter = "C";
        } else if (stu.gpa <= 3.7) {
            stu.gpaLetter = "B";
        } else if (stu.gpa <= 4) {
            stu.gpaLetter = "A";
        }

        oos.writeObject(stu);
        System.out.println(stu);
        oos.flush();
        sc.close();
    }
}
