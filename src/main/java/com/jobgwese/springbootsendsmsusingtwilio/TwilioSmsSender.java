package com.jobgwese.springbootsendsmsusingtwilio;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("twilio")
@Slf4j
public class TwilioSmsSender implements SmsSender {
    private final TwilioConfig config;

    @Autowired
    public TwilioSmsSender(TwilioConfig config) {
        this.config = config;
    }

    @Override
    public void sendSms(SmsRequest smsRequest) {
        if (isPhoneNumberValid(smsRequest.getPhoneNumber())) {
            PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNumber());
            PhoneNumber from = new PhoneNumber(config.getTwilioPhoneNumber());
            String message = smsRequest.getMessage();
            MessageCreator creator = Message.creator(to, from, message);
            creator.create();
            log.info(""+ smsRequest);
        } else {
            throw new IllegalStateException("Your phone number ->{}" + smsRequest.getPhoneNumber() + "  is invalid");
        }

    }

    private boolean isPhoneNumberValid(String phoneNumber) {
        //TODO Phine number validation
        return true;
    }
}
