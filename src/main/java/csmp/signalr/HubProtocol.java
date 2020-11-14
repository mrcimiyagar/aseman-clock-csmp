// Copyright (c) .NET Foundation. All rights reserved.
// Licensed under the Apache License, Version 2.0. See License.txt in the project root for license information.

package csmp.signalr;

import csmp.signalr.HubMessage;
import csmp.signalr.InvocationBinder;
import csmp.signalr.TransferFormat;

/**
 * A protocol abstraction for communicating with SignalR hubs.
 */
interface HubProtocol {
    String getName();
    int getVersion();
    TransferFormat getTransferFormat();

    /**
     * Creates a new list of {@link csmp.signalr.HubMessage}s.
     * @param message A string representation of one or more {@link csmp.signalr.HubMessage}s.
     * @return A list of {@link csmp.signalr.HubMessage}s.
     */
    csmp.signalr.HubMessage[] parseMessages(String message, InvocationBinder binder);

    /**
     * Writes the specified {@link csmp.signalr.HubMessage} to a String.
     * @param message The message to write.
     * @return A string representation of the message.
     */
    String writeMessage(csmp.signalr.HubMessage message);
}
