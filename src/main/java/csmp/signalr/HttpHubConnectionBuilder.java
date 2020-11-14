// Copyright (c) .NET Foundation. All rights reserved.
// Licensed under the Apache License, Version 2.0. See License.txt in the project root for license information.

package csmp.signalr;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Single;
import csmp.signalr.HttpClient;
import csmp.signalr.HubConnection;
import csmp.signalr.Transport;
import csmp.signalr.TransportEnum;

/**
 * A builder for configuring {@link csmp.signalr.HubConnection} instances.
 */
public class HttpHubConnectionBuilder {
    private final String url;
    private csmp.signalr.Transport transport;
    private csmp.signalr.HttpClient httpClient;
    private boolean skipNegotiate;
    private Single<String> accessTokenProvider;
    private long handshakeResponseTimeout = 0;
    private Map<String, String> headers;
    private csmp.signalr.TransportEnum transportEnum;

    HttpHubConnectionBuilder(String url) {
        this.url = url;
    }

    //For testing purposes. The Transport interface isn't public.
    HttpHubConnectionBuilder withTransportImplementation(csmp.signalr.Transport transport) {
        this.transport = transport;
        return this;
    }

    /**
     * Sets the transport type to indicate which transport to be used by the {@link csmp.signalr.HubConnection}.
     *
     * @param transportEnum The type of transport to be used.
     * @return This instance of the HttpHubConnectionBuilder.
     */
    public HttpHubConnectionBuilder withTransport(TransportEnum transportEnum) {
        this.transportEnum = transportEnum;
        return this;
    }

    /**
     * Sets the {@link csmp.signalr.HttpClient} to be used by the {@link csmp.signalr.HubConnection}.
     *
     * @param httpClient The {@link csmp.signalr.HttpClient} to be used by the {@link csmp.signalr.HubConnection}.
     * @return This instance of the HttpHubConnectionBuilder.
     */
    HttpHubConnectionBuilder withHttpClient(csmp.signalr.HttpClient httpClient) {
        this.httpClient = httpClient;
        return this;
    }

    /**
     * Indicates to the {@link csmp.signalr.HubConnection} that it should skip the negotiate process.
     * Note: This option only works with the Websockets transport and the Azure SignalR Service require the negotiate step.
     *
     * @param skipNegotiate Boolean indicating if the {@link csmp.signalr.HubConnection} should skip the negotiate step.
     * @return This instance of the HttpHubConnectionBuilder.
     */
    public HttpHubConnectionBuilder shouldSkipNegotiate(boolean skipNegotiate) {
        this.skipNegotiate = skipNegotiate;
        return this;
    }

    /**
     * Sets the access token provider for the {@link csmp.signalr.HubConnection}.
     *
     * @param accessTokenProvider The access token provider to be used by the {@link csmp.signalr.HubConnection}.
     * @return This instance of the HttpHubConnectionBuilder.
     */
    public HttpHubConnectionBuilder withAccessTokenProvider(Single<String> accessTokenProvider) {
        this.accessTokenProvider = accessTokenProvider;
        return this;
    }

    /**
     * Sets the duration the {@link csmp.signalr.HubConnection} should wait for a Handshake Response from the server.
     *
     * @param timeoutInMilliseconds The duration (specified in milliseconds) that the {@link csmp.signalr.HubConnection} should wait for a Handshake Response from the server.
     * @return This instance of the HttpHubConnectionBuilder.
     */
    public HttpHubConnectionBuilder withHandshakeResponseTimeout(long timeoutInMilliseconds) {
        this.handshakeResponseTimeout = timeoutInMilliseconds;
        return this;
    }

    /**
     * Sets a collection of Headers for the {@link csmp.signalr.HubConnection} to send with every Http request.
     *
     * @param headers A Map representing the collection of Headers that the {@link csmp.signalr.HubConnection} should send.
     * @return This instance of the HttpHubConnectionBuilder.
     */
    public HttpHubConnectionBuilder withHeaders(Map<String, String> headers) {
        this.headers = headers;
        return this;
    }

    /**
     * Sets a single header for the {@link csmp.signalr.HubConnection} to send.
     *
     * @param name The name of the header to set.
     * @param value The value of the header to be set.
     * @return This instance of the HttpHubConnectionBuilder.
     */
    public HttpHubConnectionBuilder withHeader(String name, String value) {
        if (headers == null) {
            this.headers = new HashMap<>();
        }
        this.headers.put(name, value);
        return this;
    }

    /**
     * Builds a new instance of {@link csmp.signalr.HubConnection}.
     *
     * @return A new instance of {@link csmp.signalr.HubConnection}.
     */
    public csmp.signalr.HubConnection build() {
        return new HubConnection(url, transport, skipNegotiate, httpClient, accessTokenProvider, handshakeResponseTimeout, headers, transportEnum);
    }
}
