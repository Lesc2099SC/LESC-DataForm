package com.example.administrador.myform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DataConfirm extends AppCompatActivity {
    public String strReturnName;
    public TextView tvNombre;
    public TextView tvTel;
    public TextView tvEmail;
    public TextView tvDesc;
    public TextView tvFecha;
    public static String strReturnTel;
    public static String strReturnEmail;
    public static String strReturnDay;
    public static String strReturnMonth;
    public static String strReturnYear;
    public static String strReturnDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_confirm);
        tvNombre = (TextView)findViewById(R.id.txtNombre);
        tvTel = (TextView)findViewById(R.id.txtTel);
        tvEmail = (TextView)findViewById(R.id.txtEmail);
        tvDesc = (TextView)findViewById(R.id.txtDesc);
        tvFecha = (TextView)findViewById(R.id.txtVFecha);

        Intent intentData = getIntent();
        strReturnName = intentData.getStringExtra("Nombre");
        strReturnTel = intentData.getStringExtra("Tel");
        strReturnEmail = intentData.getStringExtra("Email");
        strReturnDesc = intentData.getStringExtra("Desc");

        tvNombre.setText(intentData.getStringExtra("Nombre"));
        tvTel.setText(intentData.getStringExtra("Tel"));
        tvEmail.setText(intentData.getStringExtra("Email"));
        tvFecha.setText(intentData.getStringExtra("Fecha"));
        tvDesc.setText(intentData.getStringExtra("Desc"));
    }

    public void returnData(View v){
        Intent inReturn = new Intent();
        inReturn.putExtra("Nombre", strReturnName);
        inReturn.putExtra("Tel", strReturnTel);
        inReturn.putExtra("Email", strReturnEmail);
        inReturn.putExtra("Desc", strReturnDesc);
        setResult(RESULT_OK, inReturn);
        finish();
    }
}
