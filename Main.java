import java.util.*;
import java.io.*;
public class Main {
    private static final String FILE_NAME = "StudentInformationSystem.txt";
    public static void main(String[] args) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
    try{
        Scanner sc = new Scanner(System.in);
        List<Student> listOfStudents = new ArrayList<>();
        
        File fin = new File(FILE_NAME);
            if(fin.length() != 0) {
                fis = new FileInputStream(fin);
                ois = new ObjectInputStream(fis);
                listOfStudents = (List<Student>) ois.readObject();
            }

        int choice;
        do {
            System.out.println("STUDENT INFORMATION SYSTEM");
            System.out.println("\t1. Register a Student.\n\t" + 
                "2. Retrieve Student Information.\n\t" +
                "3. Delete a Student.\n\t" + 
                "4. Edit a Student.\n\t" + 
                "5. Save.\n\t" + 
                "6. Display.\n\t" + 
                "7. Exit.\n");

            System.out.println("Press the number of your choice: ");
            choice = sc.nextInt();


            if (choice == 1) {
                System.out.print("Enter student number: ");
                String cute = sc.nextLine();
                String studentNum = sc.nextLine();
                if (!(checkExisting(studentNum, listOfStudents))){
                    System.out.print("Enter first name: ");
                    String firstName = sc.nextLine();
                    System.out.print("Enter middle initial: ");
                    String in = sc.nextLine();
                    char initial;
                    if (in.equals("")) {
                        initial = 32;
                    } else {
                        initial = in.charAt(0);
                    }
                    System.out.print("Enter last name: ");
                    String lastName = sc.nextLine();
                    System.out.print("Enter program/course: ");
                    String course = sc.nextLine();
                    System.out.print("Enter year level: ");
                    int yearLevel = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter crush name: ");
                    String crushName = sc.nextLine();
                    System.out.println("Enter favorite course code: ");
                    String courseCode = sc.nextLine();
                    System.out.println("Enter favorite course description: ");
                    String courseDescription = sc.nextLine();
                    Course c = new Course(courseCode,courseDescription);
                    Student student = new Student(studentNum, firstName, initial, lastName, course, yearLevel,crushName,c);
                    listOfStudents.add(student);
                    System.out.println("OUTPUT ADDED!");
                    System.out.print(student);
                }
                else{
                    System.out.println("Student already exists!");
                }
            }


            else if (choice == 2) {
                System.out.print("Enter student number: ");
                String cute = sc.nextLine();
                String num = sc.nextLine();
                boolean found = false;
                for (int i = 0; i < listOfStudents.size(); i++){
                    if (listOfStudents.get(i).getStudentNumber().equals(num)) {
                        System.out.print(listOfStudents.get(i));
                        found = true;
                        break;
                    }
                }
                if (!found)
                    System.out.println("STUDENT NOT FOUND!");
            }


            else if (choice == 3) {
                System.out.print("Enter student number: ");
                String cute = sc.nextLine();
                String num = sc.nextLine();
                boolean deleted = false;
                for (int i = 0; i < listOfStudents.size(); i++){
                    if (listOfStudents.get(i).getStudentNumber().equals(num)) {
                        listOfStudents.remove(i);
                        deleted = true;
                        break;
                    }
                }
                if (!deleted)
                    System.out.println("STUDENT NOT FOUND!");
            }


            else if (choice == 4){
                System.out.print("Enter student number: ");
                String cute = sc.nextLine();
                String num = sc.nextLine();
                boolean found = false;
                for (int i = 0; i < listOfStudents.size(); i++){
                    if (listOfStudents.get(i).getStudentNumber().equals(num)) {
                        System.out.println(listOfStudents.get(i));
                        System.out.print("Set first name to: ");
                        listOfStudents.get(i).setFirstName(sc.nextLine());
                        System.out.print("Set middle initial to: ");
                        listOfStudents.get(i).setMiddleInitial(sc.nextLine().charAt(0));
                        System.out.print("Set last name to: ");
                        listOfStudents.get(i).setLastName(sc.nextLine());
                        System.out.print("Set course: ");
                        listOfStudents.get(i).setCourse(sc.nextLine());
                        System.out.print("Set year level: ");
                        listOfStudents.get(i).setYearLevel(sc.nextInt());
                        sc.nextLine();
                        System.out.print("Set crush name: ");
                        listOfStudents.get(i).setCrushName(sc.nextLine());
                        System.out.print("Set favorite course code: ");
                        listOfStudents.get(i).setCourseCode(sc.nextLine());
                        System.out.print("Set favorite course description: ");
                        listOfStudents.get(i).setCourseDescription(sc.nextLine());
                        System.out.println("Updated information:\n" + listOfStudents.get(i));
                        found = true;
                        break;
                    }
                }
                if (!found)
                    System.out.println("STUDENT NOT FOUND!");
            } 

            else if (choice == 5) {
                 File fout = new File(FILE_NAME);
                 if(fout.exists()){
                    fout.delete();
                    fout.createNewFile();
                 }
                fout.createNewFile();
                fos = new FileOutputStream(fout);
                oos = new ObjectOutputStream(fos);
                oos.writeObject(listOfStudents);
                oos.close();
            }
            
            else if(choice == 6){
                for(Student s: listOfStudents){
                    System.out.print(s);
                }
            }
            
        }while (choice != 7);
        System.out.println("Goodbye! (っ◕‿◕)っ");
    }catch(IOException e){
        e.printStackTrace();
    }catch(ClassNotFoundException e) {
            // this might be thrown by ois.readObject()
            e.printStackTrace();
    } finally {

            // make sure to close the files!
            try {
                fos.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static boolean checkExisting(String s, List<Student> list){    
        for(Student stud: list){
            if(s.equals(stud.getStudentNumber()))
                return true;
        }
        return false;
    }
}


  