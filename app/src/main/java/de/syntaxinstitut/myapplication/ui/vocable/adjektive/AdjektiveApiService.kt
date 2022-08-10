package de.syntaxinstitut.myapplication.ui.vocable.adjektive

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import de.syntaxinstitut.myapplication.data.model.Adjektive
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

const val BASE_URL = "http://syntax-institut.com/public/apps/AichurokAlymkulova/"

//um Antworten direkt zu übersetzen wird ein moshi angelegt
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

//hier wird retrofit gebaut welche moshi und base_url verwendet
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface AdjektiveApiService {

    //GET- Request liefert Imageliste zurück
    @GET("data.json")
    suspend fun getImages(): List<Adjektive>

}
object AdjektiveApi {
    val retrofitService: AdjektiveApiService by lazy { retrofit.create(AdjektiveApiService::class.java) }
}

