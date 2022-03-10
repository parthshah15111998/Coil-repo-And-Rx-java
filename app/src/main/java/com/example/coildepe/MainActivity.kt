package com.example.coildepe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import coil.load
import coil.transform.CircleCropTransformation
import com.example.coildepe.databinding.ActivityMainBinding
import io.reactivex.Flowable.just
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.internal.operators.flowable.FlowableBlockingSubscribe.subscribe
import java.util.*
import kotlin.collections.ArrayList
import kotlin.io.println as println1

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var mList= mutableListOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15)
    var arrayList= arrayOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,150)
    var arrayList2= arrayOf(10,20,30,40,50,6,7,8,9,10,11,12,13,14,150)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageView2.load("https://www.geeksforgeeks.org/wp-content/uploads/gfg_200X200-1.png"){
            placeholder(R.drawable.ic_launcher_background)
            crossfade(5000)
            transformations(CircleCropTransformation())

            //justOperator()
            //fromOperator()
           /* rangeOperator().subscribe(
                {
                    Log.d("mainActivity","onNext:$it")
                },
                {
                    Log.d("mainActivity","onError ${it}")
                },
                {
                    Log.d("mainActivity","onComplete")
                }
            )*/
        }

    }

    fun justOperator(){
        val observable=Observable.just(mList)

        val observer= object : Observer<List<Int>> {

            /*override fun onSubscribe(d: Disposable) {
                Log.d("mainActivity","onSubscribe")
            }

            override fun onNext(t: Int) {
                Log.d("mainActivity","onNext:$t")

            }

            override fun onError(e: Throwable) {
                Log.d("mainActivity","onError ${e.toString()}")

            }

            override fun onComplete() {
                Log.d("mainActivity","onComplete")

            }*/
            override fun onSubscribe(d: Disposable) {
                Log.d("mainActivity","onSubscribe")
            }

            override fun onNext(t: List<Int>) {
                Log.d("mainActivity","onNext:$t")
            }

            override fun onError(e: Throwable) {
                Log.d("mainActivity","onError ${e.toString()}")
            }

            override fun onComplete() {
                Log.d("mainActivity","onComplete")
            }

        }

        observable.subscribe(observer)
    }

    fun fromOperator(){
        val observable=Observable.fromArray(arrayList,arrayList2)

        val observer= object : Observer<Array<Int>> {
            override fun onSubscribe(d: Disposable) {
                Log.d("mainActivity","onSubscribe")
            }

            override fun onNext(t: Array<Int>) {
                Log.d("mainActivity","onNext:${Arrays.toString(t)}")
            }

            override fun onError(e: Throwable) {
                Log.d("mainActivity","onError ${e.toString()}")
            }

            override fun onComplete() {
                Log.d("mainActivity","onComplete")
            }
        }
        observable.subscribe(observer)
    }

    fun rangeOperator():Observable<Int>{
        return Observable.range(1,100)
    }
}