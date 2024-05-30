package ru.panic.phonenumbersmsorchestrator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SmsDto {
    private String id;

    @JsonProperty("phone_number_id")
    private String phoneNumberId;

    private String message;
}
