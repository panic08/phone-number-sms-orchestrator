package ru.panic.phonenumbersmsorchestrator.component;

import lombok.Getter;
import org.springframework.stereotype.Component;
import ru.panic.phonenumbersmsorchestrator.model.Sms;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class SmsComponent {
    private final List<Sms> smsList = new ArrayList<>();

}
