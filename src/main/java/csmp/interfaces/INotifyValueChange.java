package csmp.interfaces;

import csmp.models.Codes;

public interface INotifyValueChange {
    void notifyValueChanged(String ctrlName, Codes.Value value);
}
