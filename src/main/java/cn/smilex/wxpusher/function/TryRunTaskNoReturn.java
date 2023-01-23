package cn.smilex.wxpusher.function;

/**
 * @author smilex
 */
@FunctionalInterface
public interface TryRunTaskNoReturn {
    void run() throws Throwable;
}
