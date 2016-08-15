package mobile.esprit.tn.mobileteam.Adapters.Project;

import android.content.Context;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;

import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.List;

import mobile.esprit.tn.mobileteam.Activities.Project.Project_detail_activity;
import mobile.esprit.tn.mobileteam.Activities.Project.ProjectsDisplay;
import mobile.esprit.tn.mobileteam.Models.Project;
import mobile.esprit.tn.mobileteam.R;

/**
 * Created by ahlem on 30/07/2016.
 */
public class ProjectsAdapter  extends RecyclerView.Adapter<ProjectsAdapter.MyViewHolder > {
    private Context mContext;
    private List<Project> projectList;

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
    public ProjectsAdapter(Context mContext, List<Project> projectList) {
        this.mContext = mContext;
        this.projectList = projectList;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
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

        });*/
        return new MyViewHolder(itemView);

    }
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Project project = projectList.get(position);
        Log.v("ProjectDisplayAdapter: ", String.valueOf(projectList.size()));
        holder.name.setText(project.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext,"you clicked on item number"+ getItemCount(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mContext, Project_detail_activity.class);

                intent.putExtra(Project_detail_activity.EXTRA_NAME,  holder.name.toString());
                mContext.startActivity(intent);
            }
        });




        // loading aproject cover using Glide library
        //
        // Glide.with(mContext).load(project.getImage()).into(holder.image);
        Picasso.with(mContext).load(project.getImage()).into(holder.image);
        holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(holder.overflow);
            }
        });
    }
    /**
     * Showing popup menu when tapping on 3 dots
     */
    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_project, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }
    /**
     * Click listener for popup menu items
     */
    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

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


    }
    //****************//test on item  click listener

    //*********//

    @Override
    public int getItemCount() {
        return projectList.size();
    }

}
