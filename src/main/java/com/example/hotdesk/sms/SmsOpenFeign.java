package com.example.hotdesk.sms;

import com.example.hotdesk.sms.smsFeignDto.LoginDto;
import com.example.hotdesk.sms.smsFeignDto.SendSmsDto;
import com.example.hotdesk.sms.smsFeignDto.SmsFeignClientLoginResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "smsOpenFeign", url ="notify.eskiz.uz/api" )
public interface SmsOpenFeign {

    @PostMapping("/auth/login")
    SmsFeignClientLoginResponseDto login(@RequestBody LoginDto loginDto);

    @PostMapping("/message/sms/send")
    String sendSms(@RequestBody SendSmsDto loginDto, @RequestHeader(name = "AUTHORIZATION") String token);




}
