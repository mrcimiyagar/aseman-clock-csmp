package csmp.rxbus.notifications;

import csmp.models.Entities;

public class WorkerAdded {

    private Entities.Workership workership;

    public WorkerAdded(Entities.Workership workership) {
        this.workership = workership;
    }

    public Entities.Workership getWorkership() {
        return workership;
    }
}
