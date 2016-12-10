package com.jel.tech.schedule;

import java.util.List;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.jel.tech.entity.Dept;
import com.jel.tech.service.DeptService;

public class SleepReminderTask extends QuartzJobBean {

	private DeptService deptService;
	
	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}


	/*
	 *时常提醒自己好好休息，不要过度劳累！ 
	 */
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		System.out.println("准备睡觉了！但睡之前，先敲100行代码吧！");
		List<Dept> deptList = deptService.queryDeptList();
		System.out.println(deptList);
		System.out.println("sleep...");
	}

}
