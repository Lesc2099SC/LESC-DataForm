package com.example.administrador.myform;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public String strName;

    private String strTel;
    private String strEmail;
    private String strDesc;
    private String strDay;
    private String strMonth;
    private String strYear;
    private String strFecha;


    public TextInputEditText txtInpName;
    public TextInputEditText tEditName;
    public TextInputEditText tEditTel;
    public TextInputEditText tEditEmail;
    public TextInputEditText tEditDesc;
    public DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void callDataConfirmAct(View v){

        txtInpName = (TextInputEditText) findViewById(R.id.inpNombre);
        tEditName = (TextInputEditText) findViewById(R.id.inpNombre);
        tEditTel =(TextInputEditText) findViewById(R.id.inpTelefono);
        tEditEmail =(TextInputEditText) findViewById(R.id.inpEmail);
        tEditDesc = (TextInputEditText) findViewById(R.id.inpDesc);
        datePicker = (DatePicker) findViewById(R.id.dpFechaDeNacimiento);

        strName = txtInpName.getText().toString();
        strDay = String.valueOf(datePicker.getDayOfMonth());
        strMonth = String.valueOf(datePicker.getMonth());
        strYear = String.valueOf(datePicker.getYear());
        strFecha = strDay+"/"+strMonth+"/"+strYear;

        strEmail = tEditEmail.getText().toString();
        strTel = tEditTel.getText().toString();
        strDesc = tEditDesc.getText().toString();


        //Toast.makeText(this, strName, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(MainActivity.this, DataConfirm.class);
        intent.putExtra("Nombre", strName);
        intent.putExtra("Tel", strTel);
        intent.putExtra("Email", strEmail);
        intent.putExtra("Desc", strDesc);
        intent.putExtra("Fecha", strFecha);
        intent.putExtra("Dia", strDay);
        intent.putExtra("Year", strYear);
        intent.putExtra("Mes", strMonth);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String strReturnName = data.getStringExtra("Nombre");
                Toast.makeText(this, strReturnName, Toast.LENGTH_SHORT).show();
                txtInpName = (TextInputEditText) findViewById(R.id.inpNombre);
                txtInpName.setText(strReturnName);
            }
        }
    }
}
