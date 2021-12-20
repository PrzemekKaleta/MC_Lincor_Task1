package monitor;

import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;

public class CpuMemoryMonitor {

    OperatingSystemMXBean operatingSystem = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
    Runtime runtime = Runtime.getRuntime();

    private int dataSize = 1024 * 1024;

    private List<Double> cpuLoads = new ArrayList<>();
    private List<Double> memoryLoads = new ArrayList<>();
    private double calibratedMemory;

    public String getEffor(){

        double memory = (runtime.totalMemory() - runtime.freeMemory())/dataSize;
        double cpu = operatingSystem.getProcessCpuLoad() * 100;

        return String.format("Used percentage CPU: %.2f , used memory %.2f MB.", cpu, memory);

    }

    public void makeMemoryCalibration(){
        this.calibratedMemory = (runtime.totalMemory() - runtime.freeMemory())/dataSize;
    }

    public void makeMesurment(){

        this.cpuLoads.add(operatingSystem.getProcessCpuLoad() * 100);
        this.memoryLoads.add((double)(runtime.totalMemory() - calibratedMemory - runtime.freeMemory())/dataSize);
    }

    public List<Double> getCpuLoads() {
        return cpuLoads;
    }

    public List<Double> getMemoryLoads() {
        return memoryLoads;
    }

    public double getAverageCpuLoads(){
        return cpuLoads.stream().mapToDouble(a->a).average().orElse(0.0);
    }

    public double getAverageMemoryLoads(){
        return memoryLoads.stream().mapToDouble(a->a).average().orElse(0.0);
    }

    public void getReport(){
        double averageCpuLoads = getAverageCpuLoads();
        double averageMemoryLoads = getAverageMemoryLoads();

        System.out.println(String.format("Average load: CPU - %.2f , Memory - %.2f MB", averageCpuLoads, averageMemoryLoads));
    }
}
