package de.schrotthandel.notflix_streaming;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.List;
public class SeriesAdapter extends RecyclerView.Adapter<SeriesAdapter.ViewHolder> {

    private final List<SeriesModel> seriesModelList;
    private final Context context;

    public SeriesAdapter(List<SeriesModel> seriesModelList, Context context) {
        this.seriesModelList = seriesModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public SeriesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SeriesAdapter.ViewHolder holder, int position) {
        SeriesModel seriesModel = seriesModelList.get(position);

        holder.titleTextview.setText(seriesModel.getTitle());
        holder.descriptionTextview.setText(seriesModel.getDescription());
        holder.episodeTextview.setText("Episode: "+seriesModel.getAllEpisodes());
        holder.seasonTextview.setText("Staffel: " + seriesModel.getCurrentSeason());

        Glide.with(context).load(seriesModel.getImgCover()).into(holder.imageCoverImageview);


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context,EpisodeDetailsActivity.class);
                context.startActivity(intent);

                Toast.makeText(context.getApplicationContext(), String.valueOf(seriesModel.getNumberofSeasons()), Toast.LENGTH_LONG).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return seriesModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView titleTextview;
        TextView descriptionTextview;
        TextView episodeTextview;
        TextView seasonTextview;
        ImageView imageCoverImageview;

        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            titleTextview = itemView.findViewById(R.id.titleTextView);
            descriptionTextview = itemView.findViewById(R.id.descriptionTextView);
            episodeTextview = itemView.findViewById(R.id.EpisodeNumberTextView);
            seasonTextview = itemView.findViewById(R.id.SeasonNumberTextView);
            imageCoverImageview = itemView.findViewById(R.id.imageView);
            cardView = itemView.findViewById(R.id.cardview);

        }
    }
}
