package csmp.rxbus.notifications;

import csmp.models.Entities;

public class UserProfileUpdated {

    private Entities.User user;

    public UserProfileUpdated(Entities.User user) {
        this.user = user;
    }

    public Entities.User getUser() {
        return user;
    }
}
