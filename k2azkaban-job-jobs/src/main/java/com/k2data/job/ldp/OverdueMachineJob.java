package com.k2data.job.ldp;

import com.k2data.job.common.BaseJob;
import com.k2data.job.common.JobProxyFactory;
import com.k2data.job.common.JobUtils;
import com.k2data.platform.etl.ETLTool;

/**
 * @author lidong 12/1/16.
 */
public class OverdueMachineJob implements BaseJob {

    @Override
    public void run() {
        ETLTool.pullLDPData(JobUtils.getRootPath() + "mappings/overdueMachine.json");
    }

}
