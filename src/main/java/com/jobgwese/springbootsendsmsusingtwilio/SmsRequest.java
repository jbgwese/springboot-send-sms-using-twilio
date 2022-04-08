package com.jobgwese.springbootsendsmsusingtwilio;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@ToString
@Getter
public class SmsRequest {
    //to phone number
    @NotBlank
    private final String phoneNumber;
    @NotBlank
    private final String message;
    public SmsRequest(@JsonProperty("phoneNumber") String phoneNumber, @JsonProperty("message") String message) {
        this.phoneNumber = phoneNumber;
        this.message = message;
    }

}
