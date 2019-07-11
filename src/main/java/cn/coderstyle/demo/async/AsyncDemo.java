package cn.coderstyle.demo.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author : championjing
 * @ClassName: Async
 * @Description: 使用@Async时，一定要使用@EnableAsync，开启该功能
 * @Date: 7/11/2019 4:46 PM
 */
@Component
public class AsyncDemo {
    
    @org.springframework.scheduling.annotation.Async
    public void add(int num,String name){ 
        num++;
        System.out.println("add:"+num+" ,name:"+name);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("等待完成");
    }
    @Async
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
