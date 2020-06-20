package com.ilopes.aprendaingles.Fragments;


import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.ilopes.aprendaingles.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BichosFragment extends Fragment implements View.OnClickListener {

    private ImageButton bcao,bgato,bleao,bmacaco,boveia,bvaca;
    private MediaPlayer mediaPlayer;
    public BichosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bichos, container, false);
        bcao = view.findViewById(R.id.buttonCao);
        bgato = view.findViewById(R.id.buttonGato);
        bleao = view.findViewById(R.id.buttonLeao);
        bmacaco = view.findViewById(R.id.buttonMacaco);
        boveia = view.findViewById(R.id.buttonOveia);
        bvaca =view.findViewById(R.id.buttonVaca);

        bcao.setOnClickListener(this);
        bgato.setOnClickListener(this);
        bleao.setOnClickListener(this);
        bmacaco.setOnClickListener(this);
        boveia.setOnClickListener(this);
        bvaca.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonCao:
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.dog);
                tocarsom();
                break;
            case R.id.buttonGato:
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.cat);
                tocarsom();
                break;
            case R.id.buttonLeao:
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.lion);
                tocarsom();
                break;
            case R.id.buttonMacaco:
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.monkey);
                tocarsom();
                break;
            case R.id.buttonOveia:
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.sheep);
                tocarsom();
                break;
            case R.id.buttonVaca:
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.cow);
                tocarsom();
                break;
        }
    }
    public void tocarsom(){
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
