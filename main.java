
import java.util.ArrayList;
import java.util.Scanner;

class Task {
    String description;
    boolean isCompleted;

    Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }

    @Override
    public String toString() {
        return description + (isCompleted ? " (Выполнено)" : " (Не выполнено)");
    }
}

public class TaskScheduler {
    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("\nВведите операцию (1: Добавить, 2: Удалить, 3: Отметить, 4: Просмотреть, 5: Выйти): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Введите название задачи: ");
                    scanner.nextLine(); // Consume newline
                    String description = scanner.nextLine();
                    tasks.add(new Task(description));
                    System.out.println("Задача добавлена.");
                    break;
                case 2:
                    System.out.print("Введите индекс задачи для удаления: ");
                    int index = scanner.nextInt();
                    if (index >= 0 && index < tasks.size()) {
                        tasks.remove(index);
                        System.out.println("Задача удалена.");
                    } else {
                        System.out.println("Неверный индекс.");
                    }
                    break;
                case 3:
                    System.out.print("Введите индекс задачи для отметки: ");
                    int completeIndex = scanner.nextInt();
                    if (completeIndex >= 0 && completeIndex < tasks.size()) {
                        tasks.get(completeIndex).isCompleted = true;
                        System.out.println("Задача отмечена как выполненная.");
                    } else {
                        System.out.println("Неверный индекс.");
                    }
                    break;
                case 4:
                    System.out.println("Список задач:");
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println(i + ": " + tasks.get(i));
                    }
                    break;
                case 5:
                    System.out.println("Выход из системы.");
                    return;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }
}
