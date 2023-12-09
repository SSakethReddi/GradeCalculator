import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Constants for grade weights
        final double HOMEWORK_WEIGHT = 0.20;   // 20% of Total Grade
        final double QUIZ_WEIGHT = 0.05;       // 5% of Total Grade
        final double MIDTERM_WEIGHT = 0.25;    // 25% of Total Grade
        final double FINALEXAM_WEIGHT = 0.30;  // 30% of Total Grade
        final double FINALPROJECT_WEIGHT = 0.20; // 20% of Total Grade

        // Maximum scores for each category
        final int MAX_HOMEWORK_SCORE = 20;
        final int MAX_QUIZ_SCORE = 10;
        final int MAX_MIDTERM_SCORE = 100;
        final int MAX_FINALEXAM_SCORE = 100;
        final int MAX_FINALPROJECT_SCORE = 100;

        System.out.print("Enter the student's name: ");
        String studentName = scanner.nextLine();

        // Input and print scores for each homework
        double homeworkTotal = 0;
        for (int i = 1; i <= 8; i++) {
            double homeworkScore = getScore(scanner, "Homework " + i, MAX_HOMEWORK_SCORE);
            homeworkTotal += homeworkScore;
            System.out.println("You got " + homeworkScore + " out of " + MAX_HOMEWORK_SCORE + " for Homework " + i);
        }

        // Calculate homework average
        double homeworkAverage = homeworkTotal / 8;

        // Input and print scores for each quiz
        double quizTotal = 0;
        for (int i = 1; i <= 5; i++) {
            double quizScore = getScore(scanner, "Quiz " + i, MAX_QUIZ_SCORE);
            quizTotal += quizScore;
            System.out.println("\nYou scored " + quizScore + " out of " + MAX_QUIZ_SCORE + " for Quiz " + i );
        }

        // Calculate quiz average
        double quizAverage = quizTotal / 5;

        // Input scores for other categories
        double midtermScore = getScore(scanner, "Mid-Term Exam", MAX_MIDTERM_SCORE);
        System.out.println("You scored " + midtermScore + " out of " + MAX_MIDTERM_SCORE + " for Mid-Term Exam");
        double finalExamScore = getScore(scanner, "Final Exam", MAX_FINALEXAM_SCORE);
        System.out.println("You scored " + finalExamScore + " out of " + MAX_FINALEXAM_SCORE + " for Final Exam");
        double finalProjectScore = getScore(scanner, "Final Project", MAX_FINALPROJECT_SCORE);
        System.out.println("You scored " + finalProjectScore + " out of " + MAX_FINALPROJECT_SCORE + " for Final Project");
        // Calculate total grade
        double totalGrade = (homeworkAverage / MAX_HOMEWORK_SCORE * HOMEWORK_WEIGHT) +
                (quizAverage / MAX_QUIZ_SCORE * QUIZ_WEIGHT) +
                (midtermScore / MAX_MIDTERM_SCORE * MIDTERM_WEIGHT) +
                (finalExamScore / MAX_FINALEXAM_SCORE * FINALEXAM_WEIGHT) +
                (finalProjectScore / MAX_FINALPROJECT_SCORE * FINALPROJECT_WEIGHT);

        // Determine letter grade
        char letterGrade = calculateLetterGrade(totalGrade * 100); // Convert to percentage for letter grade calculation

        // Output the result
        System.out.println("\nStudent Name: " + studentName);
        System.out.println("\nThe Final Percentage You Got Is: " + totalGrade * 100 + "%"); // Convert to percentage for display
        System.out.println("\nThe Final Grade You Got Is: " + letterGrade);
    }

    private static double getScore(Scanner scanner, String assignmentType, int maxScore) {
        double score;
        

        do {
            System.out.print("\nEnter your marks for " + assignmentType + " that you scored for "+ maxScore + ":");
            score = scanner.nextDouble();

            if (score < 0 || score > maxScore) {
                System.out.println("Error: Your marks should be below " + maxScore + ":");
            }

        } while (score < 0 || score > maxScore);

        return score;
    }

    private static char calculateLetterGrade(double totalGrade) {
        if (totalGrade >= 92 && totalGrade <= 100) {
            return 'A';
        } else if (totalGrade >= 90 && totalGrade <= 91)  {
            return 'B';
        } else if (totalGrade >= 80 && totalGrade <= 89) {
            return 'C';
        } else if (totalGrade >= 70 && totalGrade <= 79) {
            return 'D';
        } else if (totalGrade >= 60 && totalGrade <= 69) {
            return 'E';
    
    
        } else {
            return 'F';
        }
    }
}
