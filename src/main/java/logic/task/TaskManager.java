package logic.task;


import interfaces.Duplicatable;

import java.util.ArrayList;

public class TaskManager {
	public static ArrayList<Task> getTaskByType(ArrayList<Class> types) {
    	// TODO implement this method
        ArrayList<Task> tasks = TaskList.getTasks();
        ArrayList<Task> returnTasks = new ArrayList<>();
        for(Task task : tasks){
            for(Class type : types){
                if (type.isAssignableFrom(task.getClass())) {
                    returnTasks.add(task);
                    break;
                }
            }
        }
        return returnTasks;
    }

    public static void deleteDuplicateTasks() {

        ArrayList<Task> tasks = TaskList.getTasks();

        java.util.Iterator<Task> iterator = tasks.iterator();

        while (iterator.hasNext()) {
            Task task = iterator.next();

            if (instanceOf(task.getClass(), Duplicatable.class)
                    && task.toString().contains("-")) {

                iterator.remove();
            }
        }
    }

    public static boolean instanceOf(Class checkClass, Class interfaceClass) {
        return interfaceClass.isAssignableFrom(checkClass);
    }
}
