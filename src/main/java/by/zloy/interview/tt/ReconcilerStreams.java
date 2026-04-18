package by.zloy.interview.tt;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public class ReconcilerStreams {

    public static void main(String[] args) {
        ReconcilerStreams reconcilerStreams = new ReconcilerStreams();
        PendingTransaction pendingTransaction = new PendingTransaction();
        pendingTransaction.id = 1L;
        Stream<PendingTransaction> stream1 = Stream.of(pendingTransaction);
        ProcessedTransaction processedTransaction = new ProcessedTransaction();
        processedTransaction.id = "1";
        processedTransaction.status = Optional.of("dOnE");
        Stream<Stream<ProcessedTransaction>> stream3 = Stream.of(Stream.of(processedTransaction));
        reconcilerStreams.reconcile(stream1, stream3).map(PendingTransaction::getId).forEach(System.out::println);
    }

    Stream<PendingTransaction> reconcile(Stream<PendingTransaction> pending, Stream<Stream<ProcessedTransaction>> processed) {

        if (Objects.isNull(processed) || Objects.isNull(pending)) {
            return Stream.empty();
        }

        final String DONE = "DONE";
        final List<Long> processedIds = processed.flatMap(s -> s)
                .filter(Objects::nonNull)
                .filter(o -> o.getStatus().isPresent() && DONE.equalsIgnoreCase(o.getStatus().get()))
                .map(ProcessedTransaction::getId)
                .filter(obj -> Objects.nonNull(obj) && !obj.trim().isEmpty())
                .map(Long::valueOf)
                .distinct()
                .toList();

        return pending
                .filter(Objects::nonNull)
                .filter(o -> Objects.nonNull(o.getId()) && processedIds.contains(o.getId()))
                .distinct();
    }
}
