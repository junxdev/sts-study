package com.bit.sts07.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DaoAop {

	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Before("execution(* com.bit.sts07.service.*Impl.*(..))")
	public void before() {
		log.debug("before");
	}
	
	@After("execution(* com.bit.sts07.service.*Impl.list*(..))")
	public void after() {
		log.debug("after");
	}
	
	@AfterThrowing("execution(* com.bit.sts07.service.*Impl.*One*(..))")
	public void afterThrow() {
		log.debug("afterThrow");
	}
}
