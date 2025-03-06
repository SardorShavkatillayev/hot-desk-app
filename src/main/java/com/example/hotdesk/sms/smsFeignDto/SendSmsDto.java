package com.example.hotdesk.sms.smsFeignDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SendSmsDto {

    @JsonProperty("mobile_phone")
    private String phoneNumber;

    private String message;
    private String from;
}
