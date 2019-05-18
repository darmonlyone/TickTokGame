package model.design_patterns.singleton;

public class StopWatch {


    private static StopWatch stopWatch;
    private long startTime;
    private long stopTime;
    private boolean isStart;

    public static StopWatch getInstance(){
        if (stopWatch == null) {
            stopWatch = new StopWatch();
        }
        return stopWatch;
    }

    public void startTiming(){
        startTime = (long) System.currentTimeMillis();
        isStart = true;
    }


    public void stopTiming(){
        if (isStart)
            stopTime = (long) System.currentTimeMillis();
        isStart = false;
    }
    public long getStartTime() {
        return startTime;
    }

    public long getStopTime() {
        return stopTime;
    }

    public double getUsedTime() {
        if (startTime == 0|| stopTime == 0)
            return 0.00;
        return (stopTime - startTime)*0.001;
    }
}
