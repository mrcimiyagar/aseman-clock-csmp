package csmp.rxbus.notifications;

import csmp.models.Entities;

public class UserClickedBotView {
    private Entities.Complex complex;
    private Entities.BaseRoom room;
    private Entities.User user;
    private String controlId;

    public UserClickedBotView(Entities.Complex complex, Entities.BaseRoom room, Entities.User user, String controlId) {
        this.complex = complex;
        this.room = room;
        this.user = user;
        this.controlId = controlId;
    }

    public Entities.Complex getComplex() {
        return complex;
    }

    public Entities.BaseRoom getRoom() {
        return room;
    }

    public Entities.User getUser() {
        return user;
    }

    public String getControlId() {
        return controlId;
    }
}
