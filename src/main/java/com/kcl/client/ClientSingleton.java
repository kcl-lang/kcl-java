package com.kcl.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kcl.config.ConfigOptions;
import com.kcl.utl.Util;

public class ClientSingleton {
    public static final String DEFAULT_ENDPOINT = "http://127.0.0.1:2021";

    private static volatile ClientSingleton instance;
    private static Object mutex = new Object();

    private static final Logger log = LoggerFactory.getLogger(ClientSingleton.class);

    private Client client;

    public static ClientSingleton getInstance() {
        ClientSingleton localRef = instance;
        if (localRef == null) {
            synchronized (mutex) {
                localRef = instance;
                if (localRef == null) {
                    instance = localRef = new ClientSingleton();
                }
            }
        }
        return localRef;
    }

    public Client configClient(ConfigOptions configOptions) {
        this.client = configClient(this.client, configOptions);
        return this.client;
    }

    private Client configClient(Client client, ConfigOptions options) {
        if (client == null) {
            client = new Client();
        }
        if (options == null) {
            options = new ConfigOptions.Builder().endPoint(DEFAULT_ENDPOINT).build();
        }
        if (options != null) {
            log.info(String.format("config: endPoint[%s]", options.getEndPoint()));
            if (Util.isEmpty(options.getEndPoint())) {
                throw new RuntimeException("empty endPoint");
            }
            RestClient c = new RestClient(options.getEndPoint());
            client.setClient(c);
            c.healthCheck();
        }
        return client;
    }
}
