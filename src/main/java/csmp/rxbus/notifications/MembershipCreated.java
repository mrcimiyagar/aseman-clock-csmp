package csmp.rxbus.notifications;

import csmp.models.Entities;

public class MembershipCreated {

    private Entities.Membership membership;

    public MembershipCreated(Entities.Membership membership) {
        this.membership = membership;
    }

    public Entities.Membership getMembership() {
        return membership;
    }
}
