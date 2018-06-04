package com.longruan.appframe.base;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

public class ActivityLifecycleManager implements Application.ActivityLifecycleCallbacks {
    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (activity instanceof IBaseActivity) {
            IBaseActivity iBaseActivity = (IBaseActivity) activity;
            //Dagger inject
            iBaseActivity.initInject();
            //attach to presenter
            if (iBaseActivity.getPresenter() != null) {
                iBaseActivity.getPresenter().attachView((BaseView) activity);
//                Log.d("rainmin","attachView: " + activity.getLocalClassName());
            }
        }
    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        if (activity instanceof IBaseActivity) {
            IBaseActivity iBaseActivity = (IBaseActivity) activity;
            if (iBaseActivity.getPresenter() != null) {
                iBaseActivity.getPresenter().detachView();
//                Log.d("rainmin","detachView: " + activity.getLocalClassName());
            }
        }
    }
}
