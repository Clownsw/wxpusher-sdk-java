package cn.smilex.wxpusher.function;

/**
 * @author smilex
 */
@FunctionalInterface
public interface ErrorHandler {
    void handler(Throwable e);
}
