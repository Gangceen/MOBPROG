package mobprog.apc.seaside;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by student on 8/26/2017.
 */

public class CreateEntryFragment extends Fragment {

    private final String TAG = "Seaside";
    private EditText title;
    private EditText content;
    private Button submit_entry;
    private DbHelper db;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.create_entry, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializeComponents(view);
    }

    private void initializeComponents(View view){
        title = view.findViewById(R.id.entry_title);
        content = view.findViewById(R.id.entry_content);
        submit_entry = view.findViewById(R.id.submit_button);

        submit_entry.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                clickSubmitButton(v);
            }
        });

        db = DbHelper.getInstance();

    }

    public void clickSubmitButton(View view){
        Entry e = new Entry();
        //e.setEntryEmail(user_Email.getText().toString());
        e.setEntryTitle(title.getText().toString());
        e.setEntryContent(content.getText().toString());
        db.addEntry(e);
        Toast.makeText(getActivity(), "Entry submitted successfully!", Toast.LENGTH_SHORT).show();
        clearTextFields();
        returnHome();
    }

    private void clearTextFields(){
        title.setText("");
        content.setText("");
    }

    private void returnHome(){
        FragmentManager fm = getActivity().getSupportFragmentManager();
        if (fm.getBackStackEntryCount()>0){
            fm.popBackStack();
        }
    }
}
