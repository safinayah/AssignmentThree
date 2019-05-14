package com.example.assignment;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private String[] names;
    private String[] contents;
    private int[] imageIds;


    public MyAdapter(String[] names, String[] contents, int[] imageIds) {
        this.names = names;
        this.contents = contents;
        this.imageIds = imageIds;
    }




    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        CardView cardView = holder.cardView;
        ImageView imageView = (ImageView) cardView.findViewById(R.id.image);
        Drawable dr = ContextCompat.getDrawable(cardView.getContext(), imageIds[position]);

        imageView.setImageDrawable(dr);

         TextView nametext = (TextView)cardView.findViewById(R.id.txtName);
         TextView content = (TextView)cardView.findViewById(R.id.txtContent);




        nametext.setText(contents[position]);




        cardView.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                v.getContext().startActivity(new Intent(v.getContext(), edit.class));
            }
        });
    }


    @Override
    public int getItemCount() {
      return contents.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;

        public ViewHolder(CardView cardView){
            super(cardView);
            this.cardView = cardView;
        }

    }



}