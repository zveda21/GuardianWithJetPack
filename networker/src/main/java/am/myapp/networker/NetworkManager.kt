package am.myapp.networker

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun <T> smartCalls(apiCallBack: ApiCallBack<T>): Callback<T> {
    return object : Callback<T> {
        override fun onResponse(call: Call<T>, response: Response<T>) {
            if (response.isSuccessful) {
                response.body()?.let { apiCallBack.success(it) }
            } else {
                apiCallBack.error(response.message())
            }
        }

        override fun onFailure(call: Call<T>, t: Throwable) {
            apiCallBack.failure()
        }

    }

}

interface ApiCallBack<T> {
    fun success(response: T)
    fun error(error: String)
    fun failure()
}