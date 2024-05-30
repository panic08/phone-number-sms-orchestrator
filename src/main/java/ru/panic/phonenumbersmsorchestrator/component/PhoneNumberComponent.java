package ru.panic.phonenumbersmsorchestrator.component;

import lombok.Getter;
import org.springframework.stereotype.Component;
import ru.panic.phonenumbersmsorchestrator.model.PhoneNumber;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class PhoneNumberComponent {
    private final List<PhoneNumber> phoneNumbers = new ArrayList<>();

    public synchronized PhoneNumber getSynchronizedFirstAndDelete() {
        PhoneNumber phoneNumber;

        if (phoneNumbers.isEmpty()) {
            return null;
        } else {
            phoneNumber = phoneNumbers.get(0);

            phoneNumbers.remove(phoneNumber);
        }

        return phoneNumber;
    }
}
