package csmp.rxbus.notifications;

import csmp.models.Entities;

public class RoomRemoved {

    private Entities.Room room;

    public RoomRemoved(Entities.Room room) {
        this.room = room;
    }

    public Entities.Room getRoom() {
        return room;
    }
}
