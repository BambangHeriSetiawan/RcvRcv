package com.codekopi.rcvrcv.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.codekopi.rcvrcv.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseActivity extends AppCompatActivity {
  private FirebaseDatabase mDatabase;
  private DatabaseReference mRef,listTiketRef;
  private AdapterRcvFirebase adapterRcvFirebase;

  @BindView(R.id.rcvFirebase)RecyclerView rcvFirebase;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_firebase);
    ButterKnife.bind(this);
    mDatabase =FirebaseDatabase.getInstance();
    mRef = mDatabase.getReference().child(Const.Tiket);
    listTiketRef = mRef.child(Const.ListTiket);
    listTiketRef.addChildEventListener(new ChildEventListener() {
      @Override
      public void onChildAdded(DataSnapshot dataSnapshot, String s) {
        adapterRcvFirebase.notifyDataSetChanged();
      }

      @Override
      public void onChildChanged(DataSnapshot dataSnapshot, String s) {
        adapterRcvFirebase.notifyDataSetChanged();
      }

      @Override
      public void onChildRemoved(DataSnapshot dataSnapshot) {
        adapterRcvFirebase.notifyDataSetChanged();
      }

      @Override
      public void onChildMoved(DataSnapshot dataSnapshot, String s) {
        adapterRcvFirebase.notifyDataSetChanged();
      }

      @Override
      public void onCancelled(DatabaseError databaseError) {

      }
    });
    adapterRcvFirebase = new AdapterRcvFirebase(ListTiket.class,R.layout.item_firebase,RcvViewHolder.class,listTiketRef,getApplicationContext());
    rcvFirebase.setHasFixedSize(true);
    rcvFirebase.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
    rcvFirebase.setAdapter(adapterRcvFirebase);
  }
}
