package status;

public class StatusDuration {
    private Status status;
    private int durationLeft;

    public StatusDuration(Status status, int durationLeft) {
        this.status = status;
        this.durationLeft = durationLeft;
    }


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getDurationLeft() {
        return durationLeft;
    }

    public void setDurationLeft(int durationLeft) {
        this.durationLeft = durationLeft;
    }
}
