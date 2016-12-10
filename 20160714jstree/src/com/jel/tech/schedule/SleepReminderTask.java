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
	 *ʱ�������Լ��ú���Ϣ����Ҫ�������ۣ� 
	 */
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		System.out.println("׼��˯���ˣ���˯֮ǰ������100�д���ɣ�");
		List<Dept> deptList = deptService.queryDeptList();
		System.out.println(deptList);
		System.out.println("sleep...");
	}

}
