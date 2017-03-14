package mobile.esprit.tn.mobileteam.Activities.Users;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.github.ybq.android.spinkit.style.Circle;
import com.ramotion.foldingcell.FoldingCell;

import java.util.ArrayList;
import java.util.List;

import mobile.esprit.tn.mobileteam.R;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        // get our list view
        ListView theListView = (ListView) findViewById(R.id.mainListView);
        // prepare progressBar to display
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress);
        Circle doubleBounce = new Circle();
        doubleBounce.setBounds(0, 0, 100, 100);
        doubleBounce.setColor(R.color.navigationBarColor);
        progressBar.setIndeterminateDrawable(doubleBounce);

        // prepare elements to display
        final List<BackendlessUser> items = new ArrayList<>();


        // add custom btn handler to first list item
     /*   items.get(0).setRequestBtnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "CUSTOM HANDLER FOR FIRST BUTTON", Toast.LENGTH_SHORT).show();
            }
        });*/

        // create custom adapter that holds elements and their state (we need hold a id's of unfolded elements for reusable elements)
        Log.v("profil activity items2", String.valueOf(items.size()));

        final FoldingCellListAdapter adapter = new FoldingCellListAdapter(ProfileActivity.this, items);
        theListView.setAdapter(adapter);
        Backendless.Persistence.of(BackendlessUser.class).find(new AsyncCallback<BackendlessCollection<BackendlessUser>>() {
            @Override
            public void handleResponse(BackendlessCollection<BackendlessUser> foundUsers) {
                List<BackendlessUser> users = foundUsers.getCurrentPage();
                Log.v("profil activity users", String.valueOf(users.size()));
                items.addAll(users);
                Log.v("profil activity items", String.valueOf(items.size()));
                adapter.notifyDataSetChanged();
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void handleFault(BackendlessFault fault) {
// an error has occurred, the error code can be retrieved with fault.getCode()
            }
        });

        // add default btn handler for each request btn on each item if custom handler not found
        adapter.setDefaultRequestBtnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "DEFAULT HANDLER FOR ALL BUTTONS", Toast.LENGTH_SHORT).show();
            }
        });

        // set elements to adapter
        theListView.setAdapter(adapter);

        // set on click event listener to list view
        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                // toggle clicked cell state
                ((FoldingCell) view).toggle(false);
                // register in adapter that state for selected cell is toggled
                adapter.registerToggle(pos);
            }
        });
    }
}