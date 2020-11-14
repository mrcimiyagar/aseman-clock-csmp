package csmp.callbacks.terminal;

import csmp.models.Entities;

public interface OnTextMessageCreated {
    void textMessageCreated(Entities.Message textMessage);
}
