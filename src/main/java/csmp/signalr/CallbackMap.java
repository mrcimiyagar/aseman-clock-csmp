// Copyright (c) .NET Foundation. All rights reserved.
// Licensed under the Apache License, Version 2.0. See License.txt in the project root for license information.

package csmp.signalr;

import csmp.signalr.ActionBase;
import csmp.signalr.InvocationHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

class CallbackMap {
    private final Map<String, List<InvocationHandler>> handlers = new HashMap<>();
    private final ReentrantLock lock = new ReentrantLock();

    public InvocationHandler put(String target, csmp.signalr.ActionBase action, Class<?>... classes) {
        try {
            lock.lock();
            InvocationHandler handler = new InvocationHandler(action, classes);
            if (!handlers.containsKey(target)) {
                handlers.put(target, new ArrayList<>());
            }
            handlers.get(target).add(handler);
            return handler;
        } finally {
            lock.unlock();
        }
    }

    public void clear() {
        try {
            lock.lock();
            handlers.clear();
        } finally {
            lock.unlock();
        }
    }

    public List<InvocationHandler> get(String key) {
        try {
            lock.lock();
            return handlers.get(key);
        } finally {
            lock.unlock();
        }
    }

    public void remove(String key) {
        try {
            lock.lock();
            handlers.remove(key);
        } finally {
            lock.unlock();
        }
    }
}
