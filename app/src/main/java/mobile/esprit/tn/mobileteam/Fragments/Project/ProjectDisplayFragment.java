package mobile.esprit.tn.mobileteam.Fragments.Project;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import mobile.esprit.tn.mobileteam.Adapters.Project.ProjectsAdapter;
import mobile.esprit.tn.mobileteam.Models.Project;
import mobile.esprit.tn.mobileteam.R;


public class ProjectDisplayFragment extends Fragment {
    private RecyclerView recyclerView;
    private ProjectsAdapter adapter;
    private List<Project> projectList;
    private BackendlessCollection<Project> projects;
    private CollapsingToolbarLayout collapsingToolbar;
    private AppBarLayout appBarLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //   FragmentActivity faActivity = (FragmentActivity) super.getActivity();
        CoordinatorLayout llayout = (CoordinatorLayout) inflater.inflate(R.layout.projects_display, container, false);

        //  Toolbar toolbar = (Toolbar) llayout.findViewById(R.id.toolbar);
        //  the line  bellow need to be implemented in the activiy hosting this fragment
        // setSupportActionBar(toolbar);
        //initCollapsingToolbar();
        recyclerView = (RecyclerView) llayout.findViewById(R.id.recycler_view);
        projectList = new ArrayList<>();
        // prepareProjects();
        adapter = new ProjectsAdapter(super.getActivity(), projectList);
        prepareProjects();

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(super.getActivity(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new ProjectDisplayFragment.GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        //way to transport informations from a fragment toanother

// collipse toolbar parameters
        // collapsingToolbar =
        //   (CollapsingToolbarLayout) llayout.findViewById(R.id.collapsing_toolbar);
        // appBarLayout = (AppBarLayout) llayout.findViewById(R.id.appbar);


        try {
            Glide.with(this).load(R.drawable.cover).into((ImageView) llayout.findViewById(R.id.backdrop));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return llayout;


    }

    /**
     * Initializing collapsing toolbar
     * Will show and hide the toolbar title on scroll
     */
    private void initCollapsingToolbar() {

        collapsingToolbar.setTitle(" ");

        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle(getString(R.string.app_name));
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }


    /**
     * Adding few albums for testing
     */
    private void prepareProjects() {




        /* the static prepareProject function
        private void prepareAlbums() {
            int[] covers = new int[]{
                    R.drawable.album1,
                    R.drawable.album2,
                    R.drawable.album3,
                    R.drawable.album4,
                    R.drawable.album5,
                    R.drawable.album6,
                    R.drawable.album7,
                    R.drawable.album8,
                    R.drawable.album9,
                    R.drawable.album10,
                    R.drawable.album11};

            Album a = new Album("True Romance", 13, covers[0]);
            albumList.add(a);*/


        System.out.println("\n============ Loading relations with the ASYNC API ============");
        //synchronization aid that makes the main thread wait until the countdown reaches 0


        final AsyncCallback<Project> loadRelationsCallback = new AsyncCallback<Project>() {
            @Override
            public void handleResponse(Project project) {
                System.out.println("\nProject name = " + project.getName());
                System.out.println("\nProject description = " + project.getDescription());
                System.out.println("\nProjectImage URL = " + project.getImage());
                String ProjectName = project.getName();
                String ProjectDesc = project.getDescription();
                String ProjectImage = project.getImage();
                //printMedia(project.getMedias());

                Project p = new Project();
                p.setName(ProjectName);
                p.setDescription(ProjectDesc);
                p.setImage(ProjectImage);
                projectList.add(p);
                adapter.notifyDataSetChanged();


            }

            @Override
            public void handleFault(BackendlessFault backendlessFault) {

            }
        };


        AsyncCallback<BackendlessCollection<Project>> callback = new AsyncCallback<BackendlessCollection<Project>>() {
            @Override
            public void handleResponse(BackendlessCollection<Project> projects) {
                System.out.println("Loaded " + projects.getCurrentPage().size() + " restaurant objects");
                System.out.println("Total projects in the Backendless storage - " + projects.getTotalObjects());

                Iterator<Project> iterator = projects.getCurrentPage().iterator();

                while (iterator.hasNext()) {
                    Project project = iterator.next();
                    List<String> relations = new ArrayList<>();
                    relations.add("medias");
                    Backendless.Data.of(Project.class).loadRelations(project, relations, loadRelationsCallback);
                }


            }

            @Override
            public void handleFault(BackendlessFault backendlessFault) {

            }
        };

        Backendless.Data.of(Project.class).find(callback);


    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    private void addMoreItems(BackendlessCollection<Project> nextPage) {
        projectList.addAll(nextPage.getCurrentPage());
        adapter.notifyDataSetChanged();
    }

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

}
