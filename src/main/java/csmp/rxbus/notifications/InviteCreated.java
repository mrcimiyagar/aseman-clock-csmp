package csmp.rxbus.notifications;

import csmp.models.Entities;

public class InviteCreated {

    private Entities.Invite invite;

    public InviteCreated(Entities.Invite invite) {
        this.invite = invite;
    }

    public Entities.Invite getInvite() {
        return invite;
    }
}
