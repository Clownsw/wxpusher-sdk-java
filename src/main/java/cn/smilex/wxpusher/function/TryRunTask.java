package cn.smilex.wxpusher.function;

/**
 * @author smilex
 */
@FunctionalInterface
public interface TryRunTask<T> {
    T run() throws Throwable;
}
