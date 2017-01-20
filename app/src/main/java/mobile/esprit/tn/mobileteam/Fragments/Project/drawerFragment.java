package mobile.esprit.tn.mobileteam.Fragments.Project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar.OnMenuItemClickListener;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import mobile.esprit.tn.mobileteam.R;
import mobile.esprit.tn.mobileteam.TeamUpApp;

import static android.support.design.widget.NavigationView.OnNavigationItemSelectedListener;

public class drawerFragment extends Fragment implements OnMenuItemClickListener, OnNavigationItemSelectedListener {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.navigation_view)
    NavigationView navigationView;
    private Fragment fragment;
    private Unbinder unbinder;
    private SharedPreferences preferences;
    // Fragment lifecycle

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_drawer, container, false);
        unbinder = ButterKnife.bind(this, v);
        preferences = getContext().getSharedPreferences(TeamUpApp.TABLE_USER, Context.MODE_PRIVATE);


        // Setup toolbar
        toolbar.inflateMenu(R.menu.menu_project);
        toolbar.setOnMenuItemClickListener(this);
// Setup navigation drawer
        // Setup navigation drawer
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.app_name, R.string.app_name) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        navigationView.setNavigationItemSelectedListener(this);
        actionBarDrawerToggle.syncState();
        // Load previously selected drawer item
        int lastPosition = preferences.getInt(TeamUpApp.LAST_SELECTED, 0);
        if (savedInstanceState == null) {
            setSelectedDrawerItem(lastPosition);
        } else {
            fragment = getActivity().getSupportFragmentManager().findFragmentByTag(TeamUpApp.TAG_GRID_FRAGMENT);
            if (savedInstanceState.containsKey(TeamUpApp.TOOLBAR_TITLE)) {
                toolbar.setTitle(savedInstanceState.getString(TeamUpApp.TOOLBAR_TITLE));
            } else {
                toolbar.setTitle(navigationView.getMenu().getItem(lastPosition).getTitle());
            }
        }
        return v;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(TeamUpApp.TOOLBAR_TITLE, toolbar.getTitle().toString());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

// Toolbar action menu


    @Override
    public boolean onMenuItemClick(MenuItem item) {
        int id = item.getItemId();
        switch (id) {

           /* case R.id.action_search:
                startActivity(new Intent(getContext(), SearchActivity.class));
                return true;
            switch (id) {

                case R.id.action_search:
                    startActivity(new Intent(getContext(), SearchActivity.class));
                    return true;
                case R.id.action_email:
                    Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "ronak_lm@outlook.com", null));
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.app_name));
                    try {
                        startActivity(Intent.createChooser(emailIntent, getString(R.string.action_email_using)));
                    } catch (Exception e) {
                        Toast.makeText(getContext(), R.string.action_email_error, Toast.LENGTH_SHORT).show();
                    }
                    return true;*/

            case R.id.action_about:
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_about, null);
                view.findViewById(R.id.tmdb_link).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://espritmobile.com/"));
                        startActivity(browserIntent);
                    }
                });
                builder.setView(view);
                builder.show();
                return true;

            default:
                return false;
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawers();
        int id = item.getItemId();
        switch (id) {
            case R.id.drawer_popular:
                setSelectedDrawerItem(0);
                return true;
            case R.id.drawer_rated:
                setSelectedDrawerItem(1);
                return true;
            case R.id.drawer_upcoming:
                setSelectedDrawerItem(2);
                return true;
            case R.id.drawer_playing:
                setSelectedDrawerItem(3);
                return true;
            case R.id.drawer_watched:
                setSelectedDrawerItem(4);
                return true;
            case R.id.drawer_to_see:
                setSelectedDrawerItem(5);
                return true;
            default:
                return false;
        }
    }

    private void setSelectedDrawerItem(int position) {
        MenuItem item = navigationView.getMenu().getItem(position);
        item.setChecked(true);
        toolbar.setTitle(item.getTitle());
        // Create and setup bundle args
        Bundle args = new Bundle();
        if (position == 0) {
            args.putInt(TeamUpApp.VIEW_TYPE, TeamUpApp.VIEW_TYPE_POPULAR);
        } else if (position == 1) {
            args.putInt(TeamUpApp.VIEW_TYPE, TeamUpApp.VIEW_TYPE_RATED);
        } else if (position == 2) {
            args.putInt(TeamUpApp.VIEW_TYPE, TeamUpApp.VIEW_TYPE_UPCOMING);
        } else if (position == 3) {
            args.putInt(TeamUpApp.VIEW_TYPE, TeamUpApp.VIEW_TYPE_PLAYING);
        } else if (position == 4) {
            args.putInt(TeamUpApp.VIEW_TYPE, TeamUpApp.VIEW_TYPE_WATCHED);
        } else if (position == 5) {
            args.putInt(TeamUpApp.VIEW_TYPE, TeamUpApp.VIEW_TYPE_TO_SEE);
        }
        fragment = new ProjectDisplayFragment();
        fragment.setArguments(args);
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, fragment, TeamUpApp.TAG_GRID_FRAGMENT);
        transaction.commit();
        // Save selected position to preference
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(TeamUpApp.LAST_SELECTED, position);
        editor.apply();
    }
}
