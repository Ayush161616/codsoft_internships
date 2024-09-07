import java.util.Scanner;

public class studentgradecalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of subjects: ");
        int numSubject = sc.nextInt();
        int totalMArks = 0;
        for(int i = 1; i<=numSubject;i++)
        {
            System.out.print("Enter marks obtained in subjects"+i+":" );
            int marks = sc.nextInt();
            totalMArks += marks;

        }
        double averagePercentage = (double) totalMArks/(numSubject * 100)*100;
        char grade;
        if(averagePercentage>=90){
            grade = 'A';

        } else if (averagePercentage>=80) {
            grade = 'B';

        }
        else if (averagePercentage>=70){
            grade = 'C';

        }
        else if (averagePercentage>=60){
            grade = 'D';
        }
        else {
            grade = 'F';
        }
        System.out.println("---------------------------------------------------------");
        System.out.println("Total marks : "+totalMArks);
        System.out.println("Average percentage:" + averagePercentage+" % ");
        System.out.println("Grade: "+grade);
        sc.close();
    }
}
