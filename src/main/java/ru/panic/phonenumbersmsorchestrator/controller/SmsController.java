package ru.panic.phonenumbersmsorchestrator.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.panic.phonenumbersmsorchestrator.dto.SmsDto;
import ru.panic.phonenumbersmsorchestrator.service.SmsService;

@RestController
@RequestMapping("/api/v1/sms")
@RequiredArgsConstructor
public class SmsController {

    private final SmsService smsService;

    @PostMapping
    public ResponseEntity<SmsDto> create(@RequestParam("phone_number_id") String phoneNumberId,
                                         @RequestParam("message") String message) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(smsService.create(phoneNumberId, message));
    }

    @PostMapping("/getByPhoneNumberIdAndDelete")
    public ResponseEntity<SmsDto> getByPhoneNumberIdAndDelete(@RequestParam("phone_number_id") String phoneNumberId) {
        return ResponseEntity.ok()
                .body(smsService.getByPhoneNumberIdAndDelete(phoneNumberId));
    }
}
