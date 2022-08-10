package de.syntaxinstitut.myapplication.translate

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*

const val BASE_URL = "https://google-translate1.p.rapidapi.com/"

val mediaType = "application/x-www-form-urlencoded".toMediaTypeOrNull()


val client: OkHttpClient = OkHttpClient.Builder().addInterceptor { chain ->
    val newRequest: Request = chain.request().newBuilder()
        .addHeader("content-type", "application/x-www-form-urlencoded")
        .addHeader("Accept-Encoding", "application/gzip")
        .addHeader("X-RapidAPI-Key",  "dff97797c8mshcf1709abaa2820fp115527jsn2407952c2d05")
        .addHeader("X-RapidAPI-Host", "google-translate1.p.rapidapi.com")

        .build()
    chain.proceed(newRequest)
}.build()

//um Antworten direkt zu übersetzen wird ein moshi angelegt
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

//hier wird retrofit gebaut welche client, moshi und base_url verwendet
private val retrofit = Retrofit.Builder()
    .client(client)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface TranslationApiService {

    @FormUrlEncoded
    @POST("language/translate/v2")
    suspend fun translate(@Field("q")q: String, @Field("target")target: String, @Field("source")source: String): TranslateData
}
object TranslationApi {
    val retrofitService: TranslationApiService by lazy { retrofit.create(TranslationApiService::class.java) }
}

