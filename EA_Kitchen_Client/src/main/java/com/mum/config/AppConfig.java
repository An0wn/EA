package com.mum.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
public class AppConfig {
	
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver(){
		InternalResourceViewResolver ins = new InternalResourceViewResolver();
		ins.setViewClass(JstlView.class);
		ins.setPrefix("/view/");
		ins.setSuffix(".jsp");
		return ins;
	}
	/*<bean id="carDao" class="cs544.sample.CarDao" />

	<!-- Resolves views selected for rendering by @Controllers to .jsp resources 
		in the /WEB-INF/views directory -->
	<bean
		class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<property name="viewClass" value="org.springframework.web.servlet.view.JstlView" />
		<property name="prefix" value="/WEB-INF/views/" />
		<property name="suffix" value=".jsp" />
	</bean>*/
	
	
	@Bean
	public RestTemplate restTemplate(){
		RestTemplate rest= new RestTemplate();
		return rest;
	}
	
	
/*	<bean id="restTemplate" class="org.springframework.web.client.RestTemplate">
	<property name="messageConverters">
		<list>
			<ref bean="jsonHttpMessageConverter" />
		</list>
	</property>
</bean>

<bean id="jsonHttpMessageConverter"
	class="org.springframework.http.converter.json.MappingJackson2HttpMessageConverter">
	<property name="prefixJson" value="false" />
	<property name="supportedMediaTypes" value="application/json" />
</bean>*/
}
