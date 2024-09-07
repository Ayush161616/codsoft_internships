import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// this is the last task of codesoft internship which is tittle is student cource registration system
public class Cource {
    private String courceCode;
    private String tittle;
    private String description;
    private int capacity;
    private String schedule;
    private int availableSlots;
     public Cource(String courceCode, String tittle,String description, int capacity, String schedule){
         this.courceCode=courceCode;
         this.tittle=tittle;
         this.description=description;
         this.capacity=capacity;
         this.schedule=schedule;
         this.availableSlots = capacity;
     }
     public String getCourceCode(){
         return courceCode;
     }
     public String getTittle(){
         return tittle;
     }
     public String getDescription(){
         return description;
     }
     public int getAvailableSlots(){
         return availableSlots;
     }
     public boolean registerStudent(){
         if (availableSlots>0){
             availableSlots--;
             return true;
         }
         return false;
     }
     public void dropStudent(){
         if (availableSlots<capacity){
             availableSlots++;
         }
     }
     public String toString(){
         return "Cource Code: "+courceCode+"\nTitle: "+tittle+"\nDescription: "+description+"\nSchedule: "+schedule+ "\nAvailable Slots: "+availableSlots+ "/" + capacity+ "\n";
     }

}
class student {
  private int StudentID;
  private String name;
  private ArrayList<Cource>registeredCources;
  public student(int StudentID,String name) {
      this.StudentID = StudentID;
      this.name = name;
      this.registeredCources = new ArrayList<>();


  }
  public int getStudentID(){
      return StudentID;

  }




    public String getName(){
      return name;

  }
  public List<Cource>getRegisteredCources(){
      return registeredCources;

  }
  public void RegisteredCources(Cource cource){
      if(cource.registerStudent()){
          registeredCources.add(cource);
      }
  }
  public void dropCources(Cource cource){
      cource.dropStudent();
      registeredCources.remove(cource);

  }
  public String toString(){
      StringBuilder coursesList = new StringBuilder();
      for (Cource cource : registeredCources){
          coursesList.append(cource.getTittle()).append(" ,");
      }
      return "Student ID: "+StudentID + "\nNAme: "+ name +"\n Registered Cources: "+(coursesList.length()>0 ? coursesList.substring(0,coursesList.length()-2) : "None") + "\n";
  }

}
 class LastTask {
    private List<student> Students;
    private List<Cource> cources;


    public LastTask() {
        Students = new ArrayList<>();
        cources = new ArrayList<>();

    }

    public void addStudent(student Student) {
        Students.add(Student);
    }

    public void addCources(Cource cource) {
        cources.add(cource);
    }

    public Cource findCourceByCode(String courcesCode) {
        for (Cource cource : cources) {
            if (cource.getCourceCode().equals(courcesCode)) {
                return cource;
            }

        }
        return null;

    }

    public student findStudentById(int studentId) {
        for (student students : Students) {
            if (students.getStudentID() == studentId) {
                return students;

            }
        }
        return null;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LastTask system = new LastTask();
        // Add additional students and cources here
        system.addStudent(new student(1, "Ayush Tiwari"));
        system.addStudent(new student(2, "Aman Patel"));
        system.addCources(new Cource("IT101", "Introduction to Programming", "Learn the Basicsn of programming", 50, "Mon , Wed 9:00 - 10:30 AM"));
        system.addCources(new Cource("MATH202", "Advance Mathematics", "Advance with concepts", 40, "Tue , Thu 11:00 Am - 12:30 PM"));
        while (true) {
            System.out.println("Student Cources Registration System");
            System.out.println("1. Register Cource");
            System.out.println("2. Drop Cource");
            System.out.println("3. Display Student Info");
            System.out.println("4. Exit");
            System.out.println("Select an option: ");
            int choice = sc.nextInt();
            sc.nextLine();
            // consume new Line
            switch (choice) {
                case 1:
                    System.out.print("Enter Student Id: ");
                    int studentID = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Cource Code: ");
                    String courceCode = sc.nextLine();
                    student Students = system.findStudentById(studentID);
                    Cource cource = system.findCourceByCode(courceCode);
                    if (Students != null && cource != null) {
                        Students.RegisteredCources(cource);
                        System.out.print("COURCE REGISTERED SUCESSFULLY.");


                    } else {
                        System.out.println("Students or cources not found");

                    }
                    break;
                case 2:
                    System.out.println("Enter Student Id: ");
                    int studentIDDrop = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Cource Code: ");
                    String courceCodeDrop = sc.nextLine();
                    student studentDrop = system.findStudentById(studentIDDrop);
                    Cource courceDrop = system.findCourceByCode(courceCodeDrop);
                    if (studentDrop != null && courceDrop != null) {
                        studentDrop.dropCources(courceDrop);
                        System.out.println("COURCE DROPPED SUCESSFULLY");

                    }
                    break;
                case 3:
                    System.out.println("Enter Student Id: ");
                    int studentIDInfo = sc.nextInt();
                    student studentinfo = system.findStudentById(studentIDInfo);

                    if (studentinfo != null) {
                        //  studentDrop.dropCources(courceDrop);
                        System.out.println("STUDENT INFORMATION\n");

                    } else {
                        System.out.println("STUDENTS NOT FOUND.");

                    }
                    break;
                case 4:
                    System.out.println("EXISTING STUDENT COURCE REGISTRATION SYSTEM. ");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println(" INVALID COUCRCES PLEASE CHOOSE VALID OPTION");
            }


        }
    }
}


