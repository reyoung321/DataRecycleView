package com.kishor_bhattarai.datarecycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.kishor_bhattarai.datarecycleview.adapter.DatasAdapter;
import com.kishor_bhattarai.datarecycleview.model.DataRecycle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etName, etAge;
    RadioGroup rdoGender;
    RadioButton rdoMale, rdoFemale, rdoOthers;
    Button btnSave;
    RecyclerView rcvData;
    Spinner spnImage;
    private String kings[] = {
            "Select Image Name",
            "birendra_bir_bikram_shah",
            "mahendra_bir_bikram_shah",
            "surendra_bikram_shah",
            "prithvi_narayan_shah"
    };
    private String gender;
    private int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        rdoMale = findViewById(R.id.rdoMale);
        rdoFemale = findViewById(R.id.rdoFemale);
        rdoOthers =findViewById(R.id.rdoOthers);
        btnSave = findViewById(R.id.btnSave);
        spnImage = findViewById(R.id.spnImage);
        rcvData = findViewById(R.id.rcvData);

        ArrayAdapter arrayAdapter = new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                kings
        );

        spnImage.setAdapter(arrayAdapter);

        spnImage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (spnImage.getSelectedItem().toString().equals("birendra_bir_bikram_shah")){
                    image = R.drawable.birendra_bir_bikram_shah;
                }
                else if (spnImage.getSelectedItem().toString().equals("mahendra_bir_bikram_shah")){
                    image = R.drawable.mahendra_bir_bikram_shah;
                }
                else if (spnImage.getSelectedItem().toString().equals("surendra_bikram_shah")){
                    image = R.drawable.surendra_bikram_shah;
                }
                else if (spnImage.getSelectedItem().toString().equals("prithvi_narayan_shah")){
                    image = R.drawable.prithvi_narayan_shah;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        rdoMale.setOnClickListener(this);
        rdoFemale.setOnClickListener(this);
        rdoOthers.setOnClickListener(this);
        btnSave.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rdoMale :
                gender = "Male";
                break;
            case R.id.rdoFemale :
                gender = "Female";
                break;
            case R.id.rdoOthers :
                gender = "Others";
                break;
            case R.id.btnSave :
                if (TextUtils.isEmpty(etName.getText().toString())){
                    etName.setError("please enter name");
                }
                if (TextUtils.isEmpty(etAge.getText().toString())){
                    etAge.setError("please enter Age");
                }
                else {
                    List<DataRecycle> dataRecycleList = new ArrayList<>();
                    dataRecycleList.add(new DataRecycle(etName.getText().toString(), etAge.getText().toString(), gender, image));
                    DatasAdapter datasAdapter = new DatasAdapter(this, dataRecycleList);
                    rcvData.setAdapter(datasAdapter);
                    rcvData.setLayoutManager(new LinearLayoutManager(this));
                    etName.getText().clear();
                    etAge.getText().clear();
                }
                break;

        }

    }
}

