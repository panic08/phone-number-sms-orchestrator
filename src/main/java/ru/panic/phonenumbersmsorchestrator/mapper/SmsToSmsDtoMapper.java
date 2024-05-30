package ru.panic.phonenumbersmsorchestrator.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.panic.phonenumbersmsorchestrator.dto.SmsDto;
import ru.panic.phonenumbersmsorchestrator.model.Sms;

@Mapper(componentModel = "spring")
public interface SmsToSmsDtoMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "phoneNumberId", target = "phoneNumberId"),
            @Mapping(source = "message", target = "message")
    })
    SmsDto smsToSmsDto(Sms sms);
}
