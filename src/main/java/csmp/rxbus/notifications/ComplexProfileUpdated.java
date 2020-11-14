package csmp.rxbus.notifications;

import csmp.models.Entities;

public class ComplexProfileUpdated {

    private Entities.Complex complex;

    public ComplexProfileUpdated(Entities.Complex complex) {
        this.complex = complex;
    }

    public Entities.Complex getComplex() {
        return complex;
    }
}
