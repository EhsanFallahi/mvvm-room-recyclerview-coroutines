package com.example.mvvmroom.information

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmroom.R
import com.example.mvvmroom.database.StudentDatabase
import com.example.mvvmroom.database.StudentRepository
import com.example.mvvmroom.databinding.InfoFragmentBinding
import com.example.mvvmroom.list.StudentListViewModelFactory
import com.example.mvvmroom.list.StudentsListViewModel
import com.example.mvvmroomrecyclerviewex.information.InfoViewModel

class InfoFragment : Fragment() {

    private lateinit var viewModel: InfoViewModel
    private lateinit var binding: InfoFragmentBinding
    private lateinit var viewModelFactory:InfoViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.info_fragment,container,false)

        val application= requireNotNull(this.activity).application
        val studentDao= StudentDatabase.getInstance(application).studentDao
        val studentRepository= StudentRepository(studentDao)
        val arguments=InfoFragmentArgs.fromBundle(requireArguments())
        viewModelFactory= InfoViewModelFactory(studentRepository,arguments.studentId)
        viewModel= ViewModelProvider(this,viewModelFactory).get(InfoViewModel::class.java)
        binding.lifecycleOwner = this

        viewModel.getStudent().observe(viewLifecycleOwner, Observer {
            binding.apply {
                tvName.text=it.userName
                tvEmail.text=it.email
                tvPassword.text=it.password
            }
        })


        return binding.root
    }

}