package mobprog.apc.seaside;

import java.io.Serializable;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by student on 8/26/2017.
 */

public class Entry implements Serializable{

    private String entryTitle;
    private String entryContent;

    public String getEntryTitle() {
        return entryTitle;
    }

    public void setEntryTitle(String entryTitle){
        this.entryTitle = entryTitle;
    }

    public String getEntryContent() {
        return entryContent;
    }

    public void setEntryContent(String entryContent){
        this.entryContent = entryContent;
    };
}
