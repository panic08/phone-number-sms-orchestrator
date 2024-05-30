package ru.panic.phonenumbersmsorchestrator.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Sms {
    private String id;

    private String phoneNumberId;

    private String message;
}
