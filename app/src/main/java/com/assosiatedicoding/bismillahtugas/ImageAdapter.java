package com.assosiatedicoding.bismillahtugas;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {
    private Context mContext;
    private List<Upload> mUploads;
    private OnItemClickListener mListener;

    public ImageAdapter(Context context, List<Upload> uploads) {
        mContext = context;
        mUploads = uploads;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.image_item, parent, false);
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        Upload uploadCurrent = mUploads.get(position);
        holder.textViewName.setText(uploadCurrent.getName());
        holder.dateTextView.setText(getDateToday());
        Picasso.with(mContext)
                .load(uploadCurrent.getImageUrl())
                .placeholder(R.drawable.imageplaceholder)
                .fit()
                .centerCrop()
                .into(holder.imageView);
    }

    private String getDateToday() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String today = dateFormat.format(date);
        return today;
    }

    @Override
    public int getItemCount() {
        return mUploads.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnCreateContextMenuListener,MenuItem.OnMenuItemClickListener {
        public TextView textViewName;
        public ImageView imageView;
        public TextView dateTextView;

        public ImageViewHolder(View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.img_description);
            imageView = itemView.findViewById(R.id.image_view);
            dateTextView = itemView.findViewById(R.id.dateTextView);

            itemView.setOnClickListener(this);
            itemView.setOnCreateContextMenuListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mListener != null){
                int position = getAdapterPosition();
                if (position !=RecyclerView.NO_POSITION){
                    mListener.onItemClick(position);
                }
            }
        }
        @Override
        public void onCreateContextMenu(ContextMenu menu, View view,ContextMenu.ContextMenuInfo menuInfo){
            menu.setHeaderTitle("Pilih Aksi");
            MenuItem doDetail = menu.add(Menu.NONE,1,1,"Detail Tower");
            MenuItem dodelete = menu.add(Menu.NONE,2,2,"Hapus");

            doDetail.setOnMenuItemClickListener(this);
            dodelete.setOnMenuItemClickListener(this);
        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {
           if (mListener !=null){
               int position = getAdapterPosition();
               if (position != RecyclerView.NO_POSITION){

                   switch (item.getItemId()){
                       case 1:
                           mListener.onDetailTowerClick(position);
                           return true;
                       case 2:
                           mListener.onHapusClick(position);
                           return true;

                   }
               }
           }
           return false;
        }
    }
    public interface OnItemClickListener{
        void onItemClick(int position);

        void onDetailTowerClick(int position);


        void onHapusClick(int position);


    }
    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;

    }
}