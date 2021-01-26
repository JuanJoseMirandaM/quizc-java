package org.fundacionjala.app.quizz.console;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.fundacionjala.app.quizz.model.Question;

public class QuestionInputHandler {

    public Set<String> askQuestionValue(Question question) {
        System.out.println("Question: " + question.getTitle());
        return getAnswer(question);
    }

    private Set<String> getAnswer(Question question) {
        Set<String> answers = new HashSet<>();
        if (question.getType().getConfiguration().hasAdditionalData()) {
            answers.add(collectAnswerFromOptions(question));
        } else {
            String ejemplo = "";
            switch (question.getType().getName()){
                case "Text":
                    ejemplo = "Este es un texto";
                    break;
                case "Date":
                    ejemplo = "26/01/2021";
                    break;
                case "Pick One":
                    ejemplo = "masculino/femenino";
                    break;
                case "Numeric":
                    ejemplo = "22";
                    break;
            }
            System.out.print(question.getType().getName()+" (Ej. "+ejemplo+ ") value: ");
//            String value = System.console().readLine();
            Scanner scanner = new Scanner(System.in);
            String value = scanner.nextLine();
            answers.add(value);
        }

        return answers;
    }

    private String collectAnswerFromOptions(Question question) {
        String answer = null;

        while (true) {
            showOptions(question);
            char option = readOption();
            if (option == '0') {
                break;
            }
        }

        return answer;
    }

    private void showOptions(Question question) {
        System.out.println("Select an option: ");
        for (int index = 0; index < question.getAdditionalData().size(); index++) {
            System.out.printf("%d. %s" + System.lineSeparator(), index + 1, question.getAdditionalData().get(index));
        }
        System.out.println("0. To Finish");
    }

    private char readOption() {
        System.out.print("> ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim().charAt(0);
//        return System.console().readLine().trim().charAt(0);
    }
}
