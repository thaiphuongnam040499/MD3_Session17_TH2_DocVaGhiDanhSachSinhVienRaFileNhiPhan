import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Student> readDataFromFile(String path){
        List<Student> students = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (List<Student>) ois.readObject();
            fis.close();
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return students;
    }
    public static void writeToFile(List<Student> students){
        try {
            File file = new File("student.txt");
            if (!file.exists()){
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
            fos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        List<Student> students = new ArrayList<>();
//        students.add(new Student(1,"hiếu","thái bình mồ hôi rơi"));
//        students.add(new Student(2,"nhân","tây hồ 3 chục"));
//        writeToFile(students);
        List<Student> students1 = readDataFromFile("student.txt");
        for (Student student:students1) {
            System.out.println(student);
        }
    }
}
