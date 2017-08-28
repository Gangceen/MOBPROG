package mobprog.apc.seaside;

import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 8/26/2017.
 */

public final class DbHelper {
    private static final DbHelper INSTANCE = new DbHelper();
    private static final String TAG = "DbHelper";

    private FirebaseDatabase db;
    private DatabaseReference entryRef;
    private List<Entry> entryList;

    private DbHelper(){
        db = FirebaseDatabase.getInstance();
        entryList = new ArrayList<Entry>();
        entryRef = db.getReference("entry");
        entryRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                entryList.add(dataSnapshot.getValue(Entry.class));
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public static DbHelper getInstance() {
        return INSTANCE;
    }

    public void addEntry(Entry e) {
        entryRef.push().setValue(e);
    }

    public List<Entry> getEntryList() {
        return entryList;
    }
}
