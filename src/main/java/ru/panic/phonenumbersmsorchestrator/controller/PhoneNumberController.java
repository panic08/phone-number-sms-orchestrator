package ru.panic.phonenumbersmsorchestrator.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.panic.phonenumbersmsorchestrator.dto.PhoneNumberDto;
import ru.panic.phonenumbersmsorchestrator.service.PhoneNumberService;

@RestController
@RequestMapping("/api/v1/phone_number")
@RequiredArgsConstructor
public class PhoneNumberController {

    private final PhoneNumberService phoneNumberService;

    @GetMapping("/random/synchronize")
    public ResponseEntity<PhoneNumberDto> getRandomSynchronized() {
        return ResponseEntity.ok()
                .body(phoneNumberService.getRandomSynchronized());
    }

    @PostMapping
    public ResponseEntity<PhoneNumberDto> create(@RequestParam("phone_number") String phoneNumber) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(phoneNumberService.create(phoneNumber));
    }
}
