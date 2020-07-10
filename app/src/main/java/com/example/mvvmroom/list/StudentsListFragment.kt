package com.example.mvvmroom.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmroom.R
import com.example.mvvmroom.database.Student
import com.example.mvvmroom.database.StudentDatabase
import com.example.mvvmroom.database.StudentRepository
import com.example.mvvmroom.databinding.LoginFragmentBinding
import com.example.mvvmroom.databinding.StudentsListFragmentBinding
import com.example.mvvmroom.login.LoginViewModel
import com.example.mvvmroom.login.LoginViewModelFactory

class StudentsListFragment : Fragment() {

    private lateinit var binding: StudentsListFragmentBinding
    private lateinit var viewModel: StudentsListViewModel
    private lateinit var viewModelFactory: StudentListViewModelFactory
    lateinit var studentListAdapter: StudentListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        binding= DataBindingUtil.inflate(inflater,R.layout.students_list_fragment,container,false)
        val application= requireNotNull(this.activity).application
        val studentDao= StudentDatabase.getInstance(application).studentDao
        val studentRepository= StudentRepository(studentDao)
        viewModelFactory= StudentListViewModelFactory(studentRepository,application)
        viewModel= ViewModelProvider(this,viewModelFactory).get(StudentsListViewModel::class.java)
        binding.lifecycleOwner = this
        binding.viewModelStudentListFragment=viewModel
        initRecyclerview()

        return binding.root
    }

    private fun initRecyclerview() {
        binding.recyclerview.apply {
            layoutManager=LinearLayoutManager(context.applicationContext)

        }
        getListStudent()
        }

    private fun getListStudent(){
        viewModel.getAllStudents.observe(viewLifecycleOwner, Observer {
            binding.recyclerview.adapter=StudentListAdapter(it,{itemSelected:Student ->listItemClicked(itemSelected)})

        })
    }
    
    private fun listItemClicked(student:Student){
        Toast.makeText(context?.applicationContext,"selected name is ${student.userName}",Toast.LENGTH_LONG).show()
    }
}

