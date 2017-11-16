package org.cnmd.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.cnmd.common.db.utils.DatabaseHelper;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Transaction {

	@Before("execution(* org.cnmd.mall.service..*.*(..))")
	public void before(JoinPoint jp) throws Exception{
		System.out.println("----------前置通知----------");
		System.out.println(jp.getSignature().getName());
		//会话创建
		DatabaseHelper.beginTransaction();
	}

	@AfterReturning("execution(* org.cnmd.mall.service..*.*(..))")
	public void after(JoinPoint jp){
		System.out.println("----------最终通知----------");
		DatabaseHelper.commitTransaction();
	}

	@AfterThrowing("execution(* org.cnmd.mall.service..*.*(..))")
	public void afterThrowing(JoinPoint jp){
		System.out.println("----------异常终通知----------");
		DatabaseHelper.rollbackTransaction();
	}
}
