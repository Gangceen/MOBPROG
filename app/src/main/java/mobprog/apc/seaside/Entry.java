package mobprog.apc.seaside;

import java.io.Serializable;

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
    };

    public String getEntryContent() {
        return entryTitle;
    }

    public void setEntryContent(String entryContent){
        this.entryContent = entryContent;
    };
}
