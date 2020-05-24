package com.example.atry.data;

import com.example.atry.presentation.model.RestPokemonResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PokeApi {

    @GET("/api/v2/pokemon/")
    Call<RestPokemonResponse> getPokemonResponse();

    /*
    @GET("/api/v2/ability/")
    Call<RestPokemonResponse> getAbility();
    */

}
