package leaderscodes.tn.volunteering.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import leaderscodes.tn.volunteering.R;
import leaderscodes.tn.volunteering.adapter.ActionAdapter;
import leaderscodes.tn.volunteering.entity.Action;
import leaderscodes.tn.volunteering.service.ActionService;
import leaderscodes.tn.volunteering.callback.AbstractServicesCallBack;


public class ActionFragment extends Fragment {

    ActionService actionService= new ActionService();
    private ActionAdapter actionAdapter;
    RecyclerView ActionRv;

    public ActionFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_action, container, false);
        ActionRv=(RecyclerView)view.findViewById(R.id.Actionrv);
        ActionRv.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        ActionRv.setLayoutManager(mLayoutManager);
        ActionRv.setItemAnimator(new DefaultItemAnimator());
        getdata();
        return view;
    }
    public void getdata() {
        actionService.getDemande(new AbstractServicesCallBack<Action>() {
            @Override
            public void onSuccess(final List t) {

                actionAdapter = new ActionAdapter(t,getActivity());
                ActionRv.setAdapter(actionAdapter);

            }

        });
    }


}
