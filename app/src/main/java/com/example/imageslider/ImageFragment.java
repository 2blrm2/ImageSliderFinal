package com.example.imageslider;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageFragment extends Fragment {
    private static final String TAG = "ImageFragment";
    private ImageView image;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_image,container,false);
        image = (ImageView) view.findViewById(R.id.cityImage);
        Bundle b = getArguments();
        if(null !=b){
            String url = b.getString("imageUrl","");

            Glide.with(getActivity())
                    .asBitmap()
                    .load(url)
                    .into(image);

        }
        return view;
    }
}
