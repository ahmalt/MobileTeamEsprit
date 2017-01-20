package mobile.esprit.tn.mobileteam.Adapters.Project;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import mobile.esprit.tn.mobileteam.Models.Project;
import mobile.esprit.tn.mobileteam.R;
import mobile.esprit.tn.mobileteam.TeamUpApp;
import mobile.esprit.tn.mobileteam.Ui.AutoResizeTextView;
import mobile.esprit.tn.mobileteam.Utile.TextUtils;

/**
 * Created by ahlem on 30/07/2016.
 */
public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final OnProjectClickListener onProjectClickListener;
    public ArrayList<? extends Project> projectList;
    private Context mContext;
    private int imageWidth;
    private SharedPreferences sharedPref;

    //constructor
    public Adapter(Context mContext, OnProjectClickListener onProjectClickListener) {
        this.mContext = mContext;
        this.projectList = projectList;
        this.onProjectClickListener = onProjectClickListener;
        sharedPref = mContext.getSharedPreferences(TeamUpApp.TABLE_USER, Context.MODE_PRIVATE);
        imageWidth = sharedPref.getInt(TeamUpApp.THUMBNAIL_SIZE, 0);   // Load image width for grid view
    }

    // RecyclerView methods
    @Override
    public int getItemCount() {
        return projectList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return (sharedPref.getInt(TeamUpApp.VIEW_MODE, TeamUpApp.VIEW_MODE_GRID));
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //conditioning inflating
        if (viewType == TeamUpApp.VIEW_MODE_GRID) {
            // GRID MODE
            final ViewGroup v = (ViewGroup) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_project_grid, parent, false);
            ViewTreeObserver viewTreeObserver = v.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        // Update width integer and save to storage for next use
                        int width = v.findViewById(R.id.project_poster).getWidth();
                        if (width > imageWidth) {
                            SharedPreferences.Editor editor = sharedPref.edit();
                            editor.putInt(TeamUpApp.THUMBNAIL_SIZE, width);
                            editor.apply();
                        }
                        // Unregister LayoutListener
                        if (Build.VERSION.SDK_INT >= 16) {
                            v.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        } else {
                            v.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                        }
                    }
                });
            }
            return new ProjectGridViewHolder(v, onProjectClickListener);
        } else if (viewType == TeamUpApp.VIEW_MODE_LIST) {
            // LIST MODE
            ViewGroup v = (ViewGroup) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_project_list, parent, false);
            return new ProjectListViewHolder(v, onProjectClickListener);
        } else {
            // COMPACT MODE
            ViewGroup v = (ViewGroup) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_project_compact, parent, false);
            return new ProjectCompactViewHolder(v, onProjectClickListener);
        }
    }


    //end of conditionning inflating
    /*
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.projects_card, parent, false);


        /*on Item click behaviour
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext,"you clicked on item number"+ getItemCount(),Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(mContext, Project_detail_activity.class);

                intent.putExtra("Id_Project",projectList.)
                mContext.startActivity(intent);
            }

        });
        return new MyViewHolder(itemView);

    */

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        int viewType = getItemViewType(0);
        Project project = projectList.get(position);
        Log.v("ProjectDisplayAdapter: ", String.valueOf(projectList.size()));
        //test the display mode
        if (viewType == TeamUpApp.VIEW_MODE_GRID) {
            // GRID MODE
            ProjectGridViewHolder projectGridViewHolder = (ProjectGridViewHolder) viewHolder;
            // Title and year
            projectGridViewHolder.projectName.setText(project.getName());
            projectGridViewHolder.releaseYear.setText(project.getYear());
            // Load image
            if (!TextUtils.isNullOrEmpty(project.getBackgroundImage())) {
                Picasso.with(mContext).load(project.getBackgroundImage()).into(((ProjectGridViewHolder) viewHolder).imageView);
                projectGridViewHolder.imageView.setVisibility(View.VISIBLE);
                projectGridViewHolder.defaultimageView.setVisibility(View.GONE);
            } else if (!TextUtils.isNullOrEmpty(project.getImage())) {
                Picasso.with(mContext).load(project.getImage()).into(((ProjectGridViewHolder) viewHolder).imageView);
                projectGridViewHolder.imageView.setVisibility(View.VISIBLE);
                projectGridViewHolder.defaultimageView.setVisibility(View.GONE);
            } else {
                projectGridViewHolder.defaultimageView.setVisibility(View.VISIBLE);
                projectGridViewHolder.imageView.setVisibility(View.GONE);
            }
            // Display movie rating
            if (TextUtils.isNullOrEmpty(project.getRating()) || project.getRating().equals("0")) {
                projectGridViewHolder.projectRatingIcon.setVisibility(View.GONE);
                projectGridViewHolder.projectRating.setVisibility(View.GONE);

            } else {
                projectGridViewHolder.projectRatingIcon.setVisibility(View.VISIBLE);
                projectGridViewHolder.projectRating.setVisibility(View.VISIBLE);
                projectGridViewHolder.projectRating.setText(project.getRating());
            }

        } else if (viewType == TeamUpApp.VIEW_MODE_LIST) {
            // LIST MODE
            ProjectListViewHolder projectListViewHolder = (ProjectListViewHolder) viewHolder;


            // Title, year and overview
            projectListViewHolder.projectName.setText(project.getName());
            projectListViewHolder.releaseYear.setText(project.getYear());
            projectListViewHolder.overview.setText(project.getOverview());
            // Load image
            // Load image
            if (!TextUtils.isNullOrEmpty(project.getBackgroundImage())) {
                Picasso.with(mContext).load(project.getBackgroundImage()).into(((ProjectListViewHolder) viewHolder).imageView);
                projectListViewHolder.imageView.setVisibility(View.VISIBLE);
                projectListViewHolder.defaultImageView.setVisibility(View.GONE);
            } else if (!TextUtils.isNullOrEmpty(project.getImage())) {
                Picasso.with(mContext).load(project.getImage()).into(((ProjectListViewHolder) viewHolder).imageView);
                projectListViewHolder.imageView.setVisibility(View.VISIBLE);
                projectListViewHolder.defaultImageView.setVisibility(View.GONE);
            } else {
                projectListViewHolder.defaultImageView.setVisibility(View.VISIBLE);
                projectListViewHolder.imageView.setVisibility(View.GONE);
            }
            // Display movie rating
            if (TextUtils.isNullOrEmpty(project.getRating()) || project.getRating().equals("0")) {
                projectListViewHolder.projectRatingIcon.setVisibility(View.GONE);
                projectListViewHolder.projectRating.setVisibility(View.GONE);

            } else {
                projectListViewHolder.projectRatingIcon.setVisibility(View.VISIBLE);
                projectListViewHolder.projectRating.setVisibility(View.VISIBLE);
                projectListViewHolder.projectRating.setText(project.getRating());
            }
        } else {
            // COMPACT MODE
            final ProjectCompactViewHolder projectCompactViewHolder = (ProjectCompactViewHolder) viewHolder;
            // Title and year
            projectCompactViewHolder.projectName.setText(project.getName());
            projectCompactViewHolder.projectYear.setText(project.getYear());
            // Load image$
            if (TextUtils.isNullOrEmpty(project.getBackgroundImage())) {
                projectCompactViewHolder.projectImage.setImageResource(R.drawable.default_backdrop_circle);

            } else {
                int imageSiza = (int) mContext.getResources().getDimension(R.dimen.movie_compact_image_size);
                Picasso.with(mContext).load(project.getBackgroundImage()).into(((ProjectCompactViewHolder) viewHolder).projectImage);

            }
            // Display movie rating
            if (TextUtils.isNullOrEmpty(project.getRating()) || project.getRating().equals("0")) {
                projectCompactViewHolder.projectRatingIcon.setVisibility(View.GONE);
                projectCompactViewHolder.projectRating.setVisibility(View.GONE);
            } else {
                projectCompactViewHolder.projectRatingIcon.setVisibility(View.VISIBLE);
                projectCompactViewHolder.projectRating.setVisibility(View.VISIBLE);
                projectCompactViewHolder.projectRating.setText(project.getRating());
            }
        }
    }


    // loading aproject cover using Glide library
    //
    // Glide.with(mContext).load(project.getImage()).into(holder.image);
    //Picasso.with(mContext).load(project.getImage()).into(holder.image);
    //holder.overflow.setOnClickListener(new View.OnClickListener() {
    //  @Override
    //  public void onClick(View view) {
    //     showPopupMenu(holder.overflow);
    //  }
    //});
    //}

    /**
     * Showing popup menu when tapping on 3 dots
     */
    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_project, popup.getMenu());
        // popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        // popup.show();
    }


    public interface OnProjectClickListener {
        void onProjectClicked(final int position);
    }

    // ViewHolders
    public class ProjectGridViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.project_card)
        CardView cardView;
        @BindView(R.id.project_poster_default)
        ImageView defaultimageView;
        @BindView(R.id.project_poster)
        ImageView imageView;
        @BindView(R.id.project_title)
        TextView projectName;
        @BindView(R.id.project_year)
        TextView releaseYear;
        @BindView(R.id.project_rating)
        TextView projectRating;
        @BindView(R.id.rating_icon)
        ImageView projectRatingIcon;

        public ProjectGridViewHolder(ViewGroup itemView, final OnProjectClickListener onProjectClickListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onProjectClickListener.onProjectClicked(getAdapterPosition());
                }
            });

        }
    }

    public class ProjectListViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.project_card)
        CardView cardView;
        @BindView(R.id.project_poster_default)
        ImageView defaultImageView;
        @BindView(R.id.project_poster)
        ImageView imageView;
        @BindView(R.id.project_title)
        TextView projectName;
        @BindView(R.id.project_year)
        TextView releaseYear;
        @BindView(R.id.project_overview)
        AutoResizeTextView overview;
        @BindView(R.id.project_rating)
        TextView projectRating;
        @BindView(R.id.rating_icon)
        ImageView projectRatingIcon;

        public ProjectListViewHolder(final ViewGroup itemView, final OnProjectClickListener onProjectClickListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onProjectClickListener.onProjectClicked(getAdapterPosition());
                }
            });
        }
    }

    public class ProjectCompactViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.project_item)
        View projectItem;
        @BindView(R.id.project_image)
        ImageView projectImage;
        @BindView(R.id.project_name)
        TextView projectName;
        @BindView(R.id.project_year)
        TextView projectYear;
        @BindView(R.id.project_rating)
        TextView projectRating;
        @BindView(R.id.rating_icon)
        ImageView projectRatingIcon;

        public ProjectCompactViewHolder(final ViewGroup itemView, final OnProjectClickListener onProjectClickListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            projectItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onProjectClickListener.onProjectClicked(getAdapterPosition());
                }
            });
        }
    }
}

/*
public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public ImageView image, overflow;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            image = (ImageView) view.findViewById(R.id.image);
            overflow = (ImageView) view.findViewById(R.id.overflow);
        }
    }
    //****************/

//*********//

/**
 * Click listener for popup menu items
 */
 /*   class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {

        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_add_favourite:
                    Toast.makeText(mContext, "Add to favourite", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_play_next:
                    Toast.makeText(mContext, "Play next", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }


    }*/

