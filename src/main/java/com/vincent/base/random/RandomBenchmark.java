package com.vincent.base.random;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * Created with IDEA
 * author:vincent
 * Date:2018/10/25
 */
@BenchmarkMode({Mode.AverageTime})
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 3, time = 5)
@Measurement(iterations = 3, time = 5)
@Threads(50)
@Fork(1)
@State(Scope.Benchmark)
public class RandomBenchmark {

    Random random = new Random();

    ThreadLocal<Random> threadLocalRandomHolder = ThreadLocal.withInitial(Random :: new);

    @Benchmark
    public int random() {
        return random.nextInt();
    }

    @Benchmark
    public int threadLocalRandom() {
        return ThreadLocalRandom.current().nextInt();
    }

    @Benchmark
    public int threadLocalRandomHolder() {
        return threadLocalRandomHolder.get().nextInt();
    }

    @Benchmark

    public int nettyThreadLocalRandom() {
        return io.netty.util.internal.ThreadLocalRandom.current().nextInt();
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(RandomBenchmark.class.getSimpleName())
                .build();
        new Runner(opt).run();
    }

}
