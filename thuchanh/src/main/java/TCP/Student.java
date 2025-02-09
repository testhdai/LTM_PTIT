package TCP;

import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = 20151107;

    public int id;
    public String code;
    public float gpa;
    public String gpaLetter;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", gpa=" + gpa +
                ", gpaLetter='" + gpaLetter + '\'' +
                '}';
    }
}
