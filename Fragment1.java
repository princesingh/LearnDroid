package com.dellhell.dellhell;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class Fragment1 extends Fragment {
    ViewPager viewPager;
    CustomSwipeAdapter adapter;

    public Fragment1() {
        // Required empty public constructor
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        viewPager = (ViewPager) view.findViewById(R.id.view_pager);
        adapter = new CustomSwipeAdapter(this.getActivity());
        viewPager.setAdapter(adapter);
        return view;
    }



    public class CustomSwipeAdapter extends PagerAdapter {
        private int[] image_resource = {R.drawable.bear, R.drawable.bonobo, R.drawable.eagle, R.drawable.horse};
        private Context ctx;
        private LayoutInflater layoutInflater;

        public CustomSwipeAdapter(Context ctx) {
            this.ctx = ctx;
        }

        @Override
        public int getCount() {
            return image_resource.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return (view == (LinearLayout)object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View item_view = layoutInflater.inflate(R.layout.swipe_layout, container, false);
            ImageView imageview = (ImageView) item_view.findViewById(R.id.image_view);
            TextView textView = (TextView)  item_view.findViewById(R.id.image_count);
            imageview.setImageResource(image_resource[position]);
            textView.setText("" + position);
            container.addView(item_view);
            return item_view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((LinearLayout)object);
        }

    }
}

