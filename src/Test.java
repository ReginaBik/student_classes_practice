import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        //COMPLETE THIS CLASS AFTER ALL THE OTHER CLASSES

        /*
        Write a code that asks user to if they would like join your classes
        If the answer is "Yes" from user,then ask user information; firstName, lastName, age, gender, class to join
        ***If user is age is not more than 20, do not allow them to join
        ***If user wants to join any other class except Math and Science, do not allow them to join

        REMEMBER - checkAge and checkClassName methods may throw exceptions. You have to handle them

        Keep asking users the question they would to like join until you have got 3 students overall
        Create MathStudent or ScienceStudent objects based on user's answer for the class they want to join
        Print a "Congratulations! You are registered for {className} class."

        Store all these 3 objects in a collection and print them

        EXPECTED OUTPUT OF THE PROGRAM:
        Print information of all 3 students
        Print how many students are MathStudent with message -> "Math students = {numberOfMathStudents}"
        Print how many students are ScienceStudent with message -> "Science students = {numberOfScienceStudents}"
         */


        Scanner scan = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        int mathStudents = 0;
        int scienceStudents = 0;

        do{
            System.out.println(UserQuestions.askToJoin);
            String joined = scan.next();
            if(joined.equalsIgnoreCase("y"))

                System.out.println(UserQuestions.askFirstName);
            //scan.nextLine();
                String fName = scan.nextLine();
                scan.nextLine();

                System.out.println(UserQuestions.askLastName);
                String lName = scan.nextLine();

                System.out.println(UserQuestions.askAge);
                int age = scan.nextInt();
                scan.nextLine();

                try {
                    Permission.checkAge(age);

                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
                System.out.println(UserQuestions.askGender);
                String whatGender = scan.next();

                System.out.println(UserQuestions.askClassName);
                String whatClassName = scan.nextLine();
                scan.nextLine();

                try {
                    Permission.checkClassName(whatClassName);

              //
                if (whatClassName.equalsIgnoreCase("science")) {
                    scienceStudents++;
                    System.out.println("\nCongratulations! You are registered for " + whatClassName + " class.");
                    Student student = new ScienceStudent(fName, lName, age, whatGender, whatClassName);
                    students.add(student);
                } else if (whatClassName.equalsIgnoreCase("math")) {
                    mathStudents++;
                    System.out.println("\nCongratulations! You are registered for " + whatClassName + " class.");
                    students.add(new MathStudent(fName, lName, age, whatGender, whatClassName));
                }
                } catch (Exception e) {
                e.printStackTrace();
                break;
                }

        } while (students.size() < 3);

        for (Student s : students){
            System.out.println(s);
        }
        if(students.size() == 3){
            System.out.println("Science students " + scienceStudents);
            System.out.println("Math students " + mathStudents);
        }

    }
}
