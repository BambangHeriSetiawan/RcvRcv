package com.codekopi.rcvrcv;

import android.opengl.Visibility;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Listener {
    @BindView(R.id.rcv_ca)RecyclerView rcvCa;
    @BindView(R.id.rcv_ma)RecyclerView rcvMa;
    @BindView(R.id.tvEmptyListTop)TextView tvEmpetyTop;
    @BindView(R.id.tvEmptyListBottom)TextView tvEmpetyBotton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initUI();
        initRcvTop();
        initRcvBotton();
    }

    private void initRcvBotton() {
        rcvMa.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        List<String> listMa = new ArrayList<>();
        listMa.add("MA 1");
        listMa.add("MA 2");
        listMa.add("MA 3");
        listMa.add("MA 4");
        ListAdapter adapter = new ListAdapter(listMa,this);
        rcvMa.setAdapter(adapter);
        tvEmpetyBotton.setOnDragListener(adapter.getDragInstance());
        rcvMa.setOnDragListener(adapter.getDragInstance());
    }

    private void initRcvTop() {
        rcvCa.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        List<String> listCa = new ArrayList<>();
        listCa.add("CA 1");
        listCa.add("CA 2");
        listCa.add("CA 3");
        listCa.add("CA 4");
        ListAdapter adapter = new ListAdapter(listCa,this);
        rcvCa.setAdapter(adapter);
        tvEmpetyTop.setOnDragListener(adapter.getDragInstance());
        rcvCa.setOnDragListener(adapter.getDragInstance());
    }

    private void initUI() {
        tvEmpetyTop.setVisibility(View.GONE);
        tvEmpetyBotton.setVisibility(View.GONE);
    }

    @Override
    public void setEmptyListTop(boolean visibility) {
        tvEmpetyTop.setVisibility(visibility ? View.VISIBLE : View.GONE );
        rcvCa.setVisibility(visibility ? View.VISIBLE : View.GONE );


    }

    @Override
    public void setEmptyListBottom(boolean visibility) {
        tvEmpetyBotton.setVisibility(visibility ? View.VISIBLE : View.GONE );
        rcvMa.setVisibility(visibility ? View.VISIBLE : View.GONE );
    }
}
