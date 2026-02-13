package logic.task;

import interfaces.Computable;
import interfaces.Duplicatable;
import interfaces.Parallelizable;
import logic.compute.ProcessUnit;

public class RenderTask extends Task implements Computable, Parallelizable, Duplicatable {
    public RenderTask(String name,double workload){
        super(name,workload);
    }

    @Override
    public double compute(ProcessUnit processUnit) {
        return processUnit.compute(this);
    }

    @Override
    public double parallelCompute(ProcessUnit processUnit) {
        return processUnit.parallelCompute(this);
    }

    @Override
    public void duplicateTask(int taskNumber) {
        for(int i = 1;i<taskNumber+1;i++){
            RenderTask renderTask = new RenderTask(this.getName() + "-" + i,this.getWorkload());
            TaskList.addTasks(renderTask);
        }
        return;
    }

    @Override
    public String fullTaskName() {
        return "Rendering Task";
    }
}
