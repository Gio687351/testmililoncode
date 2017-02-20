package refactula.design.patterns.creational.object_pool.mutable.fibonacci;

import com.google.common.base.Preconditions;
import refactula.design.patterns.creational.object_pool.mutable.InstanceManager;
import refactula.design.patterns.creational.object_pool.mutable.ObjectPool;

import java.util.concurrent.atomic.AtomicInteger;

public class FibonacciApp {

    public static void main(String[] args) {
        ObjectPool<LargeNumber> pool = new ObjectPool<>(100, new InstanceManager<LargeNumber>() {
            private final AtomicInteger created = new AtomicInteger(3);

            @Override
            public LargeNumber createInstance() {
                Preconditions.checkState(created.decrementAndGet() >= 0);
                return new LargeNumber(4096);
            }

            @Override
            public void cleanUp(LargeNumber instance) {

            }

            @Override
            public void setUp(LargeNumber instance) {
                instance.setZero();
            }
        });

        for (int i = 0; i <= 10; i++) {
            computeFibonacci(pool, i);
        }
        computeFibonacci(pool, 100);
        computeFibonacci(pool, 1000);
        computeFibonacci(pool, 10000);
    }

    private static void computeFibonacci(ObjectPool<LargeNumber> pool, int index) {
        LargeNumber number = calculateFibonacci(pool, index);
        System.out.println(index + " fibonacci number is " + number);
        pool.release(number);
    }

    private static LargeNumber calculateFibonacci(ObjectPool<LargeNumber> pool, int number) {
        LargeNumber prev = pool.acquire();
        prev.set(1);
        if (number == 0) {
            return prev;
        }

        LargeNumber current = pool.acquire();
        current.set(1);
        while (number > 1) {
            LargeNumber next = pool.acquire();
            next.sum(prev, current);

            pool.release(prev);
            prev = current;
            current = next;

            number--;
        }

        pool.release(prev);
        return current;
    }

}
