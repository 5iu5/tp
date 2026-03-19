package seedu.traveltrio.command;

import seedu.traveltrio.model.Activity;
import seedu.traveltrio.model.ActivityList;

import java.util.ArrayList;

public abstract class ActivityCommand {

    protected ActivityList activityList;

    public ActivityCommand(ActivityList activityList) {
        this.activityList = activityList;
    }

    public abstract String execute(String tripName);

}
