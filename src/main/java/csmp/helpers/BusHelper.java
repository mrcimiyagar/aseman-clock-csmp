package csmp.helpers;

import csmp.rxbus.Bus;
import csmp.rxbus.BusProvider;

public class BusHelper {

    public static Bus bus() {
        return BusProvider.getInstance();
    }
}
