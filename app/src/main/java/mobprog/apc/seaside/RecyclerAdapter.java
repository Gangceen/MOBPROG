package mobprog.apc.seaside;


import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AlertDialogLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import static mobprog.apc.seaside.R.id.entryContent;
import static mobprog.apc.seaside.R.id.entryTitle;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{

    private DbHelper db;
    public static final String ENTRY_TITLE = "entrytitle";
    public static final String ENTRY_CONTENT = "entrycontent";

    public RecyclerAdapter() { db = DbHelper.getInstance() ;}

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mItem = db.getEntryList().get(position);
        holder.entryTitle.setText(holder.mItem.getEntryTitle());
        holder.entryContent.setText(holder.mItem.getEntryContent());
        holder.detailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ViewFragment.class);

                intent.putExtra(ENTRY_TITLE, holder.mItem.getEntryTitle());
                intent.putExtra(ENTRY_CONTENT, holder.mItem.getEntryContent());

                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return db.getEntryList().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView entryTitle;
        public final TextView entryContent;
        public final ImageButton detailsButton;
        public Entry mItem;

        public ViewHolder (View view) {
            super(view);
            mView = view;
            entryTitle = view.findViewById(R.id.entryTitle);
            entryContent = view.findViewById(R.id.entryContent);
            detailsButton = view.findViewById(R.id.details_button);
        }
    }
}