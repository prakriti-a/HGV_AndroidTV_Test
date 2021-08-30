package com.prakriti.hgvandroidtvtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class GridViewAdapter extends RecyclerView.Adapter<GridViewAdapter.MyViewHolder> {

    private Context context;

    private String heroes[] = new String[]{"IRON MAN", "CAPTAIN AMERICA", "SPIDERMAN", "THOR", "HULK", "BLACK WIDOW", "HAWKEYE"};
    private int images[] = {R.drawable.ironman, R.drawable.captainamerica, R.drawable.spiderman, R.drawable.thor, R.drawable.hulk,
            R.drawable.blackwidow, R.drawable.hawkeye};

    public GridViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.myText.setText(heroes[position]);
        holder.myImage.setImageResource(images[position]);
        holder.myImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View image) {
                YoYo.with(Techniques.Pulse).duration(300).playOn(image);
//                        .withEndAction(new Runnable() {
//                            @Override
//                            public void run() {
//                                holder.myImage.setPadding(8, 8, 8, 8);
//                                holder.myImage.setScaleType(ImageView.ScaleType.FIT_CENTER);
//                            }
//                        });
                Toast.makeText(context, heroes[position], Toast.LENGTH_SHORT).show();
            }
        });
        holder.linearLayout.setOnFocusChangeListener(new View.OnFocusChangeListener() { // check this
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus) {
                    holder.linearLayout.animate().scaleX(1.15f).scaleY(1.15f);
                }
                else {
                    holder.linearLayout.animate().scaleX(1.0f).scaleY(1.0f);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return images.length;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView myText;
        ImageView myImage;
        LinearLayout linearLayout;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myImage = itemView.findViewById(R.id.myImage);
            myText = itemView.findViewById(R.id.myText);
            linearLayout = itemView.findViewById(R.id.linearLayout);
        }
    }



}
