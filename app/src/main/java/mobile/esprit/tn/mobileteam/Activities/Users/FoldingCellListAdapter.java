package mobile.esprit.tn.mobileteam.Activities.Users;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.BackendlessUser;
import com.ramotion.foldingcell.FoldingCell;
import com.squareup.picasso.Picasso;

import java.util.HashSet;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import mobile.esprit.tn.mobileteam.R;

/**
 * Created by ahlem_daoud on 21/02/2017.
 */
public class FoldingCellListAdapter extends ArrayAdapter<BackendlessUser> {
    Context mContext;
    private HashSet<Integer> unfoldedIndexes = new HashSet<>();
    private View.OnClickListener defaultRequestBtnClickListener;
    private String StringImage;


    public FoldingCellListAdapter(Context context, List<BackendlessUser> objects) {

        super(context, 0, objects);
        this.mContext = context;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // get item for selected view
        final BackendlessUser item = getItem(position);
        // if cell is exists - reuse it, if not - create the new one from resource
        FoldingCell cell = (FoldingCell) convertView;
        ViewHolder viewHolder;
        if (cell == null) {
            viewHolder = new ViewHolder();
            LayoutInflater vi = LayoutInflater.from(getContext());
            cell = (FoldingCell) vi.inflate(R.layout.cell, parent, false);
            // binding view parts to view holder
            viewHolder.name = (TextView) cell.findViewById(R.id.title_price);
            viewHolder.time = (TextView) cell.findViewById(R.id.title_time_label);
            viewHolder.coverImage = (ImageView) cell.findViewById(R.id.cover_image);
            viewHolder.fromAddress = (TextView) cell.findViewById(R.id.title_from_address);
            viewHolder.nameBody = (TextView) cell.findViewById(R.id.content_name_view);
            viewHolder.image = (CircleImageView) cell.findViewById(R.id.content_avatar);
            viewHolder.Diplomats = (TextView) cell.findViewById(R.id.title_Diplomat_count);
            viewHolder.pledgePrice = (TextView) cell.findViewById(R.id.title_pledge);
            viewHolder.Biography = (TextView) cell.findViewById(R.id.content_from_address_1);
            viewHolder.contentRequestBtn = (TextView) cell.findViewById(R.id.content_request_btn);
            cell.setTag(viewHolder);
        } else {
            // for existing cell set valid valid state(without animation)
            if (unfoldedIndexes.contains(position)) {
                cell.unfold(true);
            } else {
                cell.fold(true);
            }
            viewHolder = (ViewHolder) cell.getTag();
        }

        // bind data from selected element to view through view holder
        Log.v("profil activity items", String.valueOf(item.getProperty("name")));

        viewHolder.name.setText((String) item.getProperty("name"));
        viewHolder.time.setText(item.getEmail());

        viewHolder.fromAddress.setText((String) item.getProperty("role"));
        viewHolder.nameBody.setText((String) item.getProperty("name"));
        viewHolder.Biography.setText((String) item.getProperty("biography"));

        String image = String.valueOf(item.getProperty("image"));
        String coverimage = String.valueOf(item.getProperty("backgroundImage"));
        Log.v("folding", coverimage);
        Picasso.with(mContext).load(image).placeholder(R.drawable.img_circle_placeholder).into(viewHolder.image);
        Picasso.with(mContext).load(coverimage).into(viewHolder.coverImage);
        viewHolder.Diplomats.setText(item.getEmail());
        viewHolder.pledgePrice.setText(item.getEmail());
        viewHolder.contentRequestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "you clicked on visit profile", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mContext, UserProfile.class);
                String userId = item.getObjectId();
                intent.putExtra("EXTRA_User_ID", userId);
                mContext.startActivity(intent);
            }
        });

        // set custom btn handler for list item from that item
        //if (item.getRequestBtnClickListener() != null) {
        // viewHolder.contentRequestBtn.setOnClickListener(item.getRequestBtnClickListener());
        //  } else {
        // (optionally) add "default" handler if no handler found in item
        //   viewHolder.contentRequestBtn.setOnClickListener(defaultRequestBtnClickListener);
        //}


        return cell;
    }

    // simple methods for register cell state changes
    public void registerToggle(int position) {
        if (unfoldedIndexes.contains(position))
            registerFold(position);
        else
            registerUnfold(position);
    }

    public void registerFold(int position) {
        unfoldedIndexes.remove(position);
    }

    public void registerUnfold(int position) {
        unfoldedIndexes.add(position);
    }

    public View.OnClickListener getDefaultRequestBtnClickListener() {
        return defaultRequestBtnClickListener;
    }

    public void setDefaultRequestBtnClickListener(View.OnClickListener defaultRequestBtnClickListener) {
        this.defaultRequestBtnClickListener = defaultRequestBtnClickListener;
    }

    // View lookup cache
    private static class ViewHolder {
        TextView name;
        TextView contentRequestBtn;
        TextView pledgePrice;
        TextView fromAddress;

        TextView Diplomats;
        CircleImageView image;
        TextView time;
        TextView nameBody;
        TextView Biography;
        ImageView coverImage;

    }
}
