package fr.example.logpmr.HomeAdapter;

import static android.os.Build.VERSION_CODES.R;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FeaturedAdapter extends RecyclerView.Adapter <FeaturedAdapter.FeaturedViewHoler>{

    ArrayList<featuredHelperClass> featuredLocations;

    public FeaturedAdapter(ArrayList<featuredHelperClass> featuredLocations) {
        this.featuredLocations = featuredLocations;
    }

    @NonNull
    @Override
    public FeaturedViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedViewHoler holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static  class FeaturedViewHoler extends RecyclerView.ViewHolder{

             ImageView image;
             TextView title, desc;
        public FeaturedViewHoler(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.featured_image);
            title = itemView.findViewById(R .id.featured_title);
            desc = itemView.findViewById(R.id.featured_desc);

        }
    }


}
