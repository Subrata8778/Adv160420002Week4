package com.example.adv160420002week4.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.adv160420002week4.R
import com.example.adv160420002week4.databinding.FragmentStudentDetailBinding
import com.example.adv160420002week4.model.Student
import com.example.adv160420002week4.util.loadImage
import com.example.adv160420002week4.viewmodel.DetailViewModel
import com.example.adv160420002week4.viewmodel.ListViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class StudentDetailFragment : Fragment() {
    private lateinit var viewModel: DetailViewModel
    private  lateinit var dataBinding: FragmentStudentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_student_detail, container, false)

        dataBinding = DataBindingUtil.inflate<FragmentStudentDetailBinding>(inflater,
            R.layout.fragment_student_detail, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        dataBinding.updatelistener = this
//        dataBinding.notiflistener = this
//
//        var studentId = "";
//        if(arguments != null) {
//            studentId =
//                StudentDetailFragmentArgs.fromBundle(requireArguments()).studentId
//        }
//
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        val studentId = StudentDetailFragmentArgs.fromBundle(requireArguments()).studentId
        viewModel.fetch(studentId)
        observeViewModel()
    }
    fun observeViewModel(){
        viewModel.studentLD.observe(viewLifecycleOwner, Observer {
            dataBinding.student = it

//            val txtID = view?.findViewById<TextView>(R.id.txtID)
//            val txtName = view?.findViewById<TextView>(R.id.txtName)
//            val txtBod = view?.findViewById<TextView>(R.id.txtBod)
//            val txtPhone = view?.findViewById<TextView>(R.id.txtPhone)
//            val img = view?.findViewById<ImageView>(R.id.imageView2)
//            var progressBar2 = view?.findViewById<ProgressBar>(R.id.progressBar2)
//            var btnNotif = view?.findViewById<Button>(R.id.btnNotif)
//
//            txtID?.text = viewModel.studentLD.value?.id
//            txtName?.text = viewModel.studentLD.value?.name
//            txtBod?.text = viewModel.studentLD.value?.bod
//            txtPhone?.text = viewModel.studentLD.value?.phone
//            if (progressBar2 != null) {
//                img?.loadImage(viewModel.studentLD.value?.photoUrl, progressBar2)
//            }

            //show notif dengan button
//            var student = it
//            btnNotif?.setOnClickListener {
//                Observable.timer(5, TimeUnit.SECONDS)
//                    .subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe {
//                        Log.d("Messages", "five seconds button")
//                        MainActivity.showNotification(student.name.toString(),
//                            "A new notification created",
//                            R.drawable.baseline_circle_24)
//                    }
//            }
        })
    }
}