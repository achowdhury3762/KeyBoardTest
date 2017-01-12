package nyc.c4q.ashiquechowdhury.keyboard.model;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ashiquechowdhury on 1/11/17.
 */

public interface KeyBoardAPI {
    @GET("cgi-bin/1_11_2017_exam.pl")
    Call<AllKeys> getAllKeys();
}
