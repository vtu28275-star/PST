
import java.io.*;
import java.util.*;

class Student {
    private int id;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }
}

public class Solution {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            String name = sc.next();
            double cgpa = sc.nextDouble();

            students.add(new Student(id, name, cgpa));
        }

        students.sort((a, b) -> {
            // CGPA: descending
            int result = Double.compare(b.getCgpa(), a.getCgpa());

            if (result != 0)
                return result;

            // Name: ascending
            result = a.getFname().compareTo(b.getFname());

            if (result != 0)
                return result;

            // ID: ascending
            return Integer.compare(a.getId(), b.getId());
        });

        for (Student s : students) {
            System.out.println(s.getFname());
        }

        sc.close();
    }
}
