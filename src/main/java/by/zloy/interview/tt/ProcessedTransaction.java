package by.zloy.interview.tt;

import java.util.Optional;

public class ProcessedTransaction {
    String id;
    Optional<String> status;

    final String def = "DONE";

    public String getId() {
        return id;
    }

    public Optional<String> getStatus() {
        return status;
    }
}
