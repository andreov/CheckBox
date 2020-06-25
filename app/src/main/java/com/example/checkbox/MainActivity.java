package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText mInMoney;
    private EditText mInfoPayment;
    private CheckBox mCheckKarta;
    private CheckBox mCheckPhone;
    private CheckBox mCheckMoney;
    private String type;
    CompoundButton.OnCheckedChangeListener checkedChangeLilstn = new CompoundButton.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                switch (buttonView.getId()) {
                    case R.id.checkKarta:
                        resetCheckBoxes();
                        mCheckKarta.setChecked(true);
                        mInfoPayment.setInputType(InputType.TYPE_CLASS_NUMBER);
                        type=" банковской картой № ";
                        break;
                    case R.id.checkPfone:
                        resetCheckBoxes();
                        mCheckPhone.setChecked(true);
                        mInfoPayment.setInputType(InputType.TYPE_CLASS_PHONE);
                        type=" мобильным телефоном на номер: ";
                        break;
                    case R.id.checkMoney:
                        resetCheckBoxes();
                        mCheckMoney.setChecked(true);
                        mInfoPayment.setInputType(InputType.TYPE_CLASS_TEXT);
                        type=" наличными по адресу: ";
                        break;
                    default:
                }
            }


        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        Button mBtnClick = findViewById(R.id.btnOK);
        mBtnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mInMoney.getText().length()==0 || mInfoPayment.getText().length()==0)
                    Toast.makeText(MainActivity.this, "Введите данные платежа", Toast.LENGTH_LONG).show();
                else {
                    String text = "Прошла оплата на сумму " + mInMoney.getText() + " руб." + type + mInfoPayment.getText();
                    Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG).show();
                }
            }
        });

    }
    private void initViews(){
        mInMoney=findViewById(R.id.inMoney);
        mInfoPayment=findViewById(R.id.infoPayment);
        mCheckKarta=findViewById(R.id.checkKarta);
        mCheckPhone=findViewById(R.id.checkPfone);
        mCheckMoney=findViewById(R.id.checkMoney);
        mCheckMoney.setOnCheckedChangeListener(checkedChangeLilstn);
        mCheckPhone.setOnCheckedChangeListener(checkedChangeLilstn);
        mCheckKarta.setOnCheckedChangeListener(checkedChangeLilstn);
        mCheckKarta.setChecked(true);
    }
    private void resetCheckBoxes(){
        mCheckKarta.setChecked(false);
        mCheckPhone.setChecked(false);
        mCheckMoney.setChecked(false);

    }
}