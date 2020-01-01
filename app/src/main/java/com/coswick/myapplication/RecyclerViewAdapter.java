package com.coswick.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>  implements Filterable {

    private List<Model> mData;
    private Context mContext;
    private List<Model> exampleListFull;


     static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_resep_title;
        ImageView img_resep_thumbnail;
        CardView cardView;


     MyViewHolder(View itemView){
            super(itemView);

            tv_resep_title = (TextView) itemView.findViewById(R.id.resep_title_id);
            img_resep_thumbnail = (ImageView) itemView.findViewById(R.id.resep_img_id);
            cardView = (CardView) itemView.findViewById(R.id.cardview_id);
        }
    }


    public RecyclerViewAdapter(Context mContext, List<Model> mData) {
        this.mContext = mContext;
        this.mData = mData;
        exampleListFull = new ArrayList<>(mData);
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View view;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_film,
                parent, false);
        return new MyViewHolder(v);
    }






    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.tv_resep_title.setText(mData.get(position).getTitle());
        holder.img_resep_thumbnail.setImageResource(mData.get(position).getThumbnail());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,DetailFilm.class);

                //passing data to the book activity
                intent.putExtra("Title",mData.get(position).getTitle());
                intent.putExtra("Description",mData.get(position).getDescription());
                intent.putExtra("Thumbnail",mData.get(position).getThumbnail());
                intent.putExtra("Categori",mData.get(position).getCategory());


                //start the activity
                mContext.startActivity(intent);

            }
        });

    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Model> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(exampleListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Model item : exampleListFull) {
                    if (item.getTitle().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mData.clear();
            mData.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };




}
