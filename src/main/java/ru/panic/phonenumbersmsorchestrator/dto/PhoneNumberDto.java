package ru.panic.phonenumbersmsorchestrator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhoneNumberDto {
    private String id;

    @JsonProperty("phone_number")
    private String phoneNumber;
}
