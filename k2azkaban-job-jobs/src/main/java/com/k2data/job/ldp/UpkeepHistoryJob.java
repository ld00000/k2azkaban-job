package com.k2data.job.ldp;

import com.k2data.job.common.BaseJob;
import com.k2data.job.common.JobProxyFactory;
import com.k2data.platform.etl.ETLTool;

/**
 * @author lidong 12/1/16.
 */
public class UpkeepHistoryJob extends BaseJob {

    public static void main(String[] args) throws Exception {
        runJob(new UpkeepHistoryJob());
    }

    @Override
    public void run() {
        ETLTool.transportLDPData(getPath() + "mappings/upkeepHistory.json");
    }

}
