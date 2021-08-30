package user_input;

import exceptions.DukeTaskInputException;
import system_output.Output_On_Screen;
import task_classes.Task;
import task_manipulation.Add;
import task_manipulation.MarkAsDone;

import java.util.Scanner;
import java.util.Vector;

public class Input_Scanner {

    /**
     * To parse the user input information type
     *
     * @param List entire task list
     */
    public static void InputStart(Vector<Task> List){

        String input;
        Scanner in = new Scanner(System.in);
        input = in.nextLine();

        try {
            String[] inputWords = input.split(" ");
            String firstWord = inputWords[0].toLowerCase();

            Input_Parser.Input_Length_Checking(firstWord, inputWords);

            Output_On_Screen.toPrintSeparateLine();

            switch(firstWord) {
                case "bye":
                    Output_On_Screen.printGoodbyeOutput();
                    return;
                case "list":
                    Output_On_Screen.printOutList(List);
                    break;
                case "done":
                    MarkAsDone.markAsDone(List, inputWords);
                    break;
                case "deadline":
                    Add.addDeadlineTask(List, inputWords);
                    break;
                case "event":
                    Add.addEventTask(List, inputWords);
                    break;
                case "todo":
                    Add.addTodoTask(List, input.substring(5, input.length()));
            }
        } catch (DukeTaskInputException e) {
            String firstWord = DukeTaskInputException.getFirstWord();
            String errorType = DukeTaskInputException.getErrorType();

            switch(errorType){
                case "descriptionMissing":
                    switch(firstWord){
                        case "todo":
                        case "event":
                        case "deadline":
                            DukeTaskInputException.descriptionMissing(firstWord);
                            break;
                        default:
                            DukeTaskInputException.invalidFirstWordInput();
                            break;
                    }
                    break;
                case "dateTime":
                    DukeTaskInputException.dateTimeMissing();
                    break;
                case "markAsDoneTaskNumberMissing":
                    DukeTaskInputException.markAsDoneTaskNumberMissing();
                    break;
                case "markAsDoneTaskNumberNotInteger":
                    DukeTaskInputException.markAsDoneTaskNumberNotInteger();
                    break;
                case "markAsDoneTaskNumberNotInTaskList":
                    DukeTaskInputException.markAsDoneTaskNumberNotInTaskList();
                    break;
                case "markAsDoneFormatWrong":
                    DukeTaskInputException.markAsDoneFormatWrong();
                    break;
                case "markAsDoneTaskNumberOutOfRange":
                    DukeTaskInputException.markAsDoneTaskNumberOutOfRange();
                    break;
                case "Interesting":
                    DukeTaskInputException.Interesting();
                    break;
                case "listIsEmtpy":
                    DukeTaskInputException.listIsEmtpy();
                    break;
            }
        }

        InputStart(List);
    }
}