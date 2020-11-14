// Copyright (c) .NET Foundation. All rights reserved.
// Licensed under the Apache License, Version 2.0. See License.txt in the project root for license information.

package csmp.signalr;

import csmp.signalr.HubMessage;
import csmp.signalr.HubMessageType;

class InvocationMessage extends csmp.signalr.HubMessage {
    private final int type = csmp.signalr.HubMessageType.INVOCATION.value;
    private final String invocationId;
    private final String target;
    private final Object[] arguments;

    public InvocationMessage(String invocationId, String target, Object[] args) {
        this.invocationId = invocationId;
        this.target = target;
        this.arguments = args;
    }

    public String getInvocationId() {
        return invocationId;
    }

    public String getTarget() {
        return target;
    }

    public Object[] getArguments() {
        return arguments;
    }

    @Override
    public csmp.signalr.HubMessageType getMessageType() {
        return csmp.signalr.HubMessageType.INVOCATION;
    }
}
