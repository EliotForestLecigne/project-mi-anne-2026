package status;

import entity.Character;
import entity.Stat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class StatusList {
    public List<StatusDuration> getStatusDurations() {
        return statusDurations;
    }

    private List<StatusDuration> statusDurations = new ArrayList<>();

    public void addStatusDuration(Status status, int duration, Character character){
        if(statusDurations.stream().filter(statusDuration -> statusDuration.getStatus() == status).toList().size() == 1){
           StatusDuration statusFound = statusDurations.stream().filter(statusDuration -> statusDuration.getStatus() == status).findFirst().get();
           statusFound.setDurationLeft(statusFound.getDurationLeft() + duration);
        }else {
            status.getStatusEffect().onApply(character);
            statusDurations.add(new StatusDuration(status, duration));
        }


    }

    public void turnEnd(Character character){

        Iterator<StatusDuration> statusDurationIterator = statusDurations.iterator();
        while (statusDurationIterator.hasNext()){
            StatusDuration statusDuration = statusDurationIterator.next();
            if(statusDuration.getDurationLeft()==1){
                statusDuration.getStatus().getStatusEffect().onRemove(character);
                statusDurationIterator.remove();
            }else {
                statusDuration.setDurationLeft(statusDuration.getDurationLeft()-1);
            }
        }

//        for (StatusDuration statusDuration : statusDurations){
//            if(statusDuration.getDurationLeft()==1){
//                statusDuration.getStatus().getStatusEffect().onRemove(character);
//                statusDurations.remove(statusDuration); //TODO : check if work correctly
//            }
//            else {
//                statusDuration.setDurationLeft(statusDuration.getDurationLeft()-1);
//            }
//        }
    }

    public boolean containtStatus(Status status){
        return statusDurations.stream().anyMatch(statusDuration -> statusDuration.getStatus().equals(status));
    }

    public StatusDuration getStatusDurationOfStatus(Status status){
        return statusDurations.stream().filter(statusDuration -> statusDuration.getStatus().equals(status)).findFirst().get();
    }
}
