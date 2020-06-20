package com.ilopes.aprendaingles.Fragments;


import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.ilopes.aprendaingles.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NumerosFragment extends Fragment implements View.OnClickListener {

    private ImageButton b1,b2,b3,b4,b5,b6;
    private MediaPlayer mediaPlayer;
    public NumerosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_numeros, container, false);

        b1 = view.findViewById(R.id.button1);
        b2 = view.findViewById(R.id.button2);
        b3 = view.findViewById(R.id.button3);
        b4 = view.findViewById(R.id.button4);
        b5 = view.findViewById(R.id.button5);
        b6 = view.findViewById(R.id.button6);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.one);
                tocar();
                break;
            case R.id.button2:
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.two);
                tocar();
                break;
            case R.id.button3:
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.three);
                tocar();
                break;
            case R.id.button4:
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.four);
                tocar();
                break;
            case R.id.button5:
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.five);
                tocar();
                break;
            case R.id.button6:
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.six);
                tocar();
                break;
        }
    }
    public void tocar(){
        if (mediaPlayer !=null){
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mediaPlayer.release();
                }
            });
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mediaPlayer!=null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
