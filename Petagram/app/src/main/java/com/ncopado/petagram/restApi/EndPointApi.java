package com.ncopado.petagram.restApi;



import com.ncopado.petagram.restApi.Model.PetResponse;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by ncopado on 25/09/17.
 */

public interface EndPointApi {

    @GET
    Call<PetResponse> getRecemtMedia(@Url String url);

    @GET
    Call<PetResponse> getId(@Url String url);

}
