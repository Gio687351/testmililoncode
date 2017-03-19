package refactula.micro.futuristic.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class Futures {

    public static <T> Future<List<T>> transform(List<Future<T>> futures) {
        FutureImpl<List<T>> future = new FutureImpl<>();
        AtomicReferenceArray<Optional<T>> completedArray = new AtomicReferenceArray<>(futures.size());
        AtomicInteger countDown = new AtomicInteger(futures.size());
        for (int i = 0; i < futures.size(); i++) {
            int index = i;
            futures.get(i).map(value -> {
                if (completedArray.compareAndSet(index, null, Optional.ofNullable(value))) {
                    if (countDown.decrementAndGet() == 0) {
                        List<T> values = new ArrayList<>();
                        for (int j = 0; j < completedArray.length(); j++) {
                            values.add(completedArray.get(j).orElse(null));
                        }
                        future.commit(values);
                    }
                }
                return null;
            });
        }
        return future;
    }

}
