package csmp.rxbus.notifications;

import csmp.models.Entities;

public class RoomProfileUpdated {

    private Entities.Room room;

    public RoomProfileUpdated(Entities.Room room) {
        this.room = room;
    }

    public Entities.Room getRoom() {
        return room;
    }
}
