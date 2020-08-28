package com.example.firstauto;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


/**
 * @author : champion
 * @version V1.0
 * @Description:
 * @date Date : 2020年07月13日 9:12
 */
@EnableAutoConfiguration
public class WebConfiguration {

    @Bean
    public RouterFunction<ServerResponse> helloworld(){
        return route(GET("/hello-world"),
                request -> ok().body( Mono.just( "Hello,World" ) ) );
    }

    @EventListener(WebServerInitializedEvent.class)
    public void onWebServerReady(WebServerInitializedEvent event) {
        System.out.println("当前WebServer 实现类为： " + event.getWebServer().getClass().getName());
    }
}
