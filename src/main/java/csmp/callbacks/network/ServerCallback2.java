package csmp.callbacks.network;

import csmp.models.Packet;

public interface ServerCallback2 {
    void onRequestSuccess(Packet packet);
    void onLogicalError(String errorCode);
    void onServerFailure();
    void onConnectionFailure();
}
