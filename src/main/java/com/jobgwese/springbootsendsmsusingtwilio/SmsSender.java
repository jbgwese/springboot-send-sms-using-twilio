package com.jobgwese.springbootsendsmsusingtwilio;

public interface SmsSender {
    void sendSms(SmsRequest smsRequest);
}
