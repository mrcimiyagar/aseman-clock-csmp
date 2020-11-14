// Copyright (c) .NET Foundation. All rights reserved.
// Licensed under the Apache License, Version 2.0. See License.txt in the project root for license information.

package csmp.signalr;

import csmp.signalr.HubMessage;
import csmp.signalr.HubMessageType;

final class CancelInvocationMessage extends csmp.signalr.HubMessage {
    private final int type = csmp.signalr.HubMessageType.CANCEL_INVOCATION.value;
    private final String invocationId;

    public CancelInvocationMessage(String invocationId) {
        this.invocationId = invocationId;
    }

    @Override
    public csmp.signalr.HubMessageType getMessageType() {
        return csmp.signalr.HubMessageType.CANCEL_INVOCATION;
    }
}
