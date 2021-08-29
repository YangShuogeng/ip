package task_manipulation;

import exceptions.DukeTaskInputException;
import system_output.Output_On_Screen;
import task_classes.Task;
import user_input.Input_Parser;

import java.util.Vector;

public class MarkAsDone {

    /**
     * The method to mark the task status as done
     * If the is not format "done + Integer", system will add the entire input as Todo type task into the entire task list
     *
     * @param list the entire task list
     * @param inputWords the string array of the user input
     */
    public static void markAsDone(Vector<Task> list, String[] inputWords) throws DukeTaskInputException {
        if(list.isEmpty()){
            throw new DukeTaskInputException(inputWords[0], "listIsEmtpy");
        }

        if (inputWords.length == 2) {
            if (inputWords[1].matches("\\d+")) {// check whether the second string is an integer

                System.out.println("The Task to mark: " + Integer.parseInt(inputWords[1]));
                System.out.println("The Task list size: " + list.size());

                if (Integer.parseInt(inputWords[1]) > 0) {
                    if (Integer.parseInt(inputWords[1]) > list.size()) {
                        throw new DukeTaskInputException(inputWords[0], "Interesting");
                    }
                    list.get(Integer.parseInt(inputWords[1]) - 1).markAsDone();
                    Output_On_Screen.printMarkAsDoneOutput(list, Integer.parseInt(inputWords[1]) - 1);

                    return;
                } else {
                    throw new DukeTaskInputException(inputWords[0], "markAsDoneTaskNumberNotInTaskList");
                }
            } else {
                throw new DukeTaskInputException(inputWords[0], "markAsDoneTaskNumberOutOfRange");
            }
        }

        throw new DukeTaskInputException(inputWords[0], "markAsDoneFormatWrong");
    }
}
