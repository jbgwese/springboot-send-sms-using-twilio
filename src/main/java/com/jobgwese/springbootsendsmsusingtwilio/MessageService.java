package com.jobgwese.springbootsendsmsusingtwilio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    private final SmsSender smsSender;

    @Autowired
    public MessageService(@Qualifier("twilio") TwilioSmsSender smsSender) {
        this.smsSender = smsSender;
    }

    public void sendMessage(SmsRequest smsRequest){
        smsSender.sendSms(smsRequest);
    }
}
