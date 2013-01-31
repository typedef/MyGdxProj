package com.example.GridView_android;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;


public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        GridView gridView = (GridView)findViewById(R.id.gridview);
        gridView.setAdapter(new ImageAdapter(this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(MyActivity.this, "---" + position, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private  class ImageAdapter extends BaseAdapter
    {
          private Context mContext;

          public ImageAdapter(Context contextValue)
          {
              mContext = contextValue;
          }

          public int  getCount(){
              return mThumbIds.length;
          }

          public Object getItem(int pos)
          {
              return null;
          }
          public long getItemId(int pos)
          {
              return 0;
          }
          public View getView(int postion, View convertView, ViewGroup parent){

              ImageView imageView;
              if (convertView == null){
                   imageView = new ImageView(mContext);
                   imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
                   imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                   imageView.setPadding(8,8,8,8);
              }
              else {
                  imageView=(ImageView)convertView;
              }
              imageView.setImageResource(mThumbIds[postion]);
              return imageView;
          }
        // references to our images
        private Integer[] mThumbIds = {
                R.drawable.sample_2, R.drawable.sample_3,
                R.drawable.sample_4, R.drawable.sample_5,
                R.drawable.sample_6, R.drawable.sample_7,
                R.drawable.sample_0, R.drawable.sample_1,
                R.drawable.sample_2, R.drawable.sample_3,
                R.drawable.sample_4, R.drawable.sample_5,
                R.drawable.sample_6, R.drawable.sample_7,
                R.drawable.sample_0, R.drawable.sample_1,
                R.drawable.sample_2, R.drawable.sample_3,
                R.drawable.sample_4, R.drawable.sample_5,
                R.drawable.sample_6, R.drawable.sample_7
        };
    }
}
