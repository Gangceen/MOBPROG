package mobprog.apc.seaside;

import java.io.Serializable;

/**
 * Created by student on 8/26/2017.
 */

public class Entry implements Serializable{

    private String entryTitle;
    private String entryContent;
    private String entryEmail;

    public String getEntryTitle() {
        return entryTitle;
    }

    public void setEntryTitle(String entryTitle){
        this.entryTitle = entryTitle;
    };

    public String getEntryContent() {
        return entryContent;
    }

    public void setEntryContent(String entryContent){
        this.entryContent = entryContent;
    };

    public String getEntryEmail() {
        return entryEmail;
    }

    public void setEntryEmail(String entryEmail){
        this.entryEmail = entryEmail;
    };
}
