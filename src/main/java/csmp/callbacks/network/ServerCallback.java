package csmp.callbacks.network;

import csmp.models.Packet;

public interface ServerCallback {
    void onRequestSuccess(Packet packet);
    void onServerFailure();
    void onConnectionFailure();
}
