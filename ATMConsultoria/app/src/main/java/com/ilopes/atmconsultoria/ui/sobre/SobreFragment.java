package com.ilopes.atmconsultoria.ui.sobre;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ilopes.atmconsultoria.R;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

/**
 * A simple {@link Fragment} subclass.
 */
public class SobreFragment extends Fragment {


    public SobreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_sobre, container, false);
        String descricao = "Mussum Ipsum, cacilds vidis litro abertis." +
                " Praesent vel viverra nisi. " +
                "Mauris aliquet nunc non turpis scelerisque, eget." +
                " Quem num gosta di mé, boa gentis num é. " +
                "Viva Forevis aptent taciti sociosqu ad litora torquent. " +
                "Todo mundo vê os porris que eu tomo, mas ninguém vê os tombis que eu levo!";

        Element versao = new Element();
        versao.setTitle("Versao 1.0");
        return new AboutPage(getActivity())
                .setImage(R.drawable.logo)
                .setDescription(descricao)

                .addGroup("Entre em contato")
                .addEmail("atendimento@atmconsultoria.com.br","envie um email")
                .addWebsite("https://www.google.com/","acesse o nosso site")

                .addGroup("Redes Sociais")
                .addFacebook("isaac.lopes.359","Facebook")
                .addTwitter("i_lopes_m","Twitter")
                .addInstagram("i.lopes.m","Instagram")
                .addYoutube("ilopes","Youtube")
                .addGitHub("i.lopes.m","Github")

                .addItem(versao)

                .create();

    }

}
