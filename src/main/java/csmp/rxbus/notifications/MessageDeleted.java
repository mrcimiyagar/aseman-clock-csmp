package csmp.rxbus.notifications;

import csmp.models.Entities;

public class MessageDeleted {

    private Entities.Message message;

    public MessageDeleted(Entities.Message message) {
        this.message = message;
    }

    public Entities.Message getMessage() {
        return message;
    }
}
