package leaderscodes.tn.volunteering.service;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import leaderscodes.tn.volunteering.entity.Action;
import leaderscodes.tn.volunteering.MainApplication;
import leaderscodes.tn.volunteering.entity.Participation;
import leaderscodes.tn.volunteering.utils.ServiceUrl;
import leaderscodes.tn.volunteering.callback.AbstractServicesCallBack;


public class ActionService {


    public void getDemande(final AbstractServicesCallBack<Action> onCallBack) {
        final List<Action> actionList = new ArrayList<>();

        JsonArrayRequest req = new JsonArrayRequest(Request.Method.GET, ServiceUrl.ActionUrl, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        if (response.length() != 0) {
                            for (int i = 0; i < response.length(); i++) {
                                try {
                                    JSONObject c = response.getJSONObject(i);
                                    Action action = new Action();
                                    action.setId(c.getInt("id"));
                                    action.setName(c.getString("name"));
                                    action.setDescription(c.getString("description"));
                                    action.setAddress(c.getString("address"));
                                    action.setDateStart(c.getString("dateStart"));
                                    action.setDateEnd(c.getString("dateEnd"));
                                    action.setNbreVol(c.getInt("nbrVol"));
                                    actionList.add(action);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                            onCallBack.onSuccess(actionList);

                        } else if (response.length() == 0) {
                            onCallBack.noData();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                onCallBack.onFail();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/json");
                return params;
            }


        };
        // Adding request to request queue
        MainApplication.getInstance().addToRequestQueue(req,
                ServiceUrl.tag_json_arry);
    }

    public void AjouterParticipation(final Participation participation) {


        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST, ServiceUrl.AddParticipationUrl+"/"+participation.getId_vol()+"/"+participation.getId_action(), null,

                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/json; charset=utf-8");
                return params;
            }
        };

        // Adding request to request queue
        MainApplication.getInstance().addToRequestQueue(jsonObjReq,
                ServiceUrl.tag_json_arry);

    }
    public void DeleteParticipation(final Participation participation) {


        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.DELETE, ServiceUrl.deletParticipationUrl+"id_vol="+participation.getId_vol()+"&&id_action="+participation.getId_action(), null,

                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/json; charset=utf-8");
                return params;
            }
        };

        // Adding request to request queue
        MainApplication.getInstance().addToRequestQueue(jsonObjReq,
                ServiceUrl.tag_json_arry);

    }
}
