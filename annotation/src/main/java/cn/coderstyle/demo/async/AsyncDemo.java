package cn.coderstyle.demo.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author : championjing
 * @ClassName: Async
 * @Description: 使用@Async时，一定要使用@EnableAsync，开启该功能， 定义线程池后，@Async后加入线程池bean名称，即可放入自定义线程池，
 * 通过debug 线程池中的runWorker(Worker w) 方法可发现，放入的是预期线程池
 * @Date: 7/11/2019 4:46 PM
 */
@Component
public class AsyncDemo {
    
    @org.springframework.scheduling.annotation.Async("myExecutor")
    public void add(int num,String name){ 
        num++;
        System.out.println("add:"+num+" ,name:"+name);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("等待完成");
    }
    @Async("myExecutor")
    public void reduce(int num,String name){
        num--;
        System.out.println("reduce:"+num+" ,name:"+name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
