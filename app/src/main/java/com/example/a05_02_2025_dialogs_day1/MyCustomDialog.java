package com.example.a05_02_2025_dialogs_day1;

import android.app.Dialog;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyCustomDialog extends Dialog {

    Context context;

    public interface OnMyCustomDialogClickListener{
        void onPositiveClick();
        void onNegativeClick();
    }

    private OnMyCustomDialogClickListener onMyCustomDialogClickListener;


    public MyCustomDialog(@NonNull Context context, @Nullable OnMyCustomDialogClickListener onMyCustomDialogClickListener) {
        super(context);
        this.context = context;
        this.onMyCustomDialogClickListener = onMyCustomDialogClickListener;
    }


    public void setOnMyCustomDialogClickListener(OnMyCustomDialogClickListener onMyCustomDialogClickListener){
            this.onMyCustomDialogClickListener = onMyCustomDialogClickListener;

    }


}
