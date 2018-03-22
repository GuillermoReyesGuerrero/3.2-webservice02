package com.example.guillermo.webservice02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button click;
    public static TextView datadst;
    public static TextView dataraw;
    public static TextView datastatus;
    public static TextView datazoneid;
    public static TextView datazonename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        click = (Button) findViewById(R.id.getBtn);
        datadst = (TextView) findViewById(R.id.txtdst);
        dataraw = (TextView) findViewById(R.id.txtraw);
        datastatus = (TextView) findViewById(R.id.txtstatus);
        datazoneid = (TextView) findViewById(R.id.txtzoneid);
        datazonename = (TextView) findViewById(R.id.txtzonename);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetJson process = new GetJson();
                process.execute();
            }
        });
    }
}
