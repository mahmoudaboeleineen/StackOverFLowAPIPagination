package com.maboe.stackoverflowapipagination.Rest;

import com.maboe.stackoverflowapipagination.model.StackApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("answers")
    Call<StackApiResponse> getAnswers(@Query("page") int page,
                                      @Query("pagesize") int size,
                                      @Query("site") String site);
}
