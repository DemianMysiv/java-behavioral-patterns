package org.example.task2;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Dispatcher {
    private final Stack<ScheduleCommand> history = new Stack<>();
    private final List<ScheduleCommand> batchQueue = new ArrayList<>();
    private final List<String> actionJournal = new ArrayList<>();

    public void executeAction(ScheduleCommand command) {
        log("Ініційовано виконання нової дії диспетчера");
        command.execute();
        history.push(command);
        actionJournal.add(command.getClass().getSimpleName() + " виконано миттєво.");
    }

    public void undoLastAction() {
        if (!history.isEmpty()) {
            log("Ініційовано скасування останньої дії");
            ScheduleCommand lastCommand = history.pop();
            lastCommand.undo();
            actionJournal.add(lastCommand.getClass().getSimpleName() + " скасовано.");
        } else {
            log("Історія дій порожня.");
        }
    }

    public void queueAction(ScheduleCommand command) {
        log("Дію додано до черги пакетного виконання");
        batchQueue.add(command);
    }

    public void executeBatch() {
        log("Ініційовано пакетне виконання " + batchQueue.size() + " команд");
        for (ScheduleCommand command : batchQueue) {
            command.execute();
            history.push(command);
            actionJournal.add(command.getClass().getSimpleName() + " виконано з пакету.");
        }
        batchQueue.clear();
    }

    public void printJournal() {
        System.out.println("\n--- Журнал дій диспетчера ---");
        for (String record : actionJournal) {
            System.out.println("- " + record);
        }
        System.out.println("-----------------------------");
    }

    private void log(String event) {
        String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.printf("[%s] [Dispatcher] %s%n", time, event);
    }
}
