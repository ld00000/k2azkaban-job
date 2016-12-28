package job.ldp;

import com.k2data.job.common.BaseJob;
import com.k2data.job.etl.ETLTool;

import java.io.File;

/**
 * @author lidong 12/1/16.
 */
public class SupplyInChannetJob extends BaseJob {

    @Override
    public void run() {
        String path = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();

        int firstIndex = path.lastIndexOf(System.getProperty("path.separator")) + 1;
        int lastIndex = path.lastIndexOf(File.separator) + 1;
        path = path.substring(firstIndex, lastIndex);

        ETLTool.transportLDPData(path + "/mappings/supplyInChannet.json");
    }

}
