package com.tech.gigabyte.listfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by GIGABYTE on 5/25/2017.
 */

public class ListFragment extends android.app.ListFragment {

    // Array of strings storing  names
    String[] social = new String[] {
            "Youtube",
            "Blogger",
            "Facebook",
            "Instagram",
            "Twitter",
            "Whatsapp"
    };

    // Array of strings storing  Description
    String[] description = new String[] {
            "Youtube Description",
            "Blogger description",
            "Facebook description",
            "Instagram Description",
            "Twitter Description",
            "Whatsapp description"
    };

    // Array of integers points to images stored in /res/drawable/
    int[] images = new int[]{
            R.drawable.youtube,
            R.drawable.blogger,
            R.drawable.facebook,
            R.drawable.instagram,
            R.drawable.twitter,
            R.drawable.whatsapp
    };

    ArrayList<HashMap<String, String>> data= new ArrayList<HashMap<String, String>>();
    SimpleAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        //MAP
        HashMap<String, String> map=new HashMap<String, String>();;
        //FILL
        for(int i=0;i<social.length;i++)
        {
            map= new HashMap<String, String>();
            map.put("social", social[i]);
            map.put("description",description[i]);
            map.put("Image", Integer.toString(images[i]));
            data.add(map);
        }
        //KEYS IN MAP
        String[] from={"social","description","Image"};
        //IDS OF VIEWS
        int[] to={R.id.nameTxt,R.id.desTxt,R.id.imageView1};
        //ADAPTER
        adapter=new SimpleAdapter(getActivity(), data, R.layout.list_fragment, from, to);
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
    @Override
    public void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> av, View v, int pos,
                                    long id) {
                // TODO Auto-generated method stub
                Toast.makeText(getActivity(), data.get(pos).get("social"), Toast.LENGTH_SHORT).show();
            }
        });
    }
}