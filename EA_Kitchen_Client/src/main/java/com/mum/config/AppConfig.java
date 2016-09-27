package com.mum.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.mum.DAO.IScheduleFarmerProduceDAO;
import com.mum.DAO.IScheduleProduceDAO;
import com.mum.DAO.ScheduleFarmerProduceDAO;
import com.mum.DAO.ScheduleProduceDAO;

@Configuration
public class AppConfig {

	public static String ServerUrl = "http://localhost:8081";
	/*
	 * @Bean public InternalResourceViewResolver internalResourceViewResolver(){
	 * InternalResourceViewResolver ins = new InternalResourceViewResolver();
	 * ins.setViewClass(JstlView.class); ins.setPrefix("/view/");
	 * ins.setSuffix(".jsp"); return ins; }
	 */
	/*
	 * <bean id="carDao" class="cs544.sample.CarDao" />
	 * 
	 * <!-- Resolves views selected for rendering by @Controllers to .jsp
	 * resources in the /WEB-INF/views directory --> <bean class=
	 * "org.springframework.web.servlet.view.InternalResourceViewResolver">
	 * <property name="viewClass"
	 * value="org.springframework.web.servlet.view.JstlView" /> <property
	 * name="prefix" value="/WEB-INF/views/" /> <property name="suffix"
	 * value=".jsp" /> </bean>
	 */

	@Bean
	public RestTemplate restTemplate(){
		RestTemplate rest = new RestTemplate();//RestTemplateBuilde.securityRestTemplateBuilder(username, password);
		return rest;
	}

	/*
	 * @Bean public ScheduleProduceDAO scheduleProduceDAO(){ ScheduleProduceDAO
	 * scheduleProduceDAO=new ScheduleProduceDAO(); return scheduleProduceDAO; }
	 * 
	 * @Bean public ScheduleFarmerProduceDAO scheduleFarmerProduceDAO(){
	 * ScheduleFarmerProduceDAO scheduleFarmerProduceDAO=new
	 * ScheduleFarmerProduceDAO(); return scheduleFarmerProduceDAO; }
	 */

	/*
	 * private IScheduleProduceDAO scheduleProduceDAO;
	 * 
	 * @Autowired private IScheduleFarmerProduceDAO scheduleFarmerProduceDAO;
	 */

	/*
	 * <bean id="restTemplate"
	 * class="org.springframework.web.client.RestTemplate"> <property
	 * name="messageConverters"> <list> <ref bean="jsonHttpMessageConverter" />
	 * </list> </property> </bean>
	 * 
	 * <bean id="jsonHttpMessageConverter" class=
	 * "org.springframework.http.converter.json.MappingJackson2HttpMessageConverter">
	 * <property name="prefixJson" value="false" /> <property
	 * name="supportedMediaTypes" value="application/json" /> </bean>
	 */
}
