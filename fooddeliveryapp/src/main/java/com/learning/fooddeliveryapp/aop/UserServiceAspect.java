package com.learning.fooddeliveryapp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect //its a container where we hold all our aop code
public class UserServiceAspect {
	
	
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Pointcut("within(@org.springframework.stereotype.Repository *) "+
	"|| within(@org.springframework.stereotype.Service *) "+
	"|| within(@org.springframework.web.bind.annotation.RestController *)")
	
	public void springPointCutExp() 
	{
		
		
	}
	
	
	@Pointcut("within(com.learning.fooddeliveryapp.controller..*) " +
			"|| within(com.learning.fooddeliveryapp.service.impl..*)")
			public void springPointCutExp2() {
	}
	@AfterThrowing(pointcut = "springPointCutExp() && springPointCutExp2()", throwing = "e")
	public void logAfterThrowingException(JoinPoint joinPoint, Throwable e){
		log.error("exception {}.{}() with cause {}", joinPoint.getSignature().getDeclaringTypeName(),
				joinPoint.getSignature().getName(), e.getCause()!=null ? e.getCause():"NULL");
	}
	
	
	   
   
   //if we add get like this it will only come for get methods
	@Before(value = "execution(* com.learning.fooddeliveryapp.service.impl.*.get*(..))")
	public void beforeAllServiceMethods(JoinPoint joinPoint) {
		
		System.out.println("hello");
		System.out.println(joinPoint.getTarget());
	}
	


}