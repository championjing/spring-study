package cn.coderstyle.demo.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThreadPoolConfig {

	@Value("${pool.core.size}")
	private Integer corePoolSize;	
	@Value("${pool.max.size}")
	private Integer maxPoolSize;	
	@Value("${pool.thread.live.time}")
	private Long keepAliveTime;
		
	private static BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>(50000);
	
	@Bean("myExecutor")
	public Executor initPool() {
		Executor executor = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime, TimeUnit.SECONDS, queue);
		return executor;
	}
}
