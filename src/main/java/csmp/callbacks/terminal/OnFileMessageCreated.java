package csmp.callbacks.terminal;

import csmp.models.Entities;

public interface OnFileMessageCreated {
    void fileMessageCreated(Entities.Message message);
}
