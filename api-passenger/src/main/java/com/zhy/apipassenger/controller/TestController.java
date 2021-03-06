package com.zhy.apipassenger.controller;

import com.zhy.taxi.common.dto.ResponseResult;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName TestController
 * @Description TODO 达叔写点注释吧 @Author 搬砖的孟达
 * @Date 2020/1/8 22:28
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {



    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/service-instance/{applicationName}")
    public List<ServiceInstance> getServiceInstance(@PathVariable String applicationName){
        return discoveryClient.getInstances(applicationName);
    }

    @GetMapping("/apil")
    public ResponseResult send(HttpServletRequest request){
        String token = request.getHeader("token");
        String cookie = request.getHeader("Cookie");


        System.out.println("乘客api：token："+token);
        System.out.println("乘客api：cookie："+cookie);


        JSONObject result = new JSONObject();
        result.put("api-passenger", "乘客api接口服务");
        return ResponseResult.success(result);
    }
}
