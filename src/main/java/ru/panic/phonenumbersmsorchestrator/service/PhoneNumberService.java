package ru.panic.phonenumbersmsorchestrator.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.panic.phonenumbersmsorchestrator.component.PhoneNumberComponent;
import ru.panic.phonenumbersmsorchestrator.dto.PhoneNumberDto;
import ru.panic.phonenumbersmsorchestrator.mapper.PhoneNumberToPhoneNumberDtoMapperImpl;
import ru.panic.phonenumbersmsorchestrator.model.PhoneNumber;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PhoneNumberService {

    private final PhoneNumberComponent phoneNumberComponent;
    private final PhoneNumberToPhoneNumberDtoMapperImpl phoneNumberToPhoneNumberDtoMapper;

    public PhoneNumberDto getRandomSynchronized() {
        PhoneNumber synchronizedFirst = phoneNumberComponent.getSynchronizedFirstAndDelete();

        if (synchronizedFirst == null) {
            synchronizedFirst = PhoneNumber.builder().build();
        }

        return phoneNumberToPhoneNumberDtoMapper.phoneNumberToPhoneNumberDto(
                synchronizedFirst
        );
    }

    public PhoneNumberDto create(String phoneNumber) {
        PhoneNumber newPhoneNumber = PhoneNumber.builder()
                .id(UUID.randomUUID().toString())
                .phoneNumber(phoneNumber)
                .build();

        phoneNumberComponent.getPhoneNumbers().add(newPhoneNumber);

        return phoneNumberToPhoneNumberDtoMapper.phoneNumberToPhoneNumberDto(newPhoneNumber);
    }
}
