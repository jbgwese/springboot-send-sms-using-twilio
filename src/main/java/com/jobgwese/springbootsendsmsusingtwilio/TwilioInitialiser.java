package com.jobgwese.springbootsendsmsusingtwilio;

import com.twilio.Twilio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class TwilioInitialiser {
    private final TwilioConfig twilioConfig;

    @Autowired
    public TwilioInitialiser(TwilioConfig twilioConfig) {
        this.twilioConfig = twilioConfig;
        Twilio.init(
                twilioConfig.getAccountSid(),
                twilioConfig.getAuthToken()
        );
        log.info("initialised twilio with account_sid -> {}" + twilioConfig.getAccountSid());
    }


}
