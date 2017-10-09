package com.ncopado.petagram;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.ncopado.petagram.db.PetRepository;
import com.ncopado.petagram.restApi.EndPointApi;
import com.ncopado.petagram.restApi.Model.UsuarioResponse;
import com.ncopado.petagram.restApi.adapter.UsuarioRestApiAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecibirNotificacion extends AppCompatActivity {

    private String devicesID;
    private String id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    public  void GetIDDevices(View view){

        devicesID=  NotificationIDTokenService.GetIDDevices();



        enviarTokenRegistro(devicesID,id);
    }





    public  void enviarTokenRegistro(String token,String id) {

        UsuarioRestApiAdapter restApiAdapter=new UsuarioRestApiAdapter();
        EndPointApi endpoints=restApiAdapter.establecerConexionRestApi();
        Call<UsuarioResponse> usuarioResponseCall=endpoints.registroTokenID(token,id);

        usuarioResponseCall.enqueue(new Callback<UsuarioResponse>() {
            @Override
            public void onResponse(Call<UsuarioResponse> call, Response<UsuarioResponse> response) {
                UsuarioResponse usuarioResponse=response.body();
                Log.d("ID FIREBASE",usuarioResponse.getInstagramId());
                Log.d("TOKEN FIREBASE",usuarioResponse.getToken());









            }

            @Override
            public void onFailure(Call<UsuarioResponse> call, Throwable t) {

            }
        });



    }




}
