package csmp.rxbus.notifications;

import csmp.models.Entities;

public class WorkerRemoved {

    private Entities.Workership workership;

    public WorkerRemoved(Entities.Workership workership) {
        this.workership = workership;
    }

    public Entities.Workership getWorkership() {
        return workership;
    }
}
