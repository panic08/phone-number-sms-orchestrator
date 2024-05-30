package ru.panic.phonenumbersmsorchestrator.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.panic.phonenumbersmsorchestrator.component.PhoneNumberComponent;
import ru.panic.phonenumbersmsorchestrator.component.SmsComponent;
import ru.panic.phonenumbersmsorchestrator.dto.SmsDto;
import ru.panic.phonenumbersmsorchestrator.mapper.SmsToSmsDtoMapperImpl;
import ru.panic.phonenumbersmsorchestrator.model.Sms;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SmsService {

    private final SmsComponent smsComponent;
    private final PhoneNumberComponent phoneNumberComponent;
    private final SmsToSmsDtoMapperImpl smsToSmsDtoMapper;

    public SmsDto create(String phoneNumberId, String message) {
        Sms newSms = Sms.builder()
                .id(UUID.randomUUID().toString())
                .phoneNumberId(phoneNumberId)
                .message(message)
                .build();

        smsComponent.getSmsList().add(newSms);
        return smsToSmsDtoMapper.smsToSmsDto(newSms);
    }

    public SmsDto getByPhoneNumberIdAndDelete(String phoneNumberId) {
        Sms currentSms = smsComponent.getSmsList().stream()
                .filter(p -> p.getPhoneNumberId().equals(phoneNumberId))
                .findFirst()
                .orElse(null);

        if (currentSms != null) {
            smsComponent.getSmsList().remove(currentSms);

            //delete phoneNumber by phoneNumberId
            phoneNumberComponent.getPhoneNumbers().stream()
                    .filter(p -> p.getId().equals(phoneNumberId))
                    .findFirst()
                    .ifPresent(phoneNumber -> phoneNumberComponent.getPhoneNumbers().remove(phoneNumber));
        } else {
            currentSms = Sms.builder().build();
        }

        return smsToSmsDtoMapper.smsToSmsDto(currentSms);
    }
}
