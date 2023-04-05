package com.example.adv160420002week4.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.adv160420002week4.R
import com.example.adv160420002week4.model.Student
import com.example.adv160420002week4.util.loadImage
import com.example.adv160420002week4.viewmodel.DetailViewModel
import com.example.adv160420002week4.viewmodel.ListViewModel

class StudentDetailFragment : Fragment() {
    private lateinit var viewModel: DetailViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var studentId = "";
        if(arguments != null) {
            studentId =
                StudentDetailFragmentArgs.fromBundle(requireArguments()).studentId
        }

        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch(studentId)
        observeViewModel()
    }
    fun observeViewModel(){
        viewModel.studentLD.observe(viewLifecycleOwner, Observer {
            val txtID = view?.findViewById<TextView>(R.id.txtID)
            val txtName = view?.findViewById<TextView>(R.id.txtName)
            val txtBod = view?.findViewById<TextView>(R.id.txtBod)
            val txtPhone = view?.findViewById<TextView>(R.id.txtPhone)
            val img = view?.findViewById<ImageView>(R.id.imageView2)
            var progressBar2 = view?.findViewById<ProgressBar>(R.id.progressBar2)

            txtID?.text = viewModel.studentLD.value?.id
            txtName?.text = viewModel.studentLD.value?.name
            txtBod?.text = viewModel.studentLD.value?.bod
            txtPhone?.text = viewModel.studentLD.value?.phone
            if (progressBar2 != null) {
                img?.loadImage(viewModel.studentLD.value?.photoUrl, progressBar2)
            }

        })
    }
}