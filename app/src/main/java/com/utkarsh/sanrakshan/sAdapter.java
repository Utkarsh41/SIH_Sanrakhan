package com.utkarsh.sanrakshan;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class sAdapter extends FirebaseRecyclerAdapter<MyData, sAdapter.sViewholder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public sAdapter(@NonNull FirebaseRecyclerOptions<MyData> options) {
        super(options);
    }


    @Override
    protected void onBindViewHolder(@NonNull sViewholder holder, int position, @NonNull MyData model) {
        holder.initial.setText(model.getInitial());
        holder.current.setText(model.getCurrent());
        holder.status.setText(model.getStatus());
    }
    @NonNull
    @Override
    public sViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ut,parent,false);
        return new sAdapter.sViewholder(view);

    }



    class sViewholder extends RecyclerView.ViewHolder {
        TextView initial,current,status;
        public sViewholder(@NonNull View itemView) {
            super(itemView);
            initial=itemView.findViewById(R.id.initial_Tv);
            current=itemView.findViewById(R.id.load_FinalTv);
            status=itemView.findViewById(R.id.load_StatusTv);
        }
    }
}
