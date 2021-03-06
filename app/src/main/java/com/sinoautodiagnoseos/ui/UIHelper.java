package com.sinoautodiagnoseos.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.sinoautodiagnoseos.activity.CarInfoActivity;
import com.sinoautodiagnoseos.activity.ExpertsCertificationActivity;
import com.sinoautodiagnoseos.activity.FeedBackActivity;
import com.sinoautodiagnoseos.activity.ForgetPsswordActivity;
import com.sinoautodiagnoseos.activity.LoginActivity;
import com.sinoautodiagnoseos.activity.MainActivity;
import com.sinoautodiagnoseos.activity.PersonalCenterActivity;
import com.sinoautodiagnoseos.activity.PersonalInfoActivity;
import com.sinoautodiagnoseos.activity.SelectStoresActivity;
import com.sinoautodiagnoseos.activity.ServiceDetailActivity;
import com.sinoautodiagnoseos.activity.SettingActivity;
import com.sinoautodiagnoseos.activity.SkillManagementActivity;
import com.sinoautodiagnoseos.activity.TechnicianCertifActivity;
import com.sinoautodiagnoseos.activity.TransportationSelectionActivity;
import com.sinoautodiagnoseos.entity.CarBrands.CarBrands;
import com.sinoautodiagnoseos.entity.CarBrands.CarInfo;
import com.sinoautodiagnoseos.entity.FaulTranges.FaulTranges;
import com.sinoautodiagnoseos.entity.User.Skill;
import com.sinoautodiagnoseos.entity.User.UserInfo;
import com.sinoautodiagnoseos.utils.Constant;

import java.io.Serializable;
import java.util.List;

/**
 * 应用程序UI工具包：封装UI相关的一些操作
 * Created by HQ_Demos on 2017/4/24.
 */

public class UIHelper {
    public final static String TAG = "UIHelper";

    public final static int RESULT_OK = 0x00;
    public final static int REQUEST_CODE = 0x01;

    public static void ToastMessage(Context cont,String msg){
        if (cont==null||msg==null){
            return;
        }
        Toast.makeText(cont,msg,Toast.LENGTH_SHORT).show();
    }

    public static void ToastMessage(Context cont, int msg) {
        if(cont == null || msg <= 0) {
            return;
        }
        Toast.makeText(cont, msg, Toast.LENGTH_SHORT).show();
    }

    public static void ToastMessage(Context cont, String msg, int time) {
        if(cont == null || msg == null) {
            return;
        }
        Toast.makeText(cont, msg, time).show();
    }

    public static void showDiagnose(Activity context){
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    public static void showCircle(Activity context){
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    public static void showIm(Activity context){
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    public static void showStudy(Activity context){
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }
    /*
    * 跳到个人信息界面 携带数据传送过去
    *
    */
    public static void showPersonInfo(Activity context,  UserInfo data) {
        Intent mIntent = new Intent(context, PersonalInfoActivity.class);
        Bundle mBundle = new Bundle();
        mBundle.putSerializable("userdata", data);
        mIntent.putExtras(mBundle);
        context.startActivity(mIntent);
//        Intent mIntent = new Intent(context, PersonalInfoActivity.class);
//        context.startActivity(mIntent);
    }
    /**
     *
     * 跳转到技师认证界面,携带数据传送过去
     *@author dingxujun
     *created at 2017/5/15 13:21
     */
    public static void showTechCertification(Activity context, Skill skill){
        Intent intent = new Intent(context, TechnicianCertifActivity.class);
        Bundle mBundle = new Bundle();
        mBundle.putSerializable("skill", skill);
        intent.putExtras(mBundle);
        context.startActivity(intent);
    }
    /**
     *跳到门店选择界面
     *@author dingxujun
     *created at 2017/5/16 13:19
     */
    public static void showSelectStore(Activity context){
        Intent intent =new Intent(context,SelectStoresActivity.class);
        context.startActivityForResult(intent, Constant.REQUEST_CODE_106);
    }
      /*
    * 跳到专家认证界面
    *
    * */

    public static void showExpertsCertification(Activity context){
        Intent intent =new Intent(context,ExpertsCertificationActivity.class);
        context.startActivity(intent);
    }
    /*
    * 跳到技能管理界面
    *
    * */

    public static void showSkillManagement(Activity context){
        Intent intent =new Intent(context,SkillManagementActivity.class);
        context.startActivity(intent);
    }
  /*
    * 跳到车辆选择界面
    *
    * */

    public static void showTransportionSelection(Activity context, CarBrands carBrands, FaulTranges faulTranges){
        Intent intent =new Intent(context,TransportationSelectionActivity.class);
        Bundle mbundle =new Bundle();
         mbundle.putSerializable("carBrands",carBrands);
         mbundle.putSerializable("faulTranges",faulTranges);
        intent.putExtras(mbundle);
        context.startActivityForResult(intent,Constant.REQUEST_CODE_107);
    }
    /**
    *跳到个人中心界面
    *@author dingxujun
    *created at 2017/6/2 9:09
    */

    public static void showPersonalCenter(Activity context){
        Intent intent =new Intent(context,PersonalCenterActivity.class);
        context.startActivity(intent);
    }
    public static void showLogin(Activity context){
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
//        ToastMessage(AppContext.getInstance().getApplicationContext(),"此处需要登录");
    }

    /**
     * 个人中心中的设置页面
     * @param context
     */
    public static void showSettingActivity(Activity context){
        Intent intent=new Intent(context,SettingActivity.class);
        context.startActivity(intent);
    }

    /**
     *  修改密码页面
     * @param context
     */
    public static void showFgtPsd(Activity context){
        Intent intent =new Intent(context, ForgetPsswordActivity.class);
        context.startActivity(intent);
    }

    /**
     *  意见反馈页面
     * @param context
     */
    public static void showFeedBack(Activity context){
        Intent intent =new Intent(context, FeedBackActivity.class);
        context.startActivity(intent);
    }

    public static void showServiceDetail(Activity context,int caseId,String title){
        Intent intent =new Intent(context, ServiceDetailActivity.class);
        intent.putExtra("caseId",caseId);
        intent.putExtra("title",title);
        context.startActivity(intent);
    }

    public static void showCarInfoActivity(Activity context, List<CarInfo> carInfoList){
        Intent intent =new Intent(context, CarInfoActivity.class);
        intent.putExtra("carInfoList", (Serializable) carInfoList);
        context.startActivityForResult(intent, 1000);
    }
}
