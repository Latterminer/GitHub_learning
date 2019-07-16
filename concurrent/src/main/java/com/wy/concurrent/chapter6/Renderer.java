package com.wy.concurrent.chapter6;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;

/**
 * @author wy
 * @date 2019-06-24
 * @description
 */
public class Renderer {
    private final ExecutorService executor;

    Renderer(ExecutorService executor) {
        this.executor = executor;
    }

    void renderPage(CharSequence source) {
        List<String> info = Collections.EMPTY_LIST;
        CompletionService<String> completionService = new ExecutorCompletionService<>(executor);
        completionService.submit(() -> "test");

        try {
            //检索并删除表示下一个已完成任务的将来，如果尚未完成任务，则等待。
            completionService.take();
            //检索并删除表示下一个已完成任务的将来，如果不存在，则返回null。
            completionService.poll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
