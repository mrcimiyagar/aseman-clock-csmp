package csmp.rxbus.notifications;

import csmp.models.Entities;

public class ComplexCreated {

    private Entities.Complex complex;

    public ComplexCreated(Entities.Complex complex) {
        this.complex = complex;
    }

    public Entities.Complex getComplex() {
        return complex;
    }
}
