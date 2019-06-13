package com.wy.concurrent.chapter5;

/**
 * @author wy
 * @date 2019-06-13
 * @description
 */
public interface Computable<I, O> {
    /**
     * some computable process
     *
     * @param input
     * @return
     */
    O compute(I input);
}
