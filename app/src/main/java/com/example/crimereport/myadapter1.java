package com.example.crimereport;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class myadapter1 extends FirebaseRecyclerAdapter <model2,myadapter1.myviewholder> {

    public myadapter1(@NonNull FirebaseRecyclerOptions<model2> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull model2 model) {

       holder.crime_type.setText(model.type);
        holder.crime_location.setText(model.location);
        holder.crime_date.setText(model.date);
        holder.description.setText(model.des);
        Glide.with(holder.pimg2.getContext()).load(model.getPimg2()).into(holder.pimg2);

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow, parent, false);
        return new myviewholder(view);
    }


    class myviewholder extends RecyclerView.ViewHolder{


        CircleImageView pimg2;
        TextView   crime_type, crime_date,crime_location,description;



        public myviewholder(@NonNull View itemView) {
            super(itemView);

            pimg2=(CircleImageView) itemView.findViewById(R.id.img1);
            crime_type=(TextView)itemView.findViewById(R.id.typetext);
            crime_date=(TextView)itemView.findViewById(R.id.datetext);
            crime_location=(TextView)itemView.findViewById(R.id.locationtext);
            description=(TextView)itemView.findViewById(R.id.des);

        }
    }
}
