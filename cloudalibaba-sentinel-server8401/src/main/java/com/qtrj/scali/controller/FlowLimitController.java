package com.qtrj.scali.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class FlowLimitController {


    private final String AUTO_RELOAD_PAGE_SCRIPT = "<script>window.setInterval(function(){window.location.reload();},300);</script>";

    /**
     * 小提示：Chrome ctrl/command 选择两个窗口后，刷新快捷键刷新页面会同时刷新
     * 配置参数后刷新再手动加速访问一下会看到限流效果的。
     * @return
     * @link http://localhost:8401/testA
     */
    @GetMapping("/testA")
    public String testA() {
//        打开注释，测试线程数配置后的流控效果
//        try {
//            TimeUnit.MILLISECONDS.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        log.info(Thread.currentThread().getName() + "...testB ");
        return Thread.currentThread().getName() + "testA-----" + AUTO_RELOAD_PAGE_SCRIPT;
    }

    /**
     * @return
     * @link http://localhost:8401/testB
     */
    @GetMapping("/testB")
    public String testB() {
        log.info(Thread.currentThread().getName() + "...testB ");
        return Thread.currentThread().getName() + "testB-----" + AUTO_RELOAD_PAGE_SCRIPT;
    }

    @GetMapping("/testD")
    public String testD() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("testD 测试RT");
        return "testD -----";
    }

    @GetMapping("/testException")
    public String testException() {
        log.info("testException 异常比例");
        int age = 10 / 0;
        return "testException -----";
    }

    @GetMapping("/testExceptionCount")
    public String testExceptionCount() {
        log.info("testExceptionCount 异常数");
        int age = 10 / 0;
        return "testExceptionCount -----";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "dealTestHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        int age = 10 / 0;
        return "testHotKey -----";
    }

    public String dealTestHotKey(String p1, String p2, BlockException blockException) {
        return "dealTestHotKey---------";
    }
}
