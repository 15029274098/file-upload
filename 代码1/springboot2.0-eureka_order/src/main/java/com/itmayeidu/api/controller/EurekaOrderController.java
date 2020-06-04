/**
 * 功能说明:
 * 功能作者:
 * 创建日期:
 * 版权归属:每特教育|蚂蚁课堂所有 www.itmayiedu.com
 */
package com.itmayeidu.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.itmayeidu.feign.MemberFeignApi;

import brave.sampler.Sampler;

/**
 * 功能说明: <br>
 * 创建作者:每特教育-余胜军<br>
 * 创建时间:2018年9月12日 下午8:56:54<br>
 * 教育机构:每特教育|蚂蚁课堂<br>
 * 版权说明:上海每特教育科技有限公司版权所有<br>
 * 官方网站:www.itmayiedu.com|www.meitedu.com<br>
 * 联系方式:qq644064779<br>
 * 注意:本内容有每特教育学员共同研发,请尊重原创版权
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaOrderController {
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private MemberFeignApi memberFeignApi;

	// springcloud 中使用那些技术实现调用服务接口 feign 或者rest
	@RequestMapping("/orderToMember")
	public String orderToMember() {
		String memberUrl = "http://app-itmayiedu-member/getMember";
		// // String memberUrl = "http://localhost:8090/getMember";
		return restTemplate.getForObject(memberUrl, String.class);
	}

	@RequestMapping("/order")
	public String order() {
		return "我是订单项目...";
	}

	// 默认rest方式开启 负载均衡功能 如果以app-itmayiedu-member名称进行调用服务接口的时候 必须
	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}
