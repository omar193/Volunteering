package leaderscodes.tn.volunteering.callback;

import java.util.List;


public interface ServicesCallBack <T>{
     void onSuccess(List<T> List);
     void onSuccess(T t);
     void onFail();

    void noData();

}
