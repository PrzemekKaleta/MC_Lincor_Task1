package monitor;

import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ManagementFactory;

public class CpuMemoryMonitor {

    OperatingSystemMXBean operatingSystem = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
    Runtime runtime = Runtime.getRuntime();

    private int dataSize = 1024 * 1024;

    public String getEffor(){

        double memory = (runtime.totalMemory() - runtime.freeMemory())/dataSize;
        double cpu = operatingSystem.getProcessCpuLoad() * 100;

        return String.format("Used percentage CPU: %.2f , used memory %.2f MB.", cpu, memory);

    }

}
