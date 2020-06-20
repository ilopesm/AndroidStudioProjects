package com.ilopes.sliderprojeto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide;
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide;

public class MainActivity extends IntroActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        setButtonBackVisible(false);
        setButtonNextVisible(false);

        addSlide(new FragmentSlide.Builder()
                .background(R.color.colorAccent)
                .fragment(R.layout.intro_1)
                .build()
        );
        addSlide(new FragmentSlide.Builder()
                .background(R.color.colorAccent)
                .fragment(R.layout.intro_2)
                .build()
        );

        /*
        setButtonBackVisible(false);
        setButtonNextVisible(false);

        addSlide(new SimpleSlide.Builder()
                                .title("Titulo")
                                .description("Descição")
                                .image(R.drawable.um)
                                .background(R.color.colorAccent)
                                .build()
        );
        addSlide(new SimpleSlide.Builder()
                .title("Titulo2")
                .description("Descição2")
                .image(R.drawable.dois)
                .background(R.color.colorAccent)
                .build()
        );
        addSlide(new SimpleSlide.Builder()
                .title("Titulo3")
                .description("Descição3")
                .image(R.drawable.tres)
                .background(R.color.colorAccent)
                .build()
        );
        */
    }
}
