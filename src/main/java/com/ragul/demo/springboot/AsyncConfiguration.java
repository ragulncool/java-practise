package com.ragul.demo.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync  // Enables async processing
public class AsyncConfiguration {

    // Customize the ThreadPoolTaskExecutor
    @Bean(name = "taskExecutor")
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

        // Set core pool size (the number of threads to keep in the pool, even if they're idle)
        executor.setCorePoolSize(5);

        // Set maximum pool size (the maximum number of threads that can be in the pool at any time)
        executor.setMaxPoolSize(10);

        // Set the queue capacity (the number of tasks that can wait in the queue before new threads are created)
        executor.setQueueCapacity(25);

        // Set the thread name prefix (useful for debugging and logging)
        executor.setThreadNamePrefix("Async-Thread-");

        // Set the rejected execution handler (how tasks are handled when the pool is full)
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        // Initialize the executor
        executor.initialize();

        return executor;
    }
}
