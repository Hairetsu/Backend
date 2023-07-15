package com.conectamayores.seniorconnectapi.config;

import com.pubnub.api.PNConfiguration;
import com.pubnub.api.PubNub;
import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PubNubConfig {

    @Value( "${pubnub.userId}")
    private String pubnubUserId;

    @Value("${pubnub.subscribeKey}")
    private String pubnubSubscribeKey;

    @Value("${pubnub.publishKey}")
    private String pubnubPublishKey;

    @Value("${pubnub.secretKey}")
    private String pubnubSecretKey;

    @Bean
    public PNConfiguration pubnubConfig() {
        val config = new PNConfiguration();
        config.setSubscribeKey(this.pubnubSubscribeKey);
        config.setPublishKey(this.pubnubPublishKey);
        config.setSecretKey(this.pubnubSecretKey);
        return config;
    }

    @Bean
    public PubNub pubNub(PNConfiguration pnconfiguration) {
        return new PubNub(pnconfiguration);
    }

}