package henry.code.dagger2sample;

import com.google.gson.Gson;

import dagger.Module;
import dagger.Provides;
import henry.code.dagger2sample.network.GithubService;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by henry.thetswe on 15/6/17.
 */

@Module
public class GithubServiceModule {

    @Provides
    public Retrofit retrofit(OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .baseUrl("https://api.github.com/")
                .build();
    }

    @Provides
    public GithubService githubService(Retrofit gitHubRetrofit) {
        return gitHubRetrofit.create(GithubService.class);
    }
}