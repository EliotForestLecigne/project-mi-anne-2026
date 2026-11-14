package status;

import entity.Character;
import entity.ICharacter;
import entity.Stat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/// Wrapper for a list containing the StatusDuration
public class StatusList {
    public List<StatusDuration> getStatusDurations() {
        return statusDurations;
    }

    private List<StatusDuration> statusDurations = new ArrayList<>();

    /// Add a status duration to a character Status list or if already present extend the duration
    public void addStatusDuration(Status status, int duration, ICharacter character){
        if(this.containtStatus(status)){
           StatusDuration statusFound = this.getStatusDurationOfStatus(status);

           //extend duration
           statusFound.setDurationLeft(statusFound.getDurationLeft() + duration);
        }else {

            //create the status and apply its effect
            status.getStatusEffect().onApply(character);
            statusDurations.add(new StatusDuration(status, duration));
        }


    }

    /// remove a turn of all the turnLeft of every statusDuration and remove if 0
    public void turnEnd(ICharacter character){

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
    }

    /// Check if a status is contained in the list
    public boolean containtStatus(Status status){
        return statusDurations.stream().anyMatch(statusDuration -> statusDuration.getStatus().equals(status));
    }

    /// Return the statusDuration of a status present in the list
    public StatusDuration getStatusDurationOfStatus(Status status){
        return statusDurations.stream().filter(statusDuration -> statusDuration.getStatus().equals(status)).findFirst().get();
    }
}
