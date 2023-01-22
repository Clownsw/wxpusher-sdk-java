package cn.smilex.wxpusher.util;

import cn.smilex.wxpusher.function.ErrorHandler;
import cn.smilex.wxpusher.function.TryRunTask;
import cn.smilex.wxpusher.function.TryRunTaskNoReturn;

import java.util.function.Supplier;

/**
 * @author smilex
 */
@SuppressWarnings("unused")
public final class CommonUtil {
    /**
     * try run
     *
     * @param task                task
     * @param defaultValueHandler default value handler
     * @param errorHandler        error handler
     * @param <T>                 return value type
     * @return return value
     */
    public static <T> T tryRun(TryRunTask<T> task, Supplier<T> defaultValueHandler, ErrorHandler errorHandler) {
        try {
            return task.run();
        } catch (Throwable e) {
            errorHandler.handler(e);
        }
        return defaultValueHandler.get();
    }

    /**
     * try run
     *
     * @param task         task
     * @param errorHandler error handler
     */
    public static void tryRun(TryRunTaskNoReturn task, ErrorHandler errorHandler) {
        try {
            task.run();
        } catch (Throwable e) {
            errorHandler.handler(e);
        }
    }
}
