package ru.panic.phonenumbersmsorchestrator.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.panic.phonenumbersmsorchestrator.dto.PhoneNumberDto;
import ru.panic.phonenumbersmsorchestrator.model.PhoneNumber;

@Mapper(componentModel = "spring")
public interface PhoneNumberToPhoneNumberDtoMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "phoneNumber", target = "phoneNumber")
    })
    PhoneNumberDto phoneNumberToPhoneNumberDto(PhoneNumber phoneNumber);
}
