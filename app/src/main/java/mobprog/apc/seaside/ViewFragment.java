package mobprog.apc.seaside;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewFragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_fragment);

        Intent intent = getIntent();
        String title = intent.getStringExtra(RecyclerAdapter.ENTRY_TITLE);
        TextView entryTitle = (TextView) findViewById(R.id.entryTitle);
        entryTitle.setText(title);

        String content = intent.getStringExtra(RecyclerAdapter.ENTRY_CONTENT);
        TextView entryContent = (TextView) findViewById(R.id.entryContent);
        entryContent.setText(content);
    }
}
