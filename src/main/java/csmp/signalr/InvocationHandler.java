// Copyright (c) .NET Foundation. All rights reserved.
// Licensed under the Apache License, Version 2.0. See License.txt in the project root for license information.

package csmp.signalr;

import csmp.signalr.ActionBase;

import java.util.Arrays;
import java.util.List;

class InvocationHandler {
    private final List<Class<?>> classes;
    private final csmp.signalr.ActionBase action;

    InvocationHandler(csmp.signalr.ActionBase action, Class<?>... classes) {
        this.action = action;
        this.classes = Arrays.asList(classes);
    }

    public List<Class<?>> getClasses() {
        return classes;
    }

    public csmp.signalr.ActionBase getAction() {
        return action;
    }
}