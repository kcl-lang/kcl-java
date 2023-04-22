package com.kclvm;

import org.junit.Test;

import com.kclvm.client.ClientSingleton;
import com.kclvm.config.ConfigOptions;

public class ClientSingletonTest {
    @Test
    public void testConfig() {
        ConfigOptions configOptions = new ConfigOptions.Builder().endPoint("http://127.0.0.1:2021").build();
        ClientSingleton.getInstance().configClient(configOptions);
    }

    @Test(expected = RuntimeException.class)
    public void testEmptyEP() {
        ConfigOptions configOptions = new ConfigOptions.Builder().build();
        ClientSingleton.getInstance().configClient(configOptions);
    }
}
