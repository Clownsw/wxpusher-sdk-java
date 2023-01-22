package cn.smilex.wxpusher.function;

/**
 * @author smilex
 */
@FunctionalInterface
public interface TryRunTaskNoReturn {
    void run(Object... params) throws Throwable;
}
