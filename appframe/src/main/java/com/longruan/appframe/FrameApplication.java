package com.longruan.appframe;

import com.longruan.appframe.utils.CrashHandler;
import com.longruan.appframe.utils.PropertyUtil;


import org.litepal.LitePal;
import org.litepal.LitePalApplication;

/**
 * <dl>  Class Description
 * <dd> 项目名称：AppFrame
 * <dd> 类名称：FrameApplication
 * <dd> 类描述：自定义Application类
 * <dd> 创建时间：2017/6/6
 * <dd> 修改人：无
 * <dd> 修改时间：无
 * <dd> 修改备注：无
 * </dl>
 *
 * @author ljhl
 * @version 1.0
 */
public class FrameApplication extends LitePalApplication {

    private static FrameApplication mInstance;
    private int appLocation;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        // 初始化异常处理类，出现异常保存日志到sd卡上
        CrashHandler catchHandler = CrashHandler.getInstance();
        catchHandler.init(getApplicationContext());
        LitePal.aesKey("beijinglongruankejigufenyouxiangongsi");
        appLocation = Integer.parseInt(PropertyUtil.getInstance().getValue("appLocation"));
    }

    public static FrameApplication getInstance() {
        return mInstance;
    }

    public int getAppLocation() {
        return appLocation;
    }
}
