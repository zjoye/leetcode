package IKM;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class EmployeeService {
    public static void main(String[] args) {
        Employee employee = new Employee();
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Company.txt"));
            out.writeObject(employee);
            out.close();
            System.out.println(++employee.salary + "");

            ObjectInputStream in = new ObjectInputStream(new FileInputStream("Company.txt"));
            Employee empCopy = (Employee) in.readObject();
            in.close();
            System.out.println(String.join(" ", String.valueOf(empCopy.id), empCopy.name, String.valueOf(empCopy.salary)));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
