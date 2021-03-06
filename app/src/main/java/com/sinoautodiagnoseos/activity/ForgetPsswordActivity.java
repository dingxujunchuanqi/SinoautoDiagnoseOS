package com.sinoautodiagnoseos.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sinoautodiagnoseos.R;
import com.sinoautodiagnoseos.ui.loginui.SwipeBackActivity;
import com.sinoautodiagnoseos.utils.OnMultiClickListener;
import com.sinoautodiagnoseos.utils.RegexUtils;
import com.sinoautodiagnoseos.utils.ToastUtils;
import com.sinoautodiagnoseos.utils.VerifyCodeManager;

/**
 * Created by 惊吓了时光 on 2017/4/23.
 */

public class ForgetPsswordActivity extends SwipeBackActivity implements View.OnClickListener {

    private EditText verifi_edit;
    private EditText phone_edit;
    private Button nextstep;
    private VerifyCodeManager verifyCodeManager;
    private TextView verifi_send;
    private RelativeLayout image_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgetpsw_activity);
        //防止按钮上弹
        int mode = WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN;
        getWindow().setSoftInputMode(mode);
        initView();
        initListenerOclick();
    }

    private void initListenerOclick() {
        image_back.setOnClickListener(this);
        verifi_send.setOnClickListener(new OnMultiClickListener() {
            @Override
            public void onMultiClick(View v) {
                //TODO:请求三方接口发送验证码
                //发送之前对号码进行验证
                verifyCodeManager.getVerifyCode(VerifyCodeManager.RESET_PWD);
            }
        });
        nextstep.setOnClickListener(new OnMultiClickListener() {
            @Override
            public void onMultiClick(View v) {
                commit();
            }
        });

    }

    private void initView() {
        phone_edit = (EditText) findViewById(R.id.phone_edit);
        verifi_edit = (EditText) findViewById(R.id.verifi_edit);
        verifi_send = (TextView) findViewById(R.id.verifi_send);
        nextstep = (Button) findViewById(R.id.next_step);
        image_back = (RelativeLayout) findViewById(R.id.back_click);
        verifyCodeManager = new VerifyCodeManager(this, phone_edit, verifi_send);
    }

    private void commit() {
        String phone = phone_edit.getText().toString().trim();
        String verifi_code = verifi_edit.getText().toString().trim();

//        if (checkInput(phone, verifi_code)) {
        //TODO:请求三方接口发送验证码
        //发送之前对号码进行验证, 提交手机号，验证码
        //  SMSSDK.submitVerificationCode("86", phone, verifi_code);
        Intent intent = new Intent(ForgetPsswordActivity.this, ForgetPswSecondActivity.class);
        startActivity(intent);
        // finish();
        System.out.println("---------------");
        ToastUtils.showShort(ForgetPsswordActivity.this, "欢迎下一步");
//        }
    }

    private boolean checkInput(String phone, String code) {
        if (TextUtils.isEmpty(phone)) { // 电话号码为空
            ToastUtils.showShort(this, R.string.tip_phone_can_not_be_empty);
        } else {
            if (!RegexUtils.checkMobile(phone)) { // 电话号码格式有误
                ToastUtils.showShort(this, R.string.tip_phone_regex_not_right);
            } else if (TextUtils.isEmpty(code)) { // 验证码不正确
                ToastUtils.showShort(this, R.string.tip_please_input_code);

            } else {
                return true;

            }
        }
        return false;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_click:
                finish();
                break;
            default:
                break;
        }
    }
}