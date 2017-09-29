package com.ncopado.petagram.presenter;

import android.content.Context;

import com.ncopado.petagram.db.PetRepository;
import com.ncopado.petagram.fragment.IFragmentLista;
import com.ncopado.petagram.pojo.Pet;

import java.util.ArrayList;

/**
 * Created by ncopado on 19/09/17.
 */

public class FragmentListaViewPresenter implements  IFragmentListaViewPresenter {

    private IFragmentLista iFragmentLista;
    private Context context;
    private PetRepository petRepository;
    private ArrayList<Pet> lstPet;


    public FragmentListaViewPresenter(IFragmentLista iFragmentLista, Context context) {
        this.iFragmentLista=iFragmentLista;
        this.context=context;





        getPets();

    }

    @Override
    public void getPets() {


        PetRepository petRepository=new PetRepository(context);

        lstPet=   petRepository.getPets();

        ShowPets();

    }

    @Override
    public void ShowPets() {

        iFragmentLista.AdaptadorRv(iFragmentLista.CreateAdapter(lstPet));
        iFragmentLista.CreateLinearLayoutVertical();

    }
}
