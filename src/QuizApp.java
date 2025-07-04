import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Question {
    private String questionText;
    private String[] options;
    private int correctOption; // Index of correct option (0-based)


    public Question(String questionText, String[] options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }


    public void displayQuestion() {
        System.out.println(questionText);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }


    public boolean isCorrect(int userAnswer) {
        return (userAnswer - 1) == correctOption;
    }
}


public class QuizApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Question> questions = new ArrayList<>();


        questions.add(new Question(
                "What is the capital of France?",
                new String[]{"Berlin", "Paris", "Madrid", "Rome"},
                1
        ));

        questions.add(new Question(
                "Which language is used for Android development?",
                new String[]{"Swift", "Kotlin", "Ruby", "C#"},
                1
        ));

        questions.add(new Question(
                "Who wrote 'Romeo and Juliet'?",
                new String[]{"Shakespeare", "Hemingway", "Tolstoy", "Orwell"},
                0
        ));

        int score = 0;

        System.out.println("=== Welcome to the Quiz ===\n");


        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("Question " + (i + 1) + ":");
            q.displayQuestion();

            System.out.print("Your answer (1-4): ");
            int answer = scanner.nextInt();

            if (q.isCorrect(answer)) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Wrong!\n");
            }
        }

        System.out.println("Quiz Over! You scored " + score + " out of " + questions.size() + ".");
        scanner.close();
    }
}
