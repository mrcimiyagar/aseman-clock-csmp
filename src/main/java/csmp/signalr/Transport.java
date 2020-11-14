// Copyright (c) .NET Foundation. All rights reserved.
// Licensed under the Apache License, Version 2.0. See License.txt in the project root for license information.

package csmp.signalr;

import io.reactivex.Completable;
import csmp.signalr.OnReceiveCallBack;
import csmp.signalr.TransportOnClosedCallback;

interface Transport {
    Completable start(String url);
    Completable send(String message);
    void setOnReceive(OnReceiveCallBack callback);
    void onReceive(String message);
    void setOnClose(TransportOnClosedCallback onCloseCallback);
    Completable stop();
}
