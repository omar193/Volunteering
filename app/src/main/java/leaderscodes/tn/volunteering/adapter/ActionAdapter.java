package leaderscodes.tn.volunteering.adapter;

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import leaderscodes.tn.volunteering.entity.Participation;
import leaderscodes.tn.volunteering.R;
import leaderscodes.tn.volunteering.entity.Action;
import leaderscodes.tn.volunteering.service.ActionService;


public class ActionAdapter extends RecyclerView.Adapter<ActionAdapter.ParkingRecycleViewHolder> {

    private List<Action> ActionRecycleViewList;
    Context context;
    boolean participation=false;


    public class ParkingRecycleViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView libelle;
        TextView Adresse;
        TextView description;
        TextView dateStart;
        TextView dateEnd;
        TextView nbreVol;
        Button participate;


        public ParkingRecycleViewHolder(final View row) {
            super(row);

            cv = (CardView) row.findViewById(R.id.placeCard);
            libelle = (TextView) row.findViewById(R.id.libelle);
            Adresse = (TextView) row.findViewById(R.id.Adresse);
            description = (TextView) row.findViewById(R.id.description);
            dateStart = (TextView) row.findViewById(R.id.dateStart);
            dateEnd = (TextView) row.findViewById(R.id.dateEnd);
            nbreVol = (TextView) row.findViewById(R.id.nbreVol);
            participate = (Button) row.findViewById(R.id.participate);
            //button de participation ou annulation
            participate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!participation) {
                        new ActionService().AjouterParticipation(new Participation(16, ActionRecycleViewList.get(getPosition()).getId()));
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            participate.setBackground(context.getDrawable(R.drawable.canceltheapplication_cancelar_2901));
                        }
                        participation=true;
                    } else {
                        new ActionService().DeleteParticipation(new Participation(16, ActionRecycleViewList.get(getPosition()).getId()));
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            participate.setBackground(context.getDrawable(R.drawable.volunteer_icon));
                        }
                        participation=false;
                    }
                }
            });
        }
    }

    public ActionAdapter(List<Action> ActionRecycleViewList, Context context) {
        this.ActionRecycleViewList = ActionRecycleViewList;
        this.context = context;
    }

    @Override
    public ParkingRecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_parking, parent, false);
        return new ParkingRecycleViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ParkingRecycleViewHolder holder, final int position) {
        final Action action = ActionRecycleViewList.get(position);
        holder.libelle.setText(action.getName());
        holder.Adresse.setText(action.getAddress());
        holder.description.setText(action.getDescription());
        holder.Adresse.setText(action.getAddress());

        holder.dateStart.setText(action.getDateStart() + "");
        holder.dateEnd.setText((action.getDateEnd() + ""));
        holder.nbreVol.setText(String.valueOf(action.getNbreVol()));
    }

    @Override
    public int getItemCount() {
        return ActionRecycleViewList.size();
    }
}



